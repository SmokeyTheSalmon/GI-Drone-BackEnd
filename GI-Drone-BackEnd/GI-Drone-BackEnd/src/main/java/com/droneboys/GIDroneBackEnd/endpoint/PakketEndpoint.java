package com.droneboys.GIDroneBackEnd.endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droneboys.GIDroneBackEnd.domain.Pakket;
import com.droneboys.GIDroneBackEnd.service.PakketService;


@RestController
@RequestMapping(
		path = "dronebase/pakket",
		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})

public class PakketEndpoint {

	@Autowired
	PakketService pakketService;
	
	//Create
	@PostMapping
	public ResponseEntity<Pakket> apiCreate(@RequestBody Pakket pakket) {
		if (pakket.getId() != 0) {
			return new ResponseEntity<> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Pakket>(
				pakketService.save(pakket), 
				HttpStatus.OK);
	}
	
	//Retrieve
	@GetMapping 	
	public ResponseEntity<Iterable<Pakket>> apiGetAll() {
		return new ResponseEntity<Iterable<Pakket>>(
				pakketService.findAll(), 
				HttpStatus.OK);
	}

	@GetMapping (path ="{id}")
	public ResponseEntity<Optional<Pakket>> apiGetById(
			@PathVariable long id) {
		Optional<Pakket> pakket = pakketService.findById(id);
		return new ResponseEntity<>(
				pakket, 
				pakket.isPresent() 
					? HttpStatus.OK 
					: HttpStatus.NOT_FOUND);
	}
	
	//Update
	@PutMapping(path="{id}")		
	public ResponseEntity<Pakket> apiUpdate(
			@PathVariable("id") long id, 
			@RequestBody Pakket pakket) {
		if (pakket == null || pakket.getId() != id)
			return new ResponseEntity<>(
					HttpStatus.BAD_REQUEST);

		Optional<Pakket> oldPakket = pakketService.findById(pakket.getId());
		if (!oldPakket.isPresent()) {
			return new ResponseEntity<>(
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				pakketService.save(pakket),
				HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping(path="{id}") 
	public ResponseEntity<Pakket> apiDeleteById(@PathVariable("id") long id) {
		if (!pakketService.findById(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			pakketService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
