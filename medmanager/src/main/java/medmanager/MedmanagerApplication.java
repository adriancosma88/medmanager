package medmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import data.repository.PatientRepository;
import domain.Patient;

@SpringBootApplication
@Configuration
@ComponentScan ({"configuration"})
public class MedmanagerApplication implements CommandLineRunner {
	
	@Autowired
	private PatientRepository patientRepo;

    public static void main(String[] args) {
        SpringApplication.run(MedmanagerApplication.class, args);
    }
    
    @Override
    public void run(String... arg0) throws Exception {
    	Patient p1 = new Patient();
    	p1.setFirstName("Adrian");
    	p1.setLastName("Cosma");
    	p1.setPnc("187210008337722");
    	
    	Patient p2 = new Patient();    	
    	p2.setFirstName("Vasilica");
    	p2.setLastName("Cosma");
    	p2.setPnc("1872100014124124");
    	
    	Patient p3 = new Patient();    	
    	p3.setFirstName("Emil");
    	p3.setLastName("Racovita");
    	p3.setPnc("1872214214242722");
    	
    	patientRepo.save(p1);
    	patientRepo.save(p2);
    	patientRepo.save(p3);
    	
    	for (Patient patient : patientRepo.findAll()) {
    		System.out.println(patient);
    	}
    }
    
}
