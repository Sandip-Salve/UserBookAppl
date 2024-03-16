package com.app.manyToManyAppl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.manyToManyAppl.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
