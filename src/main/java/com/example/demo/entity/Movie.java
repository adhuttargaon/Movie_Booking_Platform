package com.example.demo.entity;

import java.time.LocalTime;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Movie{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movie_id;
	private String movie_title;
	private String genre;
	private String director;
	private LocalTime duration;
	private Float rating;
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public LocalTime getDuration() {
		return duration;
	}
	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", movie_title=" + movie_title + ", genre=" + genre + ", director="
				+ director + ", duration=" + duration + ", rating=" + rating + "]";
	}
	public Movie(int movie_id, String movie_title, String genre, String director, LocalTime duration, Float rating) {
		super();
		this.movie_id = movie_id;
		this.movie_title = movie_title;
		this.genre = genre;
		this.director = director;
		this.duration = duration;
		this.rating = rating;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
