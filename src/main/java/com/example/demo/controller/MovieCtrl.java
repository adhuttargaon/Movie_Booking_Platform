package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepo;
import com.example.demo.service.MovieService;

@Controller
//shows data on browser
/*@RestController
@CrossOrigin(origins="http://localhost:3001")*/
public class MovieCtrl {
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	MovieService movieService;
	

	/*
	 * @GetMapping("/movie") public List<Movie> getAllMovie(){ return
	 * movieRepo.findAll();
	 * 
	 * }
	 */
	
	
	  @GetMapping("/")
	  public String showMoviePage(Model model) { 
		  
	 List<Movie> list=movieService.getAllMovies(); 
	 model.addAttribute("movies",list);
	  return  "home";
	  }
	  
		
		  @RequestMapping("/movies/create") public String showCreateMovieForm(Model
		  model) { model.addAttribute("movie", new Movie());
		  return "movie-form"; 
		  }
		 

			
			 @PostMapping("/movies/create1") public String
			 createMovie(@ModelAttribute("movie") Movie movie) {
			 movieService.createMovie(movie); 
			 return "movie.html"; 
			 }
			 

	    @RequestMapping("/movies/{id}/edit")
	    public String showEditMovieForm(@PathVariable("id") Integer id, Model model) {
	        Movie movie = movieService.getMovieById(id);
	        model.addAttribute("movie", movie);
	        return "movie-form";
	    }

	    @PostMapping("/movies/{id}/edit")
	    public String updateMovie(@PathVariable("id") Integer id, @ModelAttribute("movie") Movie movie) {
	        movie.setMovie_id(id);
	        movieService.updateMovie(movie);
	        return "movie";
	    }

	    @GetMapping("/movies/{id}/delete")
	    public String deleteMovie(@PathVariable("id") Integer id) {
	        movieService.deleteMovie(id);
	        return "movie";
	    }
	   
	    @RequestMapping("/movies/{id}")
	    public String getMovieDetails(Model model) {
	    	List<Movie>list=movieService.getAllMovies();
	    	model.addAttribute("movies",list);
	        return "movie-details";
	    }
	    
	   
	
}
				
