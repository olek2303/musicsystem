package dev.musicsystem.musicsystem.controllers;

import dev.musicsystem.musicsystem.entity.Album;
import dev.musicsystem.musicsystem.entity.Comment;
import dev.musicsystem.musicsystem.entity.Review;
import dev.musicsystem.musicsystem.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(albumService.AllAlbums(), HttpStatus.OK);
    }

    @GetMapping("/{album_id}")
    public ResponseEntity<Map<String, Object>> getAlbumById(@PathVariable Long album_id) {

        Album album = albumService.getAlbumByAlbum_id(album_id);

        if (album == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Review review = albumService.getReviewByAlbum_id(album_id);

        List<Comment> comments = albumService.getCommentsByReviewId(review.getReview_id());

        Map<String, Object> response = new HashMap<>();
        response.put("album", album);
        response.put("review", review);
        response.put("comments", comments);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
