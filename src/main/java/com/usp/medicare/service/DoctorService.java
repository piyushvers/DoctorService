package com.usp.medicare.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usp.medicare.dto.DoctorAmrDto;
import com.usp.medicare.dto.DoctorDetailsDto;
import com.usp.medicare.dto.DoctorDto;
import com.usp.medicare.dto.DoctorEducationDto;
import com.usp.medicare.dto.DoctorExpDto;
import com.usp.medicare.dto.DoctorInfoDto;
import com.usp.medicare.dto.DoctorServicesDto;
import com.usp.medicare.dto.DoctorSpecDto;
import com.usp.medicare.entity.Doctor;
import com.usp.medicare.entity.DoctorEducation;
import com.usp.medicare.entity.DoctorExperience;
import com.usp.medicare.entity.DoctorInfo;
import com.usp.medicare.entity.DoctorRewards;
import com.usp.medicare.entity.DoctorServices;
import com.usp.medicare.entity.DoctorSpeciality;
import com.usp.medicare.repository.DoctorAMRRepository;
import com.usp.medicare.repository.DoctorEducationRepository;
import com.usp.medicare.repository.DoctorExpRepository;
import com.usp.medicare.repository.DoctorInfoRepository;
import com.usp.medicare.repository.DoctorRepository;
import com.usp.medicare.repository.DoctorServiceRepository;
import com.usp.medicare.repository.DoctorSpecRepository;
import com.usp.medicare.util.ObjectMapperUtils;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private DoctorInfoRepository doctorInfoRepository;
	@Autowired
	private DoctorExpRepository doctorExpRepository;

	@Autowired
	private DoctorServiceRepository doctorServiceRepository;

	@Autowired
	private DoctorSpecRepository doctorSpecRepository;

	@Autowired
	private DoctorAMRRepository doctorAMRRepository;
	@Autowired
	private DoctorEducationRepository doctorEducationRepository;

	public List<DoctorDto> getDoctorList(String searchStr) {
		List<Doctor> doctorList = new ArrayList<>();

		if (searchStr == null || searchStr.isEmpty()) {
			doctorList = doctorRepository.findAll();
			System.out.println(doctorList);
			List<DoctorDto> doctorDtoList = new ArrayList<>();
			doctorDtoList = doctorList != null && !doctorList.isEmpty()
					? ObjectMapperUtils.mapAll(doctorList, DoctorDto.class)
					: new ArrayList<>();
			return doctorDtoList;
		} else {
			doctorList = doctorRepository.getAllDoctorsBySearchCriteria(searchStr);
			System.out.println(doctorList);
			List<DoctorDto> doctorDtoList = new ArrayList<>();
			doctorDtoList = doctorList != null && !doctorList.isEmpty()
					? ObjectMapperUtils.mapAll(doctorList, DoctorDto.class)
					: new ArrayList<>();
			return doctorDtoList;
		}

	}

	public Map<String, String> getDoctorClinicsList() {
		Map<String, String> clinics = new LinkedHashMap<>();
		clinics.put("1", "Pathology Clinic");
		clinics.put("2", "Neurology Clinic");
		clinics.put("3", "Radiology Clinic");
		return clinics;
	}

	public DoctorDetailsDto getDoctorDetails(BigInteger doctorId) {
		// TODO Auto-generated method stub

		Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
		if (optionalDoctor.isPresent()) {
			System.out.println("--------------------" + optionalDoctor);
			DoctorInfo doctorInfo = doctorInfoRepository.findByDoctorId(doctorId);
			DoctorInfoDto doctorInfodto = ObjectMapperUtils.map(doctorInfo, DoctorInfoDto.class);
			List<DoctorExperience> doctorExperiences = doctorExpRepository.findByDoctorId(doctorId);
			List<DoctorExpDto> doctorExperienceDto = doctorInfodto != null
					? ObjectMapperUtils.mapAll(doctorExperiences, DoctorExpDto.class)
					: new ArrayList<>();

			List<DoctorServices> doctorServices = doctorServiceRepository.findByDoctorId(doctorId);
			List<DoctorServicesDto> docServicesDtos = doctorServices != null && !doctorServices.isEmpty()
					? ObjectMapperUtils.mapAll(doctorServices, DoctorServicesDto.class)
					: new ArrayList<>();

			List<DoctorSpeciality> doctorSpecialities = doctorSpecRepository.findByDoctorId(doctorId);
			List<DoctorSpecDto> doctorSpecDtos = doctorSpecialities != null && !doctorSpecialities.isEmpty()
					? ObjectMapperUtils.mapAll(doctorSpecialities, DoctorSpecDto.class)
					: new ArrayList<>();

			List<DoctorRewards> doctorRewards = doctorAMRRepository.findByDoctorId(doctorId);
			List<DoctorAmrDto> doctorRewardDtos = doctorRewards != null && !doctorRewards.isEmpty()
					? ObjectMapperUtils.mapAll(doctorRewards, DoctorAmrDto.class)
					: new ArrayList<>();

			List<DoctorEducation> doctorEducation = doctorEducationRepository.findByDoctorId(doctorId);
			List<DoctorEducationDto> doctorEducationDto = doctorEducation != null && !doctorEducation.isEmpty()
					? ObjectMapperUtils.mapAll(doctorEducation, DoctorEducationDto.class)
					: new ArrayList<>();

			return DoctorDetailsDto.builder().doctorInfo(doctorInfodto).doctorExp(doctorExperienceDto)
					.doctorEducation(doctorEducationDto)
					.doctorServices(docServicesDtos.stream().filter(s -> s.getIsActive().equals('Y'))
							.collect(Collectors.toList()))
					.doctorSpec(doctorSpecDtos.stream().filter(s -> s.getIsActive().equals('Y'))
							.collect(Collectors.toList()))
					.doctorRewards(
							doctorRewardDtos.stream().filter(s -> s.getType().equals('A')).collect(Collectors.toList()))
					.doctorMemberShip(
							doctorRewardDtos.stream().filter(s -> s.getType().equals('M')).collect(Collectors.toList()))
					.doctorRegistration(
							doctorRewardDtos.stream().filter(s -> s.getType().equals('R')).collect(Collectors.toList()))
					.build();
		}

		return null;
	}
}
