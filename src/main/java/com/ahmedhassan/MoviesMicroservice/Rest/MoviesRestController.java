package com.ahmedhassan.MoviesMicroservice.Rest;


import com.ahmedhassan.MoviesMicroservice.DTO.MovieDTO;
import com.ahmedhassan.MoviesMicroservice.DTO.MovieDetailsDTO;
import com.ahmedhassan.MoviesMicroservice.Entity.Movie;
import com.ahmedhassan.MoviesMicroservice.Entity.MovieDetail;
import com.ahmedhassan.MoviesMicroservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MoviesRestController {

    private final MovieService movieService;
    @Autowired
    public MoviesRestController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<Page<Movie>> getMovies(Pageable page){
        System.out.println("in movies endpoint page " + page );
        return ResponseEntity.ok(movieService.getMovies(page));
    }
    @GetMapping("/movies/{movieId}")
    public Optional<MovieDetail> getMovieDetails(@PathVariable long movieId){
        return movieService.getMovieDetails(movieId);
    }
    @PostMapping("/movies")
    public long addMovies(@RequestBody MovieDTO movieDTO){
        return movieService.addMovie(movieDTO);
    }
    @PostMapping("/moviedetails")
    public long addMovieDetails(@RequestBody MovieDetailsDTO movieDetailsDTO){
        return movieService.addMovieDetails(movieDetailsDTO);
    }
}
