package com.ahmedhassan.MoviesMicroservice.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;



@Entity
@Table(name= "movies")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "adult")
    private boolean adult;
    @Column(name = "backdrop_path")
    private String backdropPath;
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
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "title")
    private String title;
    @Column(name = "video" )
    private boolean video;
    @Column(name = "vote_average")
    private double voteAverage;
    @Column(name = "vote_count")
    private int voteCount;

    public Movie() {
    }

//    public Movie(Long id, boolean adult, String backdropPath, String originalLanguage, String originalTitle, String overview, double popularity, String posterPath, Date releaseDate, String title, boolean video, double voteAverage, int voteCount) {
//        this.id = id;
//        this.adult = adult;
//        this.backdropPath = backdropPath;
//        this.originalLanguage = originalLanguage;
//        this.originalTitle = originalTitle;
//        this.overview = overview;
//        this.popularity = popularity;
//        this.posterPath = posterPath;
//        this.releaseDate = releaseDate;
//        this.title = title;
//        this.video = video;
//        this.voteAverage = voteAverage;
//        this.voteCount = voteCount;
//    }
}
