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
	long id;
	
	private String adres, afzender, postcode, stad, pakket, naam, huidige_locatie;
	private int gewicht;
	
	public Pakket() {}
	public Pakket(String adres, String afzender) {
		this.adres = adres;
		this.afzender = afzender;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getStad() {
		return stad;
	}
	public void setStad(String stad) {
		this.stad = stad;
	}
	public String getPakket() {
		return pakket;
	}
	public void setPakket(String pakket) {
		this.pakket = pakket;
	}
	public String getAfzender() {
		return afzender;
	}
	public void setAfzender(String afzender) {
		this.afzender = afzender;
	}
	public String getHuidige_locatie() {
		return huidige_locatie;
	}
	public void setHuidige_locatie(String huidige_locatie) {
		this.huidige_locatie = huidige_locatie;
	}
	public int getGewicht() {
		return gewicht;
	}
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
	
	
}
