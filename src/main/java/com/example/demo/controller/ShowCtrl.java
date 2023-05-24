package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Shows;

import com.example.demo.repository.ShowsRepo;

//shows data on browser
@RestController
public class ShowCtrl {
	@Autowired
	ShowsRepo showRepo;
	@GetMapping("/show")
	public List<Shows> getAllShow(){
		return showRepo.findAll();
				
	}
	@GetMapping("/show/{id}")
	public Shows getShowsByid(@PathVariable("id")int id) {
		return showRepo.findById(id).get();
	}
	@PostMapping("/show")
	public String addShow(@RequestBody Shows show)
	{
		showRepo.save(show);
		return "Show has been added sucessfully!";
	}
	
	@PutMapping("/show/{id}")
	public String updateShow(@RequestBody Shows show) {
		Shows show1 = (Shows)showRepo.findById(show.getShow_id()).get();
				if(show1.getShow_id()==show.getShow_id()) {
					show1.setShow_id(show.getShow_id());
					show1.setTheatre_id(show.getTheatre_id());
					show1.setMovie_id(show.getMovie_id());
					show1.setShow_date(show.getShow_date());
					show1.setShow_time(show.getShow_time());
					show1.setAvailable_seats(show.getAvailable_seats());
					showRepo.save(show1);
					

}
				return "record updated";
	}
				@DeleteMapping("/show/{id}")
				public String deleteshowById(@PathVariable("id")int id) {
					Shows show1 = showRepo.findById(id).get();
					if(show1.getShow_id()==id) {
						showRepo.delete(show1);
						
					}
					return "Record Deleted!";
				}
}
				
