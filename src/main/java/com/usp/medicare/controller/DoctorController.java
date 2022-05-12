package com.usp.medicare.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usp.medicare.dto.DoctorBookingResponseDto;
import com.usp.medicare.dto.DoctorDetailsDto;
import com.usp.medicare.dto.DoctorSearchResponse;
import com.usp.medicare.service.DoctorService;

/**
 * Controller to manage all requests related to doctor service
 * 
 * @author piyus
 *
 */
@RestController
@RequestMapping("/doctor")
@CrossOrigin
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
	public ResponseEntity<List<DoctorSearchResponse>> getDoctors(@RequestParam(required = false) String searchStr) {
		List<DoctorSearchResponse> doctoreList = doctorService.getDoctorList(searchStr);
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
		
		//List<DoctorDto> doctoreList = doctorService.getDoctorList();
		Map<String, String> clinicList = doctorService.getDoctorClinicsList();
		
		responseMap.put("clinicList", clinicList);
		//responseMap.put("doctorList", doctoreList);
		return ResponseEntity.ok(responseMap);
	}
	
	@GetMapping("/getDoctorDetailsById/{doctorId}")
	public ResponseEntity<DoctorDetailsDto> getDoctorDetailsById(@PathVariable String doctorId) {
		DoctorDetailsDto doctorDetail = doctorService.getDoctorDetails(new BigInteger(doctorId));
		return ResponseEntity.ok(doctorDetail);
	}
	
	@GetMapping("/getAllSpeciality")
	public ResponseEntity<List<String>> getAllSpeciality() {
		List<String> doctorDetail = doctorService.getAllSpeciality();
		return ResponseEntity.ok(doctorDetail);
	}
	
	@GetMapping("/getBookingSlots")
	public ResponseEntity<DoctorBookingResponseDto> getBookingSlots(@RequestParam String doctorId) {
		DoctorBookingResponseDto doctorBookingResponseDto = doctorService.getBookingSlots(new BigInteger(doctorId));
		return ResponseEntity.ok(doctorBookingResponseDto);
	}
	

}
