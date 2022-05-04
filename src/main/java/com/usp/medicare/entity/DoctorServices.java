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
@Table(name="doctor_service")
public class DoctorServices {
	
	@Id
	@Column(name="ID")
	private Integer id;
	@Column(name="DOCTOR_ID_FK")
	private BigInteger doctorId;
	@Column(name="SERVICE_NAME")
	private String serviceName;
	@Column(name="IS_ACTIVE")
	private Character isActive;
	
}
