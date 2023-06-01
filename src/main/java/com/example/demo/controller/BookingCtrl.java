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
import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepo;
import com.example.demo.service.BookingService;

import jakarta.servlet.http.HttpSession;

//shows data on browser
@Controller
public class BookingCtrl {
	@Autowired
	BookingRepo bookingRepo;
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/bookingDetails")
	public String bookhome(Model m) {
			List<Booking> list = bookingRepo.findAll();
			m.addAttribute("all_booking" , list);
			return "bookingDetails";
		}
		@GetMapping("/load_book_form")
		public String loadbookForm() {
			return "bookingHome";
		}
		@GetMapping("/edit_book_form/{booking_id}")
		public String editbookForm(@PathVariable(value = "booking_id") long booking_id, Model m) {
			Optional<Booking> booking = bookingRepo.findById(booking_id);
			Booking book = booking.get();
			m.addAttribute("booking",book);
			return "edit";
		}
		
		
		
		@PostMapping("/save_book")
		public String savebook(@ModelAttribute Booking booking, HttpSession session) {
			
			bookingRepo.save(booking);
			session.setAttribute("msg","Added Successfully");
			
			
		 return "redirect:/load_book_form";
		}
		@PostMapping("/update_book")
		public String updatebook(@ModelAttribute Booking booking, HttpSession session) {
			
			bookingRepo.save(booking);
			session.setAttribute("msg","Updated Successfully");
			
			
		 return "redirect:/bookingDetails";
		}
		@GetMapping("/deletebook/{booking_id}")
	public String deleteBooking(@PathVariable(value="booking_id") long booking_id, HttpSession session) {
			bookingRepo.deleteById(booking_id);
			session.setAttribute("msg","Deleted Successfully");
			
			
			return "redirect:/bookingDetails";
	}
		
	
		
		
		
}