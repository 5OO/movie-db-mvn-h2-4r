package com.jdb.moviedbmvnh24r.repository;


import com.jdb.moviedbmvnh24r.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {


    List<Movie> findMovieByVoteAverageIsGreaterThan(BigDecimal voteAverage);


}
