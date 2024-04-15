package dev.musicsystem.musicsystem.repositories;

import dev.musicsystem.musicsystem.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
