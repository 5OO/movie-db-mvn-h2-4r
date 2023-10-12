package com.jdb.moviedbmvnh24r.repository;


import com.jdb.moviedbmvnh24r.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
