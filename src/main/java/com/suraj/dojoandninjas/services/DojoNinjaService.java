package com.suraj.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.suraj.dojoandninjas.models.Dojo;
import com.suraj.dojoandninjas.models.Ninja;
import com.suraj.dojoandninjas.repositories.DojoRepo;
import com.suraj.dojoandninjas.repositories.NinjaRepo;

@Service
public class DojoNinjaService {
	//construct service by pulling in both repos
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	public DojoNinjaService(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		this.dojoRepo=dojoRepo;
		this.ninjaRepo=ninjaRepo;
	}
	
	//find all Dojos
	public List<Dojo> findAllDojos(){
		//findAll returns a list of trips
		return dojoRepo.findAll();
	}
	
	//find all Ninjas
	public List<Ninja> findAllNinjas(){
		//findAll returns a list of trips
		return ninjaRepo.findAll();
	}
	
	//create Ninja
	public void newNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	
	//create Dojo
	public Dojo newDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
		
	}
	
	// find Dojo by id
	public Dojo findDojoById(Long id) {
		Optional<Dojo> d = dojoRepo.findById(id);

		if(d.isPresent()) {
			return d.get();
		} else {
			return null;
		}
	}
	
	
}
