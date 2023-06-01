package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long booking_id;
	private Long show_id;
	private String moviename;
	private String booking_date;
	private String theatreName;
	private String theatreLocation;
	private Long total_amount;
	private String payment_method;

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", show_id=" + show_id + ", booking_date=" + booking_date
				+ ", theatreName=" + theatreName + ", theatreLocation=" + theatreLocation + ", total_amount="
				+ total_amount + ", payment_method=" + payment_method + ", moviename=" + moviename + "]";
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(Long booking_id, Long show_id, String booking_date, String theatreName, String theatreLocation,
			Long total_amount, String payment_method, String moviename) {
		super();
		this.booking_id = booking_id;
		this.show_id = show_id;
		this.booking_date = booking_date;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.total_amount = total_amount;
		this.payment_method = payment_method;
		this.moviename = moviename;
	}
	public Long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}
	public Long getShow_id() {
		return show_id;
	}
	public void setShow_id(Long show_id) {
		this.show_id = show_id;
	}
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreLocation() {
		return theatreLocation;
	}
	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}
	public Long getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Long total_amount) {
		this.total_amount = total_amount;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	

}
