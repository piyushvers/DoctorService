package com.usp.medicare.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doctor_information")
@Getter
@Setter
public class DoctorInfo {
	@Id
	@Column(name="ID")
	private Integer id;
	@Column(name="DOCTOR_ID_FK")
	private BigInteger doctorId;
	@Column(name="ABOUT_ME")
	private String aboutMe;
	@Column(name="CLINIC_NAME")
	private String clinicName;
	@Column(name="CLINIC_ADDRESS")
	private String clinicAddress;
	@Column(name="CLINIC_PRICING")
	private String pricing;
	@Column(name="IS_ACTIVE")
	private Character isActive;
	
}
