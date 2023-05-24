package com.example.demo.entity;

import java.sql.Time;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Shows {
	public Shows() {
		super();
	}
	public Shows(int show_id, int theatre_id, int movie_id, LocalDate show_date, Time show_time, int available_seats) {
		super();
		this.show_id = show_id;
		this.theatre_id = theatre_id;
		this.movie_id = movie_id;
		this.show_date = show_date;
		this.show_time = show_time;
		this.available_seats = available_seats;
	}
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int show_id;
	private int theatre_id;
	private int movie_id;
	private LocalDate show_date;
	private Time show_time;
	private int available_seats;
	
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public int getTheatre_id() {
		return theatre_id;
	}
	public void setTheatre_id(int theatre_id) {
		this.theatre_id = theatre_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public LocalDate getShow_date() {
		return show_date;
	}
	public void setShow_date(LocalDate show_date) {
		this.show_date = show_date;
	}
	public Time getShow_time() {
		return show_time;
	}
	public void setShow_time(Time show_time) {
		this.show_time = show_time;
	}
	public int getAvailable_seats() {
		return available_seats;
	}
	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}
	
	
}
