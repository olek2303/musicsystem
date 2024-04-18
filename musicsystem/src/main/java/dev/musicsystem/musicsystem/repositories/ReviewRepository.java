package dev.musicsystem.musicsystem.repositories;

import dev.musicsystem.musicsystem.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByRelatedAlbum_Album_id(Long albumId);
}


