package controller.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import data.repository.PatientRepository;
import domain.Patient;

@Controller
public class PatientController {
	private final PatientRepository patientRepo;
	
	@Autowired
	public PatientController(PatientRepository patientRepo) {
		this.patientRepo = patientRepo;
	}
	
	@RequestMapping("/patient/list")
	public String showPatientList (Model model) {
		model.addAttribute("patients", patientRepo.findAll());
		return "patients";
	}
	
	@RequestMapping(value = "/patient/add", method = RequestMethod.GET)
	public String showAddPatient () {
		return "add-patient";
	}
	
	@RequestMapping(value = "/patient/add", method = RequestMethod.POST)
	public String addPatient (@ModelAttribute Patient patient) {
		patientRepo.save(patient);
		return "redirect:/patient/list";
	}
}
