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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.naztech.prescription.model.Doctor;
import io.naztech.prescription.service.DoctorService;
/**
 * Doctor Controller
 * @author naym.hossain
 * @since 2019-03-27
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService docServ;
	
	@GetMapping("/all")
	public List<Doctor> getAll(){
		return docServ.getAll();
	}
	
	@PostMapping("/login")
	public Doctor login(@RequestParam String user,@RequestParam String password) {
		System.out.println(user+"--"+password);
		return docServ.login(user, password);
	}
	
	@GetMapping("/get/{id}")
	public Optional<Doctor> getById(@PathVariable(value = "id") Long id) {
		return docServ.getById(id);
	}

	@PostMapping("/save")
	public Doctor save(@ModelAttribute Doctor doc) {
		return docServ.save(doc);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable(value = "id") Long id) {
		return docServ.deleteById(id);
	}
}
