package dev.franless.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.franless.movies.model.Movie;
import dev.franless.movies.repository.MovieRepository;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return repository.findByImdbId(imdbId);
    };

}
