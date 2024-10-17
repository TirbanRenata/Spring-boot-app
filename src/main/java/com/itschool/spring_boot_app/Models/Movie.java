package com.itschool.spring_boot_app.Models;


import lombok.Data;

@Data
public class Movie {
    private String title;
    private String director;
    private String gen;
    private int releaseYear;
    private String description;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
