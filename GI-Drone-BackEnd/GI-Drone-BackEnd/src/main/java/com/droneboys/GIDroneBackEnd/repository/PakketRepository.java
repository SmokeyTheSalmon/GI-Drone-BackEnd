package com.droneboys.GIDroneBackEnd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.droneboys.GIDroneBackEnd.domain.Pakket;

@Repository
public interface PakketRepository extends CrudRepository<Pakket, Long> {

}
