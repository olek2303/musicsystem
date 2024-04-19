package dev.musicsystem.musicsystem.repositories;

import dev.musicsystem.musicsystem.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByReviewReview_id(Long reviewId);
}
