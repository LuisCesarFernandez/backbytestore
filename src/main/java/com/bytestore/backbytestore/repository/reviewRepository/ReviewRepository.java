package com.bytestore.backbytestore.repository.reviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytestore.backbytestore.model.review.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}
