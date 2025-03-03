package dev.musicsystem.musicsystem.services;

import dev.musicsystem.musicsystem.entity.Album;
import dev.musicsystem.musicsystem.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album AlbumById(Long albumId) { return albumRepository.findById(albumId).orElse(null);}
    public List<Album> AllAlbums() {
        return albumRepository.findAll();
    }

    public Album albumByAlbumId(Long albumId) { return albumRepository.findById(albumId).orElse(null);}

    public boolean albumExists(Album album) { return albumRepository.existsById(album.getAlbumId()); }

    public Album saveAlbum(Album album) {
        try {
            return albumRepository.save(album);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void deleteAlbum(Long albumId) {
        albumRepository.deleteById(albumId);
    }


}
