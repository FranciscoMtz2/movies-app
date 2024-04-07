package dev.franless.movies.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import dev.franless.movies.model.Review;

public interface ReviewRepository extends MongoRepository<Review, ObjectId>{
    
}
