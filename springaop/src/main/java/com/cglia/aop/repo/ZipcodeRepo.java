package com.cglia.aop.repo;

import com.cglia.aop.model.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodeRepo extends JpaRepository<Zipcode, Integer> {

}
