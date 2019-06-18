package com.droneboys.GIDroneBackEnd.endpoint;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droneboys.GIDroneBackEnd.domain.Pakket;
import com.droneboys.GIDroneBackEnd.domain.Route;
import com.droneboys.GIDroneBackEnd.service.PakketService;
import com.droneboys.GIDroneBackEnd.service.RouteService;

@RestController
@RequestMapping(path = "dronebase/route", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE })

public class RouteEndpoint {

	@Autowired
	RouteService routeService;

	@Autowired
	PakketService pakketService;

	// Create
	@PostMapping
	public ResponseEntity<Route> apiCreateRoute() {
		if (routeService.count()!=1) {
			return ResponseEntity.noContent().build();
		} else {
			routeService.deleteAll();
		}
		Iterable<Pakket> allePakketten = this.pakketService.findAll();
		
		Iterator<Pakket> pakkettenIterator = allePakketten.iterator();
		Set<Pakket> pakketten = new HashSet<>();
		while (pakkettenIterator.hasNext()) {
			pakketten.add(pakkettenIterator.next());
		}
		
		if (pakketten.isEmpty()) {
			return ResponseEntity.noContent().build();
		} 
		else {
			Route route = new Route();
			route.setPakketten(pakketten);
			return ResponseEntity.ok(this.routeService.save(route));
		}
	}

	// Retrieve
	@GetMapping
	public ResponseEntity<Iterable<Route>> apiGetAll() {
		return new ResponseEntity<Iterable<Route>>(routeService.findAll(), HttpStatus.OK);
	}
	@GetMapping(path = "kortst")
	public ResponseEntity<List<Pakket>> apiGetKortsteRoute() {
		if (routeService.count()!=1) {
			return ResponseEntity.noContent().build();
		}
		else {
			Iterator<Route> routes = routeService.findAll().iterator();
			List<Pakket> resultaat = null;
			while (routes.hasNext()) {
				Route route = routes.next();
				resultaat = route.kortsteRoute();
			}
			return ResponseEntity.ok(resultaat);
		}
	}

	// Update
	public ResponseEntity<Route> apiUpdate(@RequestBody Route route) {
		if (routeService.count()==0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Route> oldRoute = routeService.findById(route.getId());
		if (!oldRoute.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(routeService.save(route), HttpStatus.OK);
	}


	// Delete
	@DeleteMapping
	public ResponseEntity<Route> apiDeleteAllRoutes() {
		if (routeService.count()==0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			routeService.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}