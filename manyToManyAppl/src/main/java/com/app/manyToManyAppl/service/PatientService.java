package com.app.manyToManyAppl.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.manyToManyAppl.dao.DoctorRepository;
import com.app.manyToManyAppl.dao.PatientRepository;
import com.app.manyToManyAppl.entity.Doctor;
import com.app.manyToManyAppl.entity.Patient;
import com.app.manyToManyAppl.model.userModel;

@Service
@Transactional
public class PatientService {

	@Autowired
	private PatientRepository patRepo;
	
	@Autowired
	private DoctorRepository docRepo;
	
	public Patient savePatientEntry(userModel userModel) {
		Patient obj = new Patient();
		obj.setDisease(userModel.getDisease());
		obj.setPatientName(userModel.getPatientName());
		Set<Doctor> docSet = docRepo.findByDoctorNameIn(userModel.getDoctors());
		obj.setDoctors(docSet);
		return patRepo.save(obj);
	}
}
