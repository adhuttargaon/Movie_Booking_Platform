package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Movie;
import com.example.demo.repository.BookingRepo;
import com.example.demo.repository.MovieRepo;
import com.example.demo.service.MovieService;

import jakarta.servlet.http.HttpSession;

@Controller
//shows data on browser
/*@RestController
@CrossOrigin(origins="http://localhost:3001")*/
public class MovieCtrl {
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	MovieRepo movieRepo;
	
	@GetMapping("/")
	  public String showMoviePage() { 
	  return  "home";
	  }
	@GetMapping("/movie-details")
	public String bookmovie(Model m) {
			List<Movie> list = movieRepo.findAll();
			m.addAttribute("all_movie" , list);
			return "movie-details";
		}
		@GetMapping("/load_movie_form")
		public String loadmovieForm() {
			return "movie-form";
		}
		@GetMapping("/edit_movie_form/{movie_id}")
		public String editmovieForm(@PathVariable(value = "movie_id") int movie_id, Model m) {
			Optional<Movie> movie = movieRepo.findById(movie_id);
			Movie movie1 = movie.get();
			m.addAttribute("movie",movie1);
			return "edit_movie_form";
		}
		
		
		
		@PostMapping("/save_movie")
		public String savemovie(@ModelAttribute Movie movie, HttpSession session) {
			
			movieRepo.save(movie);
			session.setAttribute("msg","Added Successfully");
			
			
		 return "redirect:/load_movie_form";
		}
		@PostMapping("/update_movie")
		public String updatemovie(@ModelAttribute Movie movie, HttpSession session) {
			
			movieRepo.save(movie);
			session.setAttribute("msg","Updated Successfully");
			
			
		 return "redirect:/movie-details";
		}
		@GetMapping("/deletemovie/{movie_id}")
	public String deleteMovie(@PathVariable(value="movie_id") int movie_id, HttpSession session) {
			movieRepo.deleteById(movie_id);
			session.setAttribute("msg","Deleted Successfully");
			
			
			return "redirect:/movie-details";
	}
		    
	    @GetMapping("/homepage")
	    public String homepage() {
	    	return "homepage";
	    }
}	    


				
