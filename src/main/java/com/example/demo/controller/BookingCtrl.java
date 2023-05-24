package com.example.demo.controller;

import java.time.LocalDate;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Movie;
import com.example.demo.repository.BookingRepo;
import com.example.demo.repository.MovieRepo;



//shows data on browser
@RestController
public class BookingCtrl {
	@Autowired
	BookingRepo bookingRepo;
	
	@Autowired
	MovieRepo movieRepo;
	
	
	
	 @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        List<Booking> bookings = bookingRepo.findAll();
        model.addAttribute("bookings", bookings);
        return "bookings";
    }
    
    @GetMapping("/bookings/new")
    public String showBookingForm(Model model) {
        List<Movie> movies = movieRepo.findAll();
        model.addAttribute("movies", movies);
        model.addAttribute("booking", new Booking());
        return "booking-form";
    }
    
    @PostMapping("/bookings")
    public String createBooking(@ModelAttribute("booking") Booking booking) {
        booking.setBooking_date(LocalDate.now());
        bookingRepo.save(booking);
        return "redirect:/bookings";
    }
	/*public List<Booking> getAllBookings(){
		return bookingRepo.findAll();
				
	}
	//@GetMapping("/bookings")
	//public String showHomePage() {
		//return "homePage";
	//}
	
	@GetMapping("/booking/{id}")
	public Booking getBookingByid(@PathVariable("id")int id) {
		return bookingRepo.findById(id).get();
	}
	@PostMapping("/booking")
	public String addMovie(@RequestBody Booking booking)
	{
		bookingRepo.save(booking);
		return "Booking Details Has Been Added!";
	}
	
	@PutMapping("/booking/{id}")
	public String updateBooking(@RequestBody Booking booking) {
		Booking booking1 = (Booking)bookingRepo.findById(booking.getBooking_id()).get();
				if(booking1.getBooking_id()==booking.getBooking_id()) {
					booking1.setBooking_id(booking.getBooking_id());
					booking1.setShow_id(booking.getShow_id());
					booking1.setBooking_date(booking.getBooking_date());
					booking1.setTotal_amount(booking.getTotal_amount());
					bookingRepo.save(booking1);
					

}
				return "record updated";
	}
				@DeleteMapping("/bookings/{id}")
				public String deleteBookingsById(@PathVariable("id")int id) {
					Booking booking1 = bookingRepo.findById(id).get();
					if(booking1.getBooking_id()==id) {
						bookingRepo.delete(booking1);
						
					}
					return "Record Deleted!";
				}*/
	
}
				
