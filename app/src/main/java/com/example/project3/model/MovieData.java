package com.example.project3.model;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.RequestCreator;

import java.util.List;

public class MovieData {
    @SerializedName("id")
    public Integer id;
    @SerializedName("original_title")
    public String original_tittle;
    @SerializedName("original_languange")
    public String original_languange;
    @SerializedName("title")
    public String tittle;
    @SerializedName("backdrop_path")
    public String backdrop_path;
    @SerializedName("popularity")
    public double popularity;
    @SerializedName("vote_count")
    public Integer vote_count;
    @SerializedName("video")
    public boolean video;
    @SerializedName("adult")
    public boolean adult;
    @SerializedName("overview")
    public String overview;
    @SerializedName("release_date")
    public String releaseDate;
    @SerializedName("vote_average")
    public double vote_average;
    @SerializedName("poster_path")
    public String poster_path;
    @SerializedName("genre")
    public List<Integer> genre;

    public MovieData(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginal_tittle() {
        return original_tittle;
    }

    public void setOriginal_tittle(String original_tittle) {
        this.original_tittle = original_tittle;
    }

    public String getOriginal_languange() {
        return original_languange;
    }

    public void setOriginal_languange(String original_languange) {
        this.original_languange = original_languange;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<Integer> getGenre() {
        return genre;
    }

    public void setGenre(List<Integer> genre) {
        this.genre = genre;
    }
}

