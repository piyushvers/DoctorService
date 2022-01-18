package com.usp.medicare.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usp.medicare.service.DoctorService;

/**
 * Controller to manage all requests related to doctor service
 * 
 * @author piyus
 *
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to get doctor list
	 * 
	 * @return
	 */
	@GetMapping("/getdoctors")
	public ResponseEntity<?> getDoctors() {
		Map<String, String> doctoreList = doctorService.getDoctorList();
		return ResponseEntity.ok(doctoreList);
	}

	/**
	 * Method to get clinic list of doctors
	 * 
	 * @return
	 */
	@GetMapping("/getclinics")
	public ResponseEntity<?> getClinics() {
		Map<String, String> clinicList = doctorService.getDoctorClinicsList();
		return ResponseEntity.ok(clinicList);
	}
	
	/**
	 * Method to get doctor list
	 * 
	 * @return
	 */
	@GetMapping("/getdoctorsandclinics")
	public ResponseEntity<?> getDoctorsWithClinics() {
		Map<String,Map<String,String>> responseMap = new HashMap<String,Map<String,String>>();
		
		Map<String, String> doctoreList = doctorService.getDoctorList();
		Map<String, String> clinicList = doctorService.getDoctorClinicsList();
		
		responseMap.put("clinicList", clinicList);
		responseMap.put("doctorList", doctoreList);
		return ResponseEntity.ok(responseMap);
	}

}
