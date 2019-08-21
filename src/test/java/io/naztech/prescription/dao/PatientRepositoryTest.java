package io.naztech.prescription.dao;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.naztech.prescription.model.Patient;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientRepositoryTest {
	
	@Autowired PatientRepository repo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindByName() {
		List<Patient> patList = repo.findByName("Naym");
		System.out.println(patList.size());
	}

	@Test
	public void testGetOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllSort() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllPageable() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdate() {
		Patient pat = new Patient();
		pat.setKey(2l);
		pat.setName("Naym");
		repo.save(pat);
	}

	@Test
	public void testInsert() {
		Patient pat = new Patient();
		pat.setAge(25);
		pat.setName("Sohan");
		pat.setBloodGroup("B-");
		pat.setDoctorKey(12l);
		pat.setMobile("016863094580");
		pat.setWeight("70kg");
		pat.setPhone("225866");
		repo.save(pat);
	}

	@Test
	public void testFindById() {
		Optional<Patient> pat = repo.findById(1l);
		System.out.println(pat.isPresent());
	}

}
