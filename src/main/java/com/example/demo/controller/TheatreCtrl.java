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

import com.example.demo.entity.Theatre;
import com.example.demo.repository.TheatreRepo;


//shows data on browser
@RestController
public class TheatreCtrl {
	@Autowired
	TheatreRepo theatreRepo;
	@GetMapping("/theatre")
	public List<Theatre> getAllTheatre(){
		return theatreRepo.findAll();
				
	}
	@GetMapping("/theatre/{id}")
	public Theatre getTheatreByid(@PathVariable("id")int id) {
		return theatreRepo.findById(id).get();
	}
	@PostMapping("/theatre")
	public String addTheatre(@RequestBody Theatre theatre)
	{
		theatreRepo.save(theatre);
		return "Theatre Details Added Sucessfully!";
	}
	
	@PutMapping("/theatre/{id}")
	public String updateTheatre(@RequestBody Theatre theatre) {
		Theatre theatre1 = (Theatre)theatreRepo.findById(theatre.getTheatre_id()).get();
				if(theatre1.getTheatre_id()==theatre.getTheatre_id()) {
					theatre1.setTheatre_name(theatre.getTheatre_name());
					theatre1.setLocation(theatre.getLocation());
					theatre1.setSeating_capacity(theatre.getSeating_capacity());
					theatreRepo.save(theatre1);
					

}
				return "record updated";
	}
				@DeleteMapping("/theatre/{id}")
				public String deletetTheatreById(@PathVariable("id")int id) {
					Theatre theatre1 = theatreRepo.findById(id).get();
					if(theatre1.getTheatre_id()==id) {
						theatreRepo.delete(theatre1);
						
					}
					return "Record Deleted!";
				}
}
				
