package com.usp.medicare.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usp.medicare.entity.DoctorRewards;

@Repository
public interface DoctorAMRRepository extends JpaRepository<DoctorRewards, Integer>{

	List<DoctorRewards> findByDoctorId(BigInteger doctorId);

}
