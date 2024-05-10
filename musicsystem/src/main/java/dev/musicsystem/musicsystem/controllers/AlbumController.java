package dev.musicsystem.musicsystem.controllers;

import dev.musicsystem.musicsystem.dto.AlbumDTO;
import dev.musicsystem.musicsystem.entity.Album;
import dev.musicsystem.musicsystem.entity.Comment;
import dev.musicsystem.musicsystem.entity.Review;
import dev.musicsystem.musicsystem.repositories.ReviewRepository;
import dev.musicsystem.musicsystem.services.AlbumService;
import dev.musicsystem.musicsystem.services.CommentService;
import dev.musicsystem.musicsystem.services.GoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CommentService commentService;

    @Autowired
    private GoogleDriveService googleDriveService;

    @GetMapping("")
    public ResponseEntity<List<AlbumDTO>> getAllAlbums() throws IOException {
        List<Album> albums = albumService.AllAlbums();
        List<AlbumDTO> albumsDto = new ArrayList<>();
        for(Album album : albums) {
            AlbumDTO albumDto = new AlbumDTO(album);
            String name = album.getTitle() + ".jpg";
            ByteArrayOutputStream photoStream = GoogleDriveService.downloadFileByName(name);
            String base64img = Base64.getEncoder().encodeToString(photoStream.toByteArray());
            albumDto.setPhotoUrl("data:image/jpeg;base64," + base64img);
            albumsDto.add(albumDto);
        }
        return new ResponseEntity<>(albumsDto, HttpStatus.OK);
    }

    @GetMapping("/{albumId}")
    public ResponseEntity<Map<String, Object>> getReviewByAlbumId(@PathVariable Long albumId) {
        Album album = albumService.albumByAlbumId(albumId);

        if (album == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Review review = reviewRepository.getReviewByAlbumId(albumId);

        if (review == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Comment> comments = commentService.getCommentsByReviewId(review.getReviewId());

        List<Comment> filteredComments = comments.stream()
                .filter(comment -> !comment.getUser().getRoles().equals("ADMIN"))
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("album", album);
        response.put("review", review);
        response.put("comments", filteredComments);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        if (albumService.albumExists(album)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Album savedAlbum = albumService.saveAlbum(album);

        if (savedAlbum == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(savedAlbum, HttpStatus.CREATED);
    }

    @PutMapping("/{album_id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long albumId, @RequestBody Album updatedAlbum) {
        Album existingAlbum = albumService.albumByAlbumId(albumId);

        if (existingAlbum == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        updatedAlbum.setAlbumId(albumId);

        Album savedAlbum = albumService.saveAlbum(updatedAlbum);

        if (savedAlbum == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(savedAlbum, HttpStatus.OK);
    }

    @DeleteMapping("/{album_id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long albumId) {
        Album existingAlbum = albumService.albumByAlbumId(albumId);

        if (existingAlbum == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            albumService.deleteAlbum(albumId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
