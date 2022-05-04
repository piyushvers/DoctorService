package com.usp.medicare.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doctor_spec")
@Getter
@Setter
public class DoctorSpeciality {
	@Id
	@Column(name="ID")
	private Integer id;
	@Column(name="DOCTOR_ID_FK")
	private BigInteger doctorId;
	@Column(name="SPEC_NAME")
	private String specName;
	@Column(name="IS_ACTIVE")
	private Character isActive;
}
