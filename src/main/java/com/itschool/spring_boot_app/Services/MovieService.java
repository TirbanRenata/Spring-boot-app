package com.itschool.spring_boot_app.Services;

import com.itschool.spring_boot_app.Models.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public List<Movie> getAllMovies() {
        Movie m = new Movie();
        m.setTitle("ABC");
        m.setDescription("E cu Aladin");
        m.setGen("Actiune");
        m.setReleaseYear(2012);
        m.setDirector("Sam");

        addMovie(m);
        return movies;
    }

    public void addMovie(Movie m) {
        movies.add(m);
    }
}
