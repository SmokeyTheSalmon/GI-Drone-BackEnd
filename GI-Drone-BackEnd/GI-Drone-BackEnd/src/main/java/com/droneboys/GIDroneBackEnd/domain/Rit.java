//package com.droneboys.GIDroneBackEnd.domain;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//@Entity
//public class Rit {
//	@Id
//
//	@GeneratedValue
//	(strategy = GenerationType.AUTO)
//	private long id;
//
//	@OneToMany
//	(cascade = CascadeType.ALL, mappedBy = "rit", fetch = FetchType.LAZY) // ophalen van pakketen uit tabel
//																					// bij aanroep
//																					// (many=paketten/one=rit)
//	private Set<Pakket> pakketLijst = new HashSet<>();
//
//	public Rit() {
//	}
//
//	public Rit(Set<Pakket> pakketLijst) {
//		this.pakketLijst = pakketLijst;
//	}
//
//	public List<String> getAdreslijst() {
//		List<String> adreslijst = new ArrayList<>(); //verplaatsen naar field
//		for (Pakket pakket : pakketLijst) {
//			adreslijst.add(pakket.getAdres());
//		}
//		return adreslijst;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setPakketLijst(Set<Pakket> pakketLijst) {
//		this.pakketLijst = pakketLijst;
//	}
//
//}
