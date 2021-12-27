package com.usp.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usp.medicare.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
