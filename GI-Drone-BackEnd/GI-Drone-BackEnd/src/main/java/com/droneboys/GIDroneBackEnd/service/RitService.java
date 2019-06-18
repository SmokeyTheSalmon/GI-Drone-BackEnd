//package com.droneboys.GIDroneBackEnd.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.droneboys.GIDroneBackEnd.repository.*;
//import com.droneboys.GIDroneBackEnd.domain.*;
//
//@Service
//@Transactional
//public class RitService {
//
//	@Autowired
//	private RitRepository ritrepo;
//	
//	public Rit save(Rit rit) {
//		return ritrepo.save(rit);
//	}
//	
//	public Optional<Rit> findById(long id){
//		return ritrepo.findById(id);
//	}
//	
//	public Iterable<Rit> findAll() {
//		return ritrepo.findAll();
//	}
//	
//	public void deleteById(long id) {
//		ritrepo.deleteById(id);
//	}
//}
