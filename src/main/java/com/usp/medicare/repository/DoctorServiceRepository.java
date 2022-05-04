package com.usp.medicare.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usp.medicare.entity.DoctorServices;


public interface DoctorServiceRepository extends JpaRepository<DoctorServices, Integer> {

	List<DoctorServices> findByDoctorId(BigInteger doctorId);

}
