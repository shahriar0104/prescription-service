package io.naztech.prescription.dao;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.naztech.prescription.model.Doctor;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorRepositoryTest {
	@Autowired DoctorRepository repo;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void save() {
		Doctor doc = new Doctor();
		doc.setName("Mahmudul");
		doc.setSpeciality("neurology");
		doc.setMobile("01711525613");
		doc.setPhone("22458");
		repo.save(doc);
	}
	@Test
	public void testLogin() {
		Doctor doctor = repo.findByUserAndPassword("Naym", "4321");
		System.out.println(doctor.toString());
	}
	
	@Test
	public void testFindByName() {
		List<Doctor> docList = repo.findByName("Assaduzzaman");
		System.out.println(docList.size());
	}
	
	@Test
	public void testFindById() {
		Optional<Doctor> doc = repo.findById(1l);
		System.out.println(doc.isPresent());
	}
}
