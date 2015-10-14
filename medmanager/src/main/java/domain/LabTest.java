package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LabTest {
	@Id
	@GeneratedValue
	private Long testId;
	
	@ManyToOne
	private Patient patient;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String details;

	public LabTest(Long testId, Patient patient, Date date, String details) {
		super();
		this.testId = testId;
		this.patient = patient;
		this.date = date;
		this.details = details;
	}

	public LabTest() {
		super();
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "LabTest [testId=" + testId + ", patient=" + patient + ", date="
				+ date + ", details=" + details + "]";
	}	
}
