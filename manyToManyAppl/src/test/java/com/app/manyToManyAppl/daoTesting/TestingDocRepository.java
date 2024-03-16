package com.app.manyToManyAppl.daoTesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.manyToManyAppl.dao.DoctorRepository;
import com.app.manyToManyAppl.entity.Doctor;
import com.app.manyToManyAppl.entity.DoctorEnum;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestingDocRepository {

	@Autowired
	private DoctorRepository docRepo;

	@Test
	@Rollback(false)
	void testDrBhoke() {
		System.out.println(docRepo.save(new Doctor(DoctorEnum.DR_BHOKE)));
	}

	@Test
	@Rollback(false)
	void testDrJalak() {
		System.out.println(docRepo.save(new Doctor(DoctorEnum.DR_JALAK)));
	}

	@Test
	@Rollback(false)
	void testDrPurandare() {
		System.out.println(docRepo.save(new Doctor(DoctorEnum.DR_PURANDARE)));
	}

}
