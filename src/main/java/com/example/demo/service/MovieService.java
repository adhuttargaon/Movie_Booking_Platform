package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Movie;

public interface MovieService {
	
	
	

    List<Movie> getAllMovies();

   // List<Movie> searchMoviesByMovie_Title(String movie_title);

    Movie createMovie(Movie movie);

    Movie updateMovie(Movie movie);

    

	Movie getMovieById(Integer id);

	void deleteMovie(Integer id);

}
