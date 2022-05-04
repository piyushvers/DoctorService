package com.usp.medicare.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doctor")
@Getter
@Setter
public class Doctor {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="Doctor_ID", unique = true)
	private BigInteger doctorId;
	
	@Column(name="DOCTOR_NAME")
	private String doctorName;
	
	@Column(name="DOCTOR_FIRST_NAME")
	private String firstName;
	
	@Column(name="DOCTOR_LAST_NAME")
	private String lastName;
	
	@Column(name="DOCTOR_PHONE_NO")
	private String phoneNumber;
	
	@Column(name="DOCTOR_SEX")
	private Character sex;
	
	@Column(name="DOCTOR_SPECIALITY")
	private String speciality;
	
	@Column(name="DOCTOR_EDUCATION")
	private String qualification;
	
	@Column(name="DOCTOR_DOB")
	private String dateOfBirth;
	
	@Column(name="ADDRESS_FK")
	private Integer addressId;	
	
}
