package io.naztech.prescription.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.naztech.prescription.model.Patient;
import io.naztech.prescription.service.PatientService;
/**
 * Patient Controller
 * @author naym.hossain
 * @since 2019-03-27
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired PatientService patServ;

	@GetMapping("/all")
	public List<Patient> getAll() {
		return patServ.getAll();
	}

	@GetMapping("/get/{id}")
	public Optional<Patient> getById(@PathVariable(value = "id") Long id) {
		return patServ.getById(id);
	}

	@PostMapping("/save")
	public Patient save(@ModelAttribute Patient ob) {
		return patServ.save(ob);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable(value = "id") Long id) {
		return patServ.deleteById(id);
	}

	@GetMapping("/getbyname/{name}")
	public List<Patient> getByName(@PathVariable(value = "name") String name) {
		return patServ.getByName(name);
	}

	@GetMapping("/getbyphone/{phone}")
	public List<Patient> getByPhone(@PathVariable(value = "phone") String phone) {
		return patServ.getByPhone(phone);
	}
}
