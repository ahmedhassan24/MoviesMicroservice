package com.ahmedhassan.MoviesMicroservice.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class MovieDTO {

    private Long id;
    private boolean adult;
    private String backdropPath;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String posterPath;
    private Date releaseDate;
    private String title;
    private boolean video;
    private double voteAverage;
    private int voteCount;
}
