package com.app.manyToManyAppl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.manyToManyAppl.entity.Patient;
import com.app.manyToManyAppl.model.userModel;
import com.app.manyToManyAppl.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addPateintEntry(@RequestBody userModel userModel){
		try {
			Patient savePatientEntry = patService.savePatientEntry(userModel);
			return new ResponseEntity<Object>(savePatientEntry, HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<Object>("Error occured during saving patient.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
