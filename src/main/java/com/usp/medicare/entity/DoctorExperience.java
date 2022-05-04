package com.usp.medicare.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doctor_exp")
@Getter
@Setter
public class DoctorExperience {
	@Id
	@Column(name="ID")
	private Integer id;
	@Column(name="DOCTOR_ID_FK")
	private BigInteger doctorId;
	@Column(name="HOSPITAL_NAME")
	private String hospitalName;
	@Column(name="WORKED_FROM")
	private String workedFrom;
	@Column(name="WORKED_TO")
	private String workedTo;
	@Column(name="DESIGNATION")
	private String designation;

}
