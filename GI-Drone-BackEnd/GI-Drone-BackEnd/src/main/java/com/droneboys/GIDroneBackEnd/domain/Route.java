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
		List<Pakket> temp = new ArrayList<>();
		for (Pakket pakket : pakketten) {
			lijst.add(pakket);	
		}
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
//		for (int i = 0; i < lijst.size()-1; i++) {
//			tempAfstand += afstandenMatrix[i][i+1];
//			if (tempAfstand<kortsteAfstand) {
//				kortsteAfstand=tempAfstand;
//			}
//		}		
		return lijst;
	}
}
