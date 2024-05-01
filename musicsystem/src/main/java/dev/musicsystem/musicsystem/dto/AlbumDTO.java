package dev.musicsystem.musicsystem.dto;

import dev.musicsystem.musicsystem.entity.Album;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {
    private Long albumId;
    private String title;
    private String artist;
    private Date releaseDate;
    private String photoUrl;

    public AlbumDTO(Album album) {
        this.albumId = album.getAlbumId();
        this.title = album.getTitle();
        this.artist = album.getArtist();
        this.releaseDate = album.getRelease_date();
    }
}
