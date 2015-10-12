package controller.patients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import data.repository.PatientRepository;
import domain.Patient;

@RequestMapping("/patient")
@RestController
public class PatientsRestController {
	private final PatientRepository patientRepo;
	
	@Autowired
	public PatientsRestController (PatientRepository patientRepo) {
		this.patientRepo = patientRepo;
	}
	
	@RequestMapping("/json-list")
	public List<Patient> showListAsJson() {
		return patientRepo.findAll();
	}
}
