package dev.musicsystem.musicsystem.services;

import dev.musicsystem.musicsystem.entity.Review;
import dev.musicsystem.musicsystem.entity.User;
import dev.musicsystem.musicsystem.repositories.ReviewRepository;
import org.apache.catalina.valves.rewrite.RewriteCond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> AllReviews() {
        return reviewRepository.findAll();
    }

    public Review reviewById(Long id) {
        return reviewRepository.getReviewByAlbumId(id);
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
