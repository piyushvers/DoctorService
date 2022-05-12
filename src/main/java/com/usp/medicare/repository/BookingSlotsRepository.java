package com.usp.medicare.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usp.medicare.entity.BookingSlots;

@Repository
public interface BookingSlotsRepository extends JpaRepository<BookingSlots, Integer>{
  List<BookingSlots> findByDoctorId(BigInteger doctorId);
}
