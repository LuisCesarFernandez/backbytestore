package com.bytestore.backbytestore.security;

import com.bytestore.backbytestore.security.Filters.JwtAuthenticationFilter;
import com.bytestore.backbytestore.security.jwt.JwtUtils;
import com.bytestore.backbytestore.service.loginService.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    JwtUtils jwtUtils;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           AuthenticationManager authenticationManager) throws Exception{
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);

        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login").permitAll()
//                        .requestMatchers("/error").permitAll()
//                        .requestMatchers("/").permitAll()
                        .requestMatchers("/product/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/user/**").hasRole("ADMIN")
                        .requestMatchers("/brand/**").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .addFilter(jwtAuthenticationFilter);

        return http.build();
    }

    /*   @Bean
       public UserDetailsService users() {
           UserDetails user = User.builder()
                   .username("Manuel")
                   .password("{noop}123456")
                   .roles("USER")
                   .build();
           UserDetails admin = User.builder()
                   .username("Samuel")
                   .password("{noop}654321")
                   .roles("ADMIN")
                   .build();

           return new InMemoryUserDetailsManager(user, admin);
       }
   */

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(CustomUserDetailsService customUserDetailsService,
                                                PasswordEncoder passwordEncoder) throws Exception{
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(provider);
    }

}
