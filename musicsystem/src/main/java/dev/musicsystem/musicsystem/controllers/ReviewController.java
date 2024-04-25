package dev.musicsystem.musicsystem.controllers;

import dev.musicsystem.musicsystem.entity.Album;
import dev.musicsystem.musicsystem.entity.Comment;
import dev.musicsystem.musicsystem.entity.Review;
import dev.musicsystem.musicsystem.entity.User;
import dev.musicsystem.musicsystem.services.AlbumService;
import dev.musicsystem.musicsystem.services.ReviewService;
import dev.musicsystem.musicsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @Autowired
    private AlbumService albumService;

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllReviews() {
        List<Review> reviews = reviewService.AllReviews();

        Map<String, Object> response = new HashMap<>();
        List<User> users = new ArrayList<>();
        List<Album> albums = new ArrayList<>();

        for(Review review : reviews) {
            User u = userService.UserById(review.getUser().getUserId());
            Album a = albumService.AlbumById(review.getAlbum().getAlbumId());

            if (u == null) {
                continue;
            }
            if (a == null) {
                continue;
            }
            users.add(u);
            albums.add(a);
        }
        response.put("reviews", reviews);
        response.put("users", users);
        response.put("albums", albums);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "", name = "addNewReview")
    public ResponseEntity<Void> addReview(@RequestBody Review review) {
        Review newReview = reviewService.addReview(review);
        if (newReview != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{reviewId}", name="updateReview")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId, @RequestBody Review updatedReview) {
        Review existingReview = reviewService.reviewById(reviewId);
        if (existingReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedReview.setReviewId(reviewId);
        Review savedReview = reviewService.addReview(updatedReview);
        if (savedReview == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedReview, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{reviewId}", name = "deleteReview")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        Review existingReview = reviewService.reviewById(reviewId);
        if (existingReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            reviewService.deleteReview(reviewId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
