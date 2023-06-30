package com.cglia.junittesting.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.junittesting.model.Village;
import com.cglia.junittesting.repo.VillageRepo;


@Service
public class VillageService implements VillageServices {

	private static final Logger logger = Logger.getLogger(VillageService.class.getName());
	
	@Autowired
	VillageRepo villageRepo;
	
	
	@Override
	public List<Village> getAllVillages() {
		return villageRepo.findAll();
	}

	@Override
	public Village addVillage(Village village) {
		return villageRepo.save(village);
	}

	@Override
	public Optional<Village> getOneVillage(int id) {
		logger.info("Get by id method is called by the controller - started");
		logger.info("Get by id method is called by the controller - ended");
		return villageRepo.findById(id);
	}

	@Override
	public Village deleteById(int id) {
		Optional<Village> villages = villageRepo.findById(id);
		if (villages.isPresent()) {
			Village villa = villages.get();
			villa.setStatus(0);
			return villageRepo.save(villa);
		} else {
			return null;
		}
		
	}

	@Override
	public String updateById(Village village, int id) {
		Optional<Village> villages = villageRepo.findById(id);
		
		if (villages.isPresent()) {
			Village villa = villages.get();
			villa.setVillageName(village.getVillageName());
			villa.setPopulation(village.getPopulation());
			villa.setStatus(village.getStatus());
			villageRepo.save(villa);
			
			return "updated";
		} else {
			return null;
		}

	}

	@Override
	public Optional<Village> getOneByVillageName(String name) {
		logger.info("Get by name method is called by the controller - started");
		logger.info("Get by name method is called by the controller - ended");
		return villageRepo.findByVillageName(name);
	}

}



















