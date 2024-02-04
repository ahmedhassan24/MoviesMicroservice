package com.ahmedhassan.MoviesMicroservice.Service;


import com.ahmedhassan.MoviesMicroservice.DTO.MovieDTO;
import com.ahmedhassan.MoviesMicroservice.DTO.MovieDetailsDTO;
import com.ahmedhassan.MoviesMicroservice.Entity.Movie;
import com.ahmedhassan.MoviesMicroservice.Entity.MovieDetail;
import com.ahmedhassan.MoviesMicroservice.Repo.MovieDetailsRepo;
import com.ahmedhassan.MoviesMicroservice.Repo.MovieRepo;
import jakarta.annotation.Nullable;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{



    private MovieRepo movieRepo;
    private MovieDetailsRepo movieDetailsRepo;
    private ModelMapper modelMapper;
    @Autowired
    public MovieServiceImpl(MovieRepo movieRepo, MovieDetailsRepo movieDetailsRepo, ModelMapper modelMapper) {
        this.movieRepo = movieRepo;
        this.movieDetailsRepo = movieDetailsRepo;
        this.modelMapper = modelMapper;
    }

    public MovieServiceImpl(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public MovieServiceImpl(MovieRepo movieRepo, MovieDetailsRepo movieDetailsRepo) {
        this.movieRepo = movieRepo;
        this.movieDetailsRepo = movieDetailsRepo;
    }

    @Override
    @Nullable
    public Page<Movie> getMovies(Pageable page) {
        page = PageRequest.of(page.getPageNumber(), page.getPageSize());
        return movieRepo.findAll(page);
    }

    @Nullable
    @Override
    public Optional<MovieDetail> getMovieDetails(long movieId) throws NoSuchElementException {

        Optional<MovieDetail> movie = null;

        movie= movieDetailsRepo.findByMovie_Id(movieId);
        System.out.println(movie.get());
        return movie;
    }

    @Override
    public long addMovieDetails(MovieDetailsDTO movieDetailsDTO) {
        MovieDetail movieDetail = new MovieDetail();
        movieDetail.setMovie(movieDetailsDTO.getMovie());
        movieDetail.setAdult(movieDetailsDTO.isAdult());
        movieDetail.setBackdropPath(movieDetailsDTO.getBackdropPath());
        movieDetail.setBudget(movieDetailsDTO.getBudget());
        movieDetail.setHomepage(movieDetailsDTO.getHomepage());
        movieDetail.setImdbId(movieDetailsDTO.getImdbId());
        movieDetail.setOriginalLanguage(movieDetailsDTO.getOriginalLanguage());
        movieDetail.setOriginalTitle(movieDetailsDTO.getOriginalTitle());
        movieDetail.setTitle(movieDetailsDTO.getTitle());
        movieDetail.setGenreIds(movieDetailsDTO.getGenreIds());
        movieDetail.setProductionCompanies(movieDetailsDTO.getProductionCompanies());
        movieDetail.setProductionCountries(movieDetailsDTO.getProductionCountries());


//        ModelMapper modelMapper = new ModelMapper();
//        movieDetail = modelMapper.map(movieDetailsDTO, MovieDetail.class);
//

        movieDetailsRepo.save(movieDetail);
        return movieDetail.getId();
    }

    @Override
    public long addMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setAdult(movieDTO.isAdult());
        movie.setBackdropPath(movieDTO.getBackdropPath());
        movie.setOriginalLanguage(movieDTO.getOriginalLanguage());
        movie.setOriginalTitle(movieDTO.getOriginalTitle());
        movie.setOverview(movieDTO.getOverview());
        movie.setPopularity(movieDTO.getPopularity());
        movie.setPosterPath(movieDTO.getPosterPath());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setTitle(movieDTO.getTitle());
        movie.setVideo(movieDTO.isVideo());
        movie.setVoteAverage(movieDTO.getVoteAverage());
        movie.setVoteCount(movieDTO.getVoteCount());
//        modelMapper = new ModelMapper();
//        movie = modelMapper.map(movieDTO, Movie.class);
//        TypeMap<MovieDTO,Movie> typeMap = modelMapper.createTypeMap(MovieDTO.class, Movie.class);

        movieRepo.save(movie);
        return movie.getId();
    }
}
