package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepo;


@Service
public class MovieServiceImp implements MovieService {
	
	@Autowired
	MovieRepo movieRepository;
	
	
	
	 public MovieServiceImp(MovieRepo movieRepository) {
	        this.movieRepository = movieRepository;
	    }

	@Override
	public Movie getMovieById(Integer id) {
		
		  return movieRepository.findById(id).orElse(null);
	}

	@Override
	public List<Movie> getAllMovies() {
		 return movieRepository.findAll();
	}

	
	@Override
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		
	            return movieRepository.save(movie);
	      
	}

	@Override
	public void deleteMovie(Integer id) {
		 movieRepository.deleteById(id);
		
	}

	/*
	 * @Override public List<Movie> searchMoviesByMovie_Title(String movie_title) {
	 * return movieRepository.findByMovie_TitleContainingIgnoreCase(movie_title); }
	 */
}
