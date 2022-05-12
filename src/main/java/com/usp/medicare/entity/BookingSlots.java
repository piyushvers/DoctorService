package com.usp.medicare.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="doctor_booking_slots")
@Getter
@Setter
public class BookingSlots {
	@Id
	@Column(name="SLOT_ID")
	private Integer slotId;
	@Column(name="DOCTOR_ID_FK")
	private BigInteger doctorId;
	@Column(name="DAY_FK")
	private Integer dayId;
	@Column(name="SLOT_START_TIME")
	private String startTime;
	@Column(name="SLOT_END_TIME")
	private String endTime;
	@Column(name="SLOT_DURATION")
	private String duration;
	@Column(name="IS_ACTIVE")
	private Character isActive;


}
