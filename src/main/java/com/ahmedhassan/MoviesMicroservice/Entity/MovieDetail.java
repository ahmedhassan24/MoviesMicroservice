package com.ahmedhassan.MoviesMicroservice.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "movie_details")
public class MovieDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @Column(name = "adult")
    private boolean adult;

    @Column(name = "backdrop_path")
    private String backdropPath;

    @Column(name = "budget")
    private double budget;

    @Column(name = "homepage")
    private String homepage;

    @Column(name = "imdb_id")
    private String imdbId;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "overview")
    private String overview;

    @Column(name = "popularity")
    private double popularity;

    @Column(name = "poster_path")
    private String posterPath;

    @Column(name = "release_date ")
    private Date releaseDate;

    @Column(name = "revenue")
    private double revenue;

    @Column(name = "runtime")
    private int runtime;

    @Column(name = "status")
    private String status;

    @Column(name = "tagline")
    private String tagline;

    @Column(name = "title")
    private String title;

    @Column(name = "video")
    private boolean video;

    @Column(name = "vote_average")
    private double voteAverage;

    @Column(name = "vote_count")
    private int voteCount;

    @Column(name = "genre_ids")
    private String genreIds;

    @Column(name = "spoken_languages")
    private String spokenLanguages;

    @Column(name = "production_companies", columnDefinition = "TEXT")
    private String productionCompanies;

    @Column(name = "production_countries", columnDefinition = "TEXT")
    private String productionCountries;

}
