package com.example.jobapp.review.impl;

import com.example.jobapp.review.Review;
import com.example.jobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Override
    public List<Review> getAll() {
        return null;
    }

    @Override
    public Review getReviewById(int reviewId) {
        return null;
    }

    @Override
    public void createReview(Review review) {

    }

    @Override
    public Review deleteReviewById(int reviewId) {
        return null;
    }

    @Override
    public Review updateReview(int reviewId, Review updatedReview) {
        return null;
    }
}
