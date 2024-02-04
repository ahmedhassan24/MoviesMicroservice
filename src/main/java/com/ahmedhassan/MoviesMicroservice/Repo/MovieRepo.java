package com.ahmedhassan.MoviesMicroservice.Repo;

import com.ahmedhassan.MoviesMicroservice.Entity.Movie;
import jakarta.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  MovieRepo extends JpaRepository<Movie,Integer> {
    Page<Movie> findAll(@Nonnull Pageable page);
}
