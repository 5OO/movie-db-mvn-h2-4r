package com.jdb.moviedbmvnh24r.service;

import com.jdb.moviedbmvnh24r.model.Movie;
import com.jdb.moviedbmvnh24r.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie findMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }


}
