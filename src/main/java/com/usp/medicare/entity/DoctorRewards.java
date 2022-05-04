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
@Table(name="doctor_amr")
public class DoctorRewards {
	
	@Id
	@Column(name="ID")
	private Integer id;
	@Column(name="DOCTOR_ID_FK")
	private BigInteger doctorId;
	@Column(name="AMR_NAME")
	private String name;
	@Column(name="AMR_DESC")
	private String desc;
	@Column(name="AMR_TYPE")
	private Character type;
	@Column(name="AMR_YEAR")
	private String year;
	@Column(name="IS_ACTIVE")
	private Character isActive;
	@Column(name="IS_CURRENT")
	private Character isCurrent;
}
