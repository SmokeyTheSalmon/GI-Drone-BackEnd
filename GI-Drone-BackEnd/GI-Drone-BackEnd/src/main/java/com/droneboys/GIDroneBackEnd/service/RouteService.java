package com.droneboys.GIDroneBackEnd.service;

import java.awt.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.droneboys.GIDroneBackEnd.repository.*;
import com.droneboys.GIDroneBackEnd.domain.*;

@Service
@Transactional
public class RouteService {

	@Autowired
	private RouteRepository routerepo;
	
	public Route save(Route route) {
		return routerepo.save(route);
	}
	
	public Optional<Route> findById(long id){
		return routerepo.findById(id);
	}
	
	public Iterable<Route> findAll() {
		return routerepo.findAll();
	}
	
	public void deleteAll() {
		routerepo.deleteAll();
	}
	
	public long count() {
		return routerepo.count();
	}
}
