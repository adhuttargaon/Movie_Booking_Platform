package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;

import com.example.demo.repository.BookingRepo;

@Service
public class BookingServiceImp implements BookingService {
	
	@Autowired
	BookingRepo bookingRepo;

	
	
	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return  bookingRepo.save(booking);
	}

	@Override
	public boolean checkBookId(Long booking_id) {
		// TODO Auto-generated method stub
		return bookingRepo.existsById(booking_id);

	}

}