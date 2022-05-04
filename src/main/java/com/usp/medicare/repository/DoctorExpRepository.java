package com.usp.medicare.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usp.medicare.entity.DoctorExperience;

public interface DoctorExpRepository extends JpaRepository<DoctorExperience, Integer> {

	List<DoctorExperience> findByDoctorId(BigInteger doctorId);
  
}
