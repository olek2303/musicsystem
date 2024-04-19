package dev.musicsystem.musicsystem.repositories;

import dev.musicsystem.musicsystem.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.album.album_id = :albumId")
    Review getReviewByAlbum_Album_id(@Param("albumId") Long albumId);
}


