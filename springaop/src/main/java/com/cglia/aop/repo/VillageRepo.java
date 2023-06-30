package com.cglia.aop.repo;

import com.cglia.aop.model.Village;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VillageRepo extends JpaRepository<Village, Integer> {

}
