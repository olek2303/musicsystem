package dev.musicsystem.musicsystem.services;

import dev.musicsystem.musicsystem.entity.Comment;
import dev.musicsystem.musicsystem.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByReview_id(Long reviewId) {
        return commentRepository.findByReview_id(reviewId);
    }

}
