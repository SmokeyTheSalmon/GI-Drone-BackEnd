package com.droneboys.GIDroneBackEnd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.droneboys.GIDroneBackEnd.repository.*;
import com.droneboys.GIDroneBackEnd.domain.*;

@Service
@Transactional
public class PakketService {

	@Autowired
	private PakketRepository pakrepo;
	
	public Pakket save(Pakket pakket) {
		return pakrepo.save(pakket);
	}
	
	public Optional<Pakket> findById(long id){
		return pakrepo.findById(id);
	}
	
	public Iterable<Pakket> findAll() {
		return pakrepo.findAll();
	}
	
	public void deleteById(long id) {
		pakrepo.deleteById(id);
	}
}
