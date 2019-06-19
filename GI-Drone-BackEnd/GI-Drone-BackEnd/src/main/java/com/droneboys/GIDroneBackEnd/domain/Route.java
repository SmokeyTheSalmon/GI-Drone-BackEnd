package com.droneboys.GIDroneBackEnd.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Route {
	@Id

	private long id = 1;

	// mag geen sets en lists maken in field van domain om een of andere rede
	// moet nu kortste lijst als parameters meesleuren
	private double kortsteAfstand;
	private long[] kortsteVolgorde;
	private int mogelijkheden = 0;
	
	@ManyToMany
	private Set<Pakket> pakketten = new HashSet<>();
	
	public Route() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Pakket> getPakketten() {
		return pakketten;
	}

	public void setPakketten(Set<Pakket> nodeLijst) {
		this.pakketten = nodeLijst;
	}
	
	//kortste route methode
	public List<Pakket> kortsteRoute() {
		
		
		List<Pakket> lijst = new ArrayList<>();
		for (Pakket pakket : pakketten) {
			lijst.add(pakket);	
		}
		kortsteAfstand = Double.MAX_VALUE;
		kortsteVolgorde = new long[lijst.size()];
		List<Pakket> Kortstelijst = new ArrayList<>();

		heapsAlg(lijst, 0, lijst.size()-1);
			
		for (int i = 0 ; i < kortsteVolgorde.length ; i++) {
			for (int j = 0 ; j < kortsteVolgorde.length ; j++) {
				if (kortsteVolgorde[i] == lijst.get(j).getId()) {
					Kortstelijst.add(lijst.get(j));
					break;
				}
			}
		}
		
		System.out.println();
		System.out.print("Snelste route: ");
		for(Pakket pakket : Kortstelijst)
			System.out.print(pakket.getId()+" ");
		System.out.println();
		System.out.println("Kortste Afstand: " + kortsteAfstand);
		
		System.out.println("berekende mogelijkheden " + mogelijkheden);
		
		return Kortstelijst;
	}
	
	//heaps algoritme
	private void heapsAlg (List<Pakket> lijst, int a, int b) {
		if (a == b)
			bereken(lijst);
		else {
			for (int i = a; i <= b; i++) {
				swap(lijst, a, i);
				heapsAlg (lijst, a+1, b);
				swap(lijst, a, i);
			}
		}
	}
	
	//swap
	private void swap(List<Pakket> lijst, int i, int b) {
		Pakket tempA = lijst.get(i);
		Pakket tempB = lijst.get(b);
		lijst.remove(i);
		lijst.add(i, tempB);
		lijst.remove(b);
		lijst.add(b, tempA);		
	}
	
	//maths
	private void bereken(List<Pakket> lijst) {
		double afstand = 0;
		for (int i = 0 ; i<lijst.size()-1 ; i++) {
			afstand += Math.sqrt(
			(lijst.get(i+1).getLongitude()-lijst.get(i).getLongitude())*
			(lijst.get(i+1).getLongitude()-lijst.get(i).getLongitude()) + 
			(lijst.get(i+1).getLatitude()-lijst.get(i).getLatitude())*
			(lijst.get(i+1).getLatitude()-lijst.get(i).getLatitude()));
		}
		
		if (afstand<kortsteAfstand) {
			System.out.println("nieuwe kortste afstand gevonden!");
			kortsteAfstand = afstand;
			for (int i = 0 ; i < kortsteVolgorde.length ; i++)
				kortsteVolgorde[i] = lijst.get(i).getId();
		}
		
		for(Pakket pakket : lijst)
			System.out.print(pakket.getId()+" ");
		System.out.println("afstand: " + afstand);
		mogelijkheden++;
	}
		
		
		
		
		
		
		
//		//RIP ;(
//		long tempAfstand = 0;
//		long kortsteAfstand = Long.MAX_VALUE;
//		long[][] afstandenMatrix = new long[lijst.size()][lijst.size()];
//		
//		//afstanden matrix vullen
//		for(int i = 0; i < lijst.size(); i++) {
//			for(int j = 0; j < lijst.size(); j++) {
//				//if (i == j) continue;
//				afstandenMatrix[i][j] = (long)Math.sqrt(	(lijst.get(j).getLatitude()-lijst.get(i).getLatitude())*
//															(lijst.get(j).getLatitude()-lijst.get(i).getLatitude()) + 
//															(lijst.get(j).getLongitude()-lijst.get(i).getLongitude())*
//															(lijst.get(j).getLongitude()-lijst.get(i).getLongitude()));
//			}
//		}
//		//tijdelijke route
//		temp = lijst;
//		int j = 0;
//		for (int i = 0; i < temp.size(); i++) {
//			if (lijst.get(i+1)!=null) { j = i+1; }
//			else { break; }
//			tempAfstand += afstandenMatrix[i][j];
//			if (tempAfstand<kortsteAfstand) { kortsteAfstand=tempAfstand; }
//		}		
//		return lijst;
}
