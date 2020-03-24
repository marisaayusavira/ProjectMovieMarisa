package com.example.project3.network;

import com.example.project3.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apinterface {
    @GET (Constant.MOVIE_PATH + "/popular")
        Call<Movie> popularMovies(
                @Query("page") int page);


    @GET (Constant.MOVIE_PATH + "/{movie_id}/similar")
    Call<Movie> similarMovie(
            @Query("page") int page);
}
