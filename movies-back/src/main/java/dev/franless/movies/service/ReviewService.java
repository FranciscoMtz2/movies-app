package dev.franless.movies.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.franless.movies.model.Movie;
import dev.franless.movies.model.Review;
import dev.franless.movies.repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review creatReview(String reviewBody, String imdbId) {
        // Save the review
        Review review = repository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now()));
        // Update movie reviews
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();
        return review;
    }

}
