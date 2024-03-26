package com.example.jobapp.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/companies/{companyId}/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAll(){
        return new ResponseEntity<>(reviewService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable(name = "reviewId") int reviewId){
        Review review = reviewService.getReviewById(reviewId);
        return review != null
                ? new ResponseEntity<>(review, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody Review review){
        if(review != null){
            reviewService.createReview(review);
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "/{reviewId}")
    public ResponseEntity<Review> deleteReviewById(@PathVariable(name = "reviewId") int reviewId){
        Review review = reviewService.getReviewById(reviewId);
        return review != null
                ? new ResponseEntity<>(reviewService.deleteReviewById(reviewId), HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable(name = "reviewId") int reviewId, @RequestBody Review updatedReview){
        Review review = reviewService.getReviewById(reviewId);
        return review != null
                ? new ResponseEntity<>(reviewService.updateReview(reviewId, updatedReview), HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
