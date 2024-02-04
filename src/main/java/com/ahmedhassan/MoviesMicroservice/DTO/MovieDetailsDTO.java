package com.ahmedhassan.MoviesMicroservice.DTO;

import com.ahmedhassan.MoviesMicroservice.Entity.Movie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class MovieDetailsDTO {

    private Long id;
    private Movie movie;
    private boolean adult;
    private String backdropPath;
    private double budget;
    private String homepage;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String posterPath;
    private Date releaseDate;
    private double revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double voteAverage;
    private int voteCount;
    private String genreIds;
    private String spokenLanguages;
    private String productionCompanies;
    private String productionCountries;

}
