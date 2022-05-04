package com.usp.medicare.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usp.medicare.entity.DoctorSpeciality;

public interface DoctorSpecRepository extends JpaRepository<DoctorSpeciality, Integer> {

	List<DoctorSpeciality> findByDoctorId(BigInteger doctorId);

}
