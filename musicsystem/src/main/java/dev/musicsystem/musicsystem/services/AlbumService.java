package dev.musicsystem.musicsystem.services;

import dev.musicsystem.musicsystem.entity.Album;
import dev.musicsystem.musicsystem.entity.Comment;
import dev.musicsystem.musicsystem.entity.Review;
import dev.musicsystem.musicsystem.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CommentService commentService;

    public List<Album> AllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbumByAlbum_id(Long album_id) {
        return albumRepository.findById(album_id).orElse(null);
    }

    public Review getReviewByAlbum_id(Long album_id) {
        return reviewService.getReviewByAlbum_id(album_id);
    }

    public List<Comment> getCommentsByReviewId(Long review_id) {
        return commentService.getCommentsByReview_id(review_id);
    }
}
