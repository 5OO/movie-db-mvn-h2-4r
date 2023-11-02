package com.jdb.moviedbmvnh24r.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "original_title", length = 86, nullable = false)
    private String originalTitle;

    @Column(name = "overview", length = 1000, nullable = false)
    private String overview;

    @Column(name = "popularity", precision = 10, scale = 6, nullable = false)
    private BigDecimal popularity;

    @Column(name = "release_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "revenue", nullable = false)
    private Long revenue;

    @Column(name = "runtime", precision = 5, scale = 1, nullable = false)
    private BigDecimal runtime;

    @Column(name = "tagline", length = 252)
    private String tagline;

    @Column(name = "title", length = 86, nullable = false)
    private String title;

    @Column(name = "vote_average", precision = 4, scale = 1, nullable = false)
    private BigDecimal voteAverage;

    @Column(name = "vote_count", nullable = false)
    private Integer voteCount;
}
