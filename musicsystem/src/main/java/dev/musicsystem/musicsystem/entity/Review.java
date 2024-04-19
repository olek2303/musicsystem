package dev.musicsystem.musicsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @OneToOne
    @JoinColumn(name = "albumId")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Integer rating;

}