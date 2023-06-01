package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Movie;


public interface BookingService {
	
	

public Booking createBooking(Booking booking);
	
	public boolean checkBookId(Long booking_id);
}
