package com.app.manyToManyAppl.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.manyToManyAppl.entity.Doctor;
import com.app.manyToManyAppl.entity.DoctorEnum;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	Set<Doctor> findByDoctorNameIn(Set<DoctorEnum> docs);
}
