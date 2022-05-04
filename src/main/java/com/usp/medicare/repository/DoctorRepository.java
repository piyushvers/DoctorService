package com.usp.medicare.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usp.medicare.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, BigInteger>{

	Doctor findByDoctorId(BigInteger doctorId);
	
	@Query("SELECT doctor FROM Doctor doctor "
            + " WHERE  LOWER(doctor.firstName) LIKE LOWER(CONCAT('%',:search, '%')) OR"
            + "   LOWER(doctor.lastName) LIKE LOWER(CONCAT('%',:search, '%')) OR"
            + "   LOWER(doctor.speciality) LIKE LOWER(CONCAT('%',:search, '%')) "        
            + " ORDER BY doctor.firstName ASC")
    List<Doctor>  getAllDoctorsBySearchCriteria(String search);

}
