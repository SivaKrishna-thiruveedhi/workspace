package com.cglia.junittesting.service;

import java.util.List;
import java.util.Optional;

import com.cglia.junittesting.model.Village;

public interface VillageServices {

	List<Village> getAllVillages();

	Village addVillage(Village village);

	Optional<Village> getOneVillage(int id);

	Village deleteById(int id);

	String updateById(Village village, int id);

	Optional<Village> getOneByVillageName(String name);

}
