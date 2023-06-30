package com.cglia.aop.service;

import java.sql.SQLException;
import java.util.List;

import com.cglia.aop.model.Village;
import com.cglia.aop.repo.VillageRepo;
import com.cglia.aop.repo.ZipcodeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VillageService {

	@Autowired
	VillageRepo vrepo;
	@Autowired
	ZipcodeRepo zrepo;
	
	public void saveVillage(Village village) {
		zrepo.save(village.getZipcode());
		vrepo.save(village);
	}

	public Village getVillageById(int id) {
		return vrepo.findById(id).get();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SQLException.class)
	public void updateVillageById(int id, Village village) {
		Village vi = vrepo.findById(id).get();
		zrepo.deleteById(vi.getZipcode().getZipId());
		vi.setPopulation(village.getPopulation());
		vi.setVillageName(village.getVillageName());
		vi.setZipcode(village.getZipcode());
		vrepo.save(vi);
	}

	public void deleteVillage(int id) {
		
		vrepo.deleteById(id);
	}

	public List<Village> getAllVillages() {
		return vrepo.findAll();
	}
	
	
}
