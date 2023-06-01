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

	@Override
	public Movie createMovie(Movie movie) {
		// TODO Auto-generated method stub
		return  movieRepository.save(movie);
	}

	@Override
	public boolean checkMovieId(int movie_id) {
		// TODO Auto-generated method stub
		return movieRepository.existsById(movie_id);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

}
	
	
	
	 

