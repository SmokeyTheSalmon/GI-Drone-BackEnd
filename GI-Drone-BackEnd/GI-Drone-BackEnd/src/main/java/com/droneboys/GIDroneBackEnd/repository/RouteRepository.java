package com.droneboys.GIDroneBackEnd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.droneboys.GIDroneBackEnd.domain.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

}
