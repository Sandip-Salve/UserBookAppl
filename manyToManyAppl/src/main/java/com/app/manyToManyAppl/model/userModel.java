package com.app.manyToManyAppl.model;

import java.util.HashSet;
import java.util.Set;

import com.app.manyToManyAppl.entity.DoctorEnum;

public class userModel {

	private String patientName;
	private String disease;
	private Set<DoctorEnum> doctors = new HashSet<>();

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Set<DoctorEnum> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<DoctorEnum> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "userModel [patientName=" + patientName + ", disease=" + disease + ", doctors=" + doctors + "]";
	}

}
