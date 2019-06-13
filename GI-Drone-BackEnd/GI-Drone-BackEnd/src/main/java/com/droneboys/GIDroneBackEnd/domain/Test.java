/* RIT ENDPOINT
package com.droneboys.GIDroneBackEnd.endpoint;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import com.droneboys.GIDroneBackEnd.domain.Rit;
import com.droneboys.GIDroneBackEnd.service.PakketService;
import com.droneboys.GIDroneBackEnd.service.RitService;

@RestController
@RequestMapping(path = "dronebase/rit", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE })

public class RitEndpoint {

	@Autowired
	RitService ritService;

	@Autowired
	PakketService pakketService;

	// Create
	@PostMapping
	public ResponseEntity<Rit> apiCreate(@RequestBody Rit rit) {
		if (rit.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.ok(ritService.save(rit));
	}

	@PostMapping("ritten")
	public ResponseEntity<Rit> apiCreateRit() {
		// alle pakketten
		Set<Pakket> allePakketten = this.pakketService.findAll();
		Set <Pakket> pakkettenZonderRit = new HashSet<>();
		for(Pakket pakket :allePakketten) {
			if(pakket.isInrit()) {
//				allePakketten.remove(pakket);	
			}
			else {
				pakket.setInrit(true);
				pakkettenZonderRit.add(pakket);
			}
		}
		if (!pakkettenZonderRit.isEmpty()) {
			Rit rit = new Rit(pakkettenZonderRit);
			this.ritService.save(rit);
			return ResponseEntity.ok(rit);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}

	// Retrieve
	@GetMapping
	public ResponseEntity<Iterable<Rit>> apiGetAll() {
		return new ResponseEntity<Iterable<Rit>>(ritService.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Optional<Rit>> apiGetById(@PathVariable long id) {
		Optional<Rit> rit = ritService.findById(id);
		return new ResponseEntity<>(rit, rit.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	// Update
	@PutMapping(path = "{id}")
	public ResponseEntity<Rit> apiUpdate(@PathVariable("id") long id, @RequestBody Rit rit) {
		if (rit == null || rit.getId() != id)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		Optional<Rit> oldRit = ritService.findById(rit.getId());
		if (!oldRit.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(ritService.save(rit), HttpStatus.OK);
	}

	// Delete
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Rit> apiDeleteById(@PathVariable("id") long id) {
		if (!ritService.findById(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			ritService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
*/