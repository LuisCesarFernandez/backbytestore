package com.bytestore.backbytestore.controller.reviewController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestore.backbytestore.model.review.Review;
import com.bytestore.backbytestore.service.reviewService.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(path = "/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PreAuthorize("permitAll()")
    @GetMapping("/")
    public List<Review> listReview() {
        return reviewService.getAllReview();
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public Optional<Review> listIdReview(@PathVariable Long id) {
        return reviewService.getIdReview(id);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/")
    public String createReview(@RequestBody Review review) {  
        reviewService.postReview(review);
        return "review created";
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    public String updateReview(@PathVariable Long id, @RequestBody Review review) {
        reviewService.putReview(id, review);
        return "review updated";
    }
    
    
}
