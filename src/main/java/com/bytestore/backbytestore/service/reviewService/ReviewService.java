package com.bytestore.backbytestore.service.reviewService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestore.backbytestore.model.review.Review;
import com.bytestore.backbytestore.repository.reviewRepository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getIdReview(Long id) {
        return reviewRepository.findById(id);
    }

    public String postReview(Review review) {
        reviewRepository.save(review);
        return "review created";
    }

    public String putReview(Long id, Review review) {
        review.setId_review(id);
        reviewRepository.save(review);
        return "update review";
    }

}
