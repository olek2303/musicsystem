package dev.musicsystem.musicsystem.services;

import dev.musicsystem.musicsystem.entity.Album;
import dev.musicsystem.musicsystem.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> AllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> AlbumById(int id) {
        return albumRepository.findById(id);
    }
}
