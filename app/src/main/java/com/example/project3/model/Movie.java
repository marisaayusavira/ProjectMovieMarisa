package com.example.project3.model;

import com.google.gson.annotations.SerializedName;

public class Movie extends BaseModel<MovieData> {
    @SerializedName("total_results")
        public Integer totalResult;
    @SerializedName("total_pages")
        public Integer totalPages;

    public Movie(){

    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
