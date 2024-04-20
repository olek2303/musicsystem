package dev.musicsystem.musicsystem.controllers;

import dev.musicsystem.musicsystem.entity.Album;
import dev.musicsystem.musicsystem.entity.Review;
import dev.musicsystem.musicsystem.entity.User;
import dev.musicsystem.musicsystem.services.AlbumService;
import dev.musicsystem.musicsystem.services.ReviewService;
import dev.musicsystem.musicsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
