package io.naztech.prescription.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import io.naztech.prescription.JsonUtil;
import io.naztech.prescription.model.Prescription;


@RunWith(SpringRunner.class)
@WebMvcTest(PrescriptionController.class)
public class PrescriptionControllerTest {
	@Autowired 
	private MockMvc mvc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveP() throws Exception {
		byte[] json = JsonUtil.convertObjectToJsonBytes(newPrescription());
		System.out.println(new String(json));

		mvc.perform(
				post("/prescription/saveP")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(json)
			)
			.andExpect(status().isOk());
	}

	private Prescription newPrescription() {
		Prescription pres = new Prescription();
		pres.setDisease("Fever");
		pres.setDoctorKey(12l);
		pres.setPatientKey(2l);
		pres.setPrescription("Napa");
		//pres.setPrescriptionDate(LocalDateTime.now());
		//pres.setNextVisitDate(LocalDate.now());
		return pres ;
	}


	@Test
	public void testFindByDate() throws Exception {
		mvc.perform(get("/prescription/getbydate").contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.id", is(1)));
	}

	@Test
	public void testGetByPateintKey() {
		fail("Not yet implemented");
	}

}
