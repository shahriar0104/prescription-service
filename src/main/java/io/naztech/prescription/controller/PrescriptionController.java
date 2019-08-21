package io.naztech.prescription.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.naztech.prescription.model.Patient;
import io.naztech.prescription.model.Prescription;
import io.naztech.prescription.service.PrescriptionService;

/**
 * Prescription Controller
 * 
 * @author naym.hossain
 * @since 2019-03-27
 */
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
	@Autowired private PrescriptionService presServ;
	private static String uploadDirectory = System.getProperty("user.dir")+"/uploads";

	@GetMapping("/all")
	public List<Prescription> getAll() {
		return presServ.getAll();
	}

	/*@GetMapping("/get/{id}")
	public Optional<Prescription> getById(@PathVariable(value = "id") Long id) {
		return presServ.getById(id);
	}*/
	
	@GetMapping("/get/{id}")
	public byte[] getDataById(@PathVariable(value = "id") Long id) {
		try {
			File file = new File("./uploads/0.iink");
			InputStream in = new FileInputStream(file);
			return IOUtils.toByteArray(in);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/save")
	public Prescription save(@RequestPart("prescription") Prescription pres, @RequestPart("patient") Patient pat) {
		return presServ.save(pres, pat);
	}
	
	@PostMapping("/saveP")
	public Prescription saveP(@RequestBody Prescription prescription) {
		System.out.println(prescription.getDoctorKey());
		System.out.println(prescription.getNextVisitDate());
		System.out.println(prescription.getPrescriptionDate());
		System.out.println(prescription.getInkPrescription());
		return null;//presServ.saveP(prescription);
	}
	
	@PostMapping("/saveQ")
	public Prescription saveQ(@RequestParam("file") MultipartFile file) {
		StringBuilder fileName = new StringBuilder();
		Path filePath = Paths.get(uploadDirectory,file.getOriginalFilename());
		fileName.append(file.getOriginalFilename());
		try {
			Files.write(filePath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Prescription pres = new Prescription();
		pres.setDisease("Fever");
		pres.setDoctorKey(12l);
		pres.setPatientKey(2l);
		pres.setPrescription("Napa");
		pres.setPrescriptionDate(LocalDateTime.now());
		pres.setNextVisitDate(LocalDate.now());
		pres.setPath(filePath.toString());
		return presServ.saveQ(pres);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable(value = "id") Long id) {
		return presServ.deleteById(id);
	}

	@GetMapping("/getbydate")
	public List<Prescription> findByDate(LocalDate date) {
		return presServ.findByDate(date);
	}
	
	@GetMapping("/getbypatientid/{id}")
	public List<Prescription> getByPateintKey(@PathVariable(value = "id") Long id){
		return presServ.getByPatientId(id);
	}
}
