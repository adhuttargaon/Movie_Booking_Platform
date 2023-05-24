package com.example.demo.entity;


import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer booking_id;
	private Integer user_id;
	private Integer show_id;
	private LocalDate booking_date;
	private int total_amount;
	private String payment_method;
	public Integer getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getShow_id() {
		return show_id;
	}
	public void setShow_id(Integer show_id) {
		this.show_id = show_id;
	}
	public LocalDate getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public Booking(Integer booking_id, Integer user_id, int show_id, LocalDate booking_date, int total_amount,
			String payment_method) {
		super();
		this.booking_id = booking_id;
		this.user_id = user_id;
		this.show_id = show_id;
		this.booking_date = booking_date;
		this.total_amount = total_amount;
		this.payment_method = payment_method;
	}
	public Booking() {
		super();
	}
	
	
	
	

}
