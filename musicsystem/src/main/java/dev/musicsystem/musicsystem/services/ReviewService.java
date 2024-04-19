package dev.musicsystem.musicsystem.services;

import dev.musicsystem.musicsystem.entity.Review;
import dev.musicsystem.musicsystem.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


}
