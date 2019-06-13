package com.droneboys.GIDroneBackEnd.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.droneboys.GIDroneBackEnd.domain.Pakket;

@Repository
public interface PakketRepository extends CrudRepository<Pakket, Long> {

	@Override
	Set <Pakket> findAll();
	
	

}
