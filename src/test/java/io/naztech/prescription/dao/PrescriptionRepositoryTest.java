package io.naztech.prescription.dao;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.naztech.prescription.model.Prescription;

public class PrescriptionRepositoryTest {
	@Autowired
	PrescriptionRepository repo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testByPresId() {
		try {
			File file = new File("./uploads/0.iink");
			InputStream in = new FileInputStream(file);
			System.out.println(IOUtils.toByteArray(in));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void save() {
		Prescription pres = new Prescription();
		pres.setDisease("Loose Motion");
		pres.setDoctorKey(12l);
		pres.setPatientKey(2l);
		pres.setPrescription("Ciprocin");
		// pres.setNextVisitDate(LocalDate.now());
		assertNotNull(repo.save(pres));
	}

	@Test
	public void testDateTime() {
		LocalDate date = LocalDate.now();
		LocalDateTime dt2 = date.atTime(23, 59, 59);
		LocalDateTime dt = date.atTime(00, 00, 00);

		List<Prescription> li = repo.findAllByPrescriptionDateBetween(dt, dt2);
		System.out.println(li.size());
	}

	@Test
	public void testFindByPatientKey() {
		List<Prescription> li = repo.findByPatientKey(1l);
		System.out.println(li.size());
	}

}
