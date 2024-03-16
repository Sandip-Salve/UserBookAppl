package com.app.manyToManyAppl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOC_Entity")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOC_ID")
	private Long doctorId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "DOC_NAME", length = 30)
	private DoctorEnum doctorName;
	
	public Doctor() {
		
	}
	
	public Doctor(DoctorEnum docName) {
		this.doctorName = docName;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public DoctorEnum getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(DoctorEnum doctorName) {
		this.doctorName = doctorName;
	}
	
	
}
