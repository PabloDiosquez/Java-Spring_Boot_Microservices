package com.example.jobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAll();

    Review getReviewById(int reviewId);

    void createReview(Review review);

    Review deleteReviewById(int reviewId);

    Review updateReview(int reviewId, Review updatedReview);
}
