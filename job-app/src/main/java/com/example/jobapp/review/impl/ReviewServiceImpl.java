package com.example.jobapp.review.impl;

import com.example.jobapp.review.Review;
import com.example.jobapp.review.ReviewRepository;
import com.example.jobapp.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review deleteReviewById(int reviewId) {
        Review review = getReviewById(reviewId);
        reviewRepository.deleteById(reviewId);
        return review;
    }

    @Override
    public Review updateReview(int reviewId, Review updatedReview) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if(optionalReview.isPresent()){
            updatedReview.setReviewId(reviewId);
            reviewRepository.save(updatedReview);
            return updatedReview;
        }
        return null;
    }
}
