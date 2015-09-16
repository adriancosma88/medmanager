package data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	List<Patient> findByLastName (String lastName);
	
	List<Patient> findAll();
}
