package com.ahmedhassan.MoviesMicroservice.service;

import com.ahmedhassan.MoviesMicroservice.Entity.Movie;
import com.ahmedhassan.MoviesMicroservice.Entity.MovieDetail;
import com.ahmedhassan.MoviesMicroservice.Repo.MovieDetailsRepo;
import com.ahmedhassan.MoviesMicroservice.Repo.MovieRepo;
import com.ahmedhassan.MoviesMicroservice.Service.MovieService;
import com.ahmedhassan.MoviesMicroservice.Service.MovieServiceImpl;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@DirtiesContext
public class MoviesServiceTest {

    @Resource
    private MovieRepo movieRepo;
    @Resource
    private MovieDetailsRepo movieDetailsRepo;



    private MovieService movieService;



    @BeforeEach
    public void init(){
        movieService = new MovieServiceImpl( movieRepo, movieDetailsRepo);
        Movie movie1 = new Movie();
        movie1.setId(1L);
        movie1.setTitle("movie title");
        movieRepo.save(movie1);
        MovieDetail movieDetails1 = new MovieDetail();
        movieDetails1.setId(1L);
        movieDetails1.setTitle("movie title detail");
        movieDetailsRepo.save(movieDetails1);
    }

    @Test
    public void getMovies(){
        Pageable page = PageRequest.of(0, 5);

        Page<Movie> movieList = movieService.getMovies(page);
        System.out.println(movieList.getContent().getFirst().getTitle());
    }
    @Test
    public void getMoviesDetail(){
        Optional<MovieDetail> movie = movieService.getMovieDetails(1);
        System.out.println(movie.get().getTitle());
    }

}
