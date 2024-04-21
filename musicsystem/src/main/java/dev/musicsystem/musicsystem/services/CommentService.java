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

    public List<Comment> AllComments() { return commentRepository.findAll(); }
    public List<Comment> getCommentsByReviewId(Long reviewId) {
        return commentRepository.findByReviewReviewId(reviewId);
    }

    public boolean commentExists(Comment comment) { return commentRepository.existsById(comment.getCommentId()); }

    public Comment saveComment(Comment comment) {
        try {
            return commentRepository.save(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment commentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }
}
