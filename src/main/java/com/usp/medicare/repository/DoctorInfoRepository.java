package com.usp.medicare.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usp.medicare.entity.DoctorInfo;

public interface DoctorInfoRepository extends JpaRepository<DoctorInfo, Integer>{

	DoctorInfo findByDoctorId(BigInteger doctorId);

}
