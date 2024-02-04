package com.ahmedhassan.MoviesMicroservice.Service;

import com.ahmedhassan.MoviesMicroservice.DTO.MovieDTO;
import com.ahmedhassan.MoviesMicroservice.DTO.MovieDetailsDTO;
import com.ahmedhassan.MoviesMicroservice.Entity.Movie;
import com.ahmedhassan.MoviesMicroservice.Entity.MovieDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Page<Movie> getMovies(Pageable page);

    Optional<MovieDetail> getMovieDetails(long movieId);

    long addMovieDetails(MovieDetailsDTO movieDetailsDTO);

    long addMovie(MovieDTO movieDTO);

}
