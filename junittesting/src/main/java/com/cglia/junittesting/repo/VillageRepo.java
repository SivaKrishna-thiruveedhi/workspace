package com.cglia.junittesting.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cglia.junittesting.model.Village;

@Repository
public interface VillageRepo extends JpaRepository<Village, Integer>{

	Optional<Village> findByVillageName(String name);

}

