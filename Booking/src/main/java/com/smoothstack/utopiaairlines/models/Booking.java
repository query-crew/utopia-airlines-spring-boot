package com.smoothstack.utopiaairlines.models;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tbl_booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingId")
	private int bookingId;
	
	@Column(name = "isActive")
	private int isActive;
	
	@Column(name = "stripeId")
	private String stripeId;
	
	@Column(name = "bookerId")
	private int bookerId;
	
	@Column(name = "seatId")
	private int seatId;
	
	public Booking() {
		//idk why lombox doesnt work
	}
	
	public Booking(int isActive, String stripeId, int bookerId, int seatId) {
		super();
		this.isActive = isActive;
		this.stripeId = stripeId;
		this.bookerId = bookerId;
		this.seatId = seatId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", isActive=" + isActive + ", stripeId=" + stripeId + ", bookerId="
				+ bookerId + ", seatId=" + seatId + "]";
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getStripeId() {
		return stripeId;
	}

	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}

	public int getBookerId() {
		return bookerId;
	}

	public void setBookerId(int bookerId) {
		this.bookerId = bookerId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
}
