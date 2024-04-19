package dev.musicsystem.musicsystem.services;

import dev.musicsystem.musicsystem.entity.Album;
import dev.musicsystem.musicsystem.entity.Comment;
import dev.musicsystem.musicsystem.entity.Review;
import dev.musicsystem.musicsystem.repositories.AlbumRepository;
import dev.musicsystem.musicsystem.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> AllAlbums() {
        return albumRepository.findAll();
    }

    public Album albumByAlbum_Id(Long album_id) {return albumRepository.findById(album_id).orElse(null);}

}
