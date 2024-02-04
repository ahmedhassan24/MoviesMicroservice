package com.ahmedhassan.MoviesMicroservice.Repo;

import com.ahmedhassan.MoviesMicroservice.Entity.MovieDetail;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieDetailsRepo extends JpaRepository<MovieDetail, Long> {
    Optional<MovieDetail> findByMovie_Id(Long movie_id);
}
