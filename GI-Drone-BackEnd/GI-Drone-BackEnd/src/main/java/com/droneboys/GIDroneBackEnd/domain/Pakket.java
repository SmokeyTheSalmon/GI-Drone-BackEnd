package com.droneboys.GIDroneBackEnd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pakket {
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String naam, adres, stad;
	private double longitude, latitude;
	
	public long getId() {
		return id;
	}

	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getStad() {
		return stad;
	}
	public void setStad(String stad) {
		this.stad = stad;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}
