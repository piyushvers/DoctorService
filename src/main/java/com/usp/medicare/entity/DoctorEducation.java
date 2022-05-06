package com.usp.medicare.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="doctor_education")
public class DoctorEducation {
	@Id
	@Column(name="ID")
	private Integer id;
	@Column(name="DOCTOR_ID_FK")
	private BigInteger doctorId;
	@Column(name="DEGREE_NAME")
	private String degreeName;
	@Column(name="COLLEGE_NAME")
	private String collegeName;
	@Column(name="COMPLETION_YEAR")
	private String year;


}
