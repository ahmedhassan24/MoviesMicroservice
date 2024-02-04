package com.ahmedhassan.MoviesMicroservice.Response;

import com.ahmedhassan.MoviesMicroservice.Entity.MovieDetail;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageResponse {
    String message;
    MovieDetail movieDetail;
    Boolean status;

    public MessageResponse(String message, Boolean status, MovieDetail movieDetail) {
        this.message = message;
        this.status = status;
        this.movieDetail = movieDetail;
    }
}
