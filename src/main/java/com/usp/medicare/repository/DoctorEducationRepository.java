package com.usp.medicare.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usp.medicare.entity.DoctorEducation;

@Repository
public interface DoctorEducationRepository extends JpaRepository<DoctorEducation, Integer> {

	List<DoctorEducation> findByDoctorId(BigInteger doctorId);

}
