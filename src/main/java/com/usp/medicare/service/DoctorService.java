package com.usp.medicare.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	public Map<String, String> getDoctorList() {
		Map<String, String> doctors = new LinkedHashMap<>();
		doctors.put("1", "Piyush Sharma");
		doctors.put("2", "Saurabh Gupta");
		doctors.put("3", "Anurag Parashar");
		doctors.put("4", "Siddhartha Singh");
		return doctors;
	}
	
	public Map<String, String> getDoctorClinicsList() {
		Map<String, String> clinics = new LinkedHashMap<>();
		clinics.put("1", "Pathology Clinic");
		clinics.put("2", "Neurology Clinic");
		clinics.put("3", "Radiology Clinic");
		return clinics;
	}
}
