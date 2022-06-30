package com.smoothstack.utopiaairlines.models;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "tbl_traveler")
public class Traveler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "travelerId")
	private int travelerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "dob", columnDefinition = "TIMESTAMP")
	private LocalDateTime dob;
	
	public Traveler() {
		
	}
	
	public Traveler(String name, String address, String phone, String email, LocalDateTime dob) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
	}

	public int getTravelerId() {
		return travelerId;
	}

	public void setTravelerId(int travelerId) {
		this.travelerId = travelerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Traveler [travelerId=" + travelerId + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", dob=" + dob + "]";
	}
}
