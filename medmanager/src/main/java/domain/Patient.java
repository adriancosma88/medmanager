package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue
	private int patientId;
	
	private String firstName;
	
	private String lastName;
	
	@NotNull
	private String pnc;
	
	private Date dateOfBirth;
	
	private Gender gender;	

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPnc() {
		return pnc;
	}

	public void setPnc(String pnc) {
		this.pnc = pnc;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", pnc=" + pnc + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + "]";
	}

	public enum Gender {
		MALE,
		FEMALE
	}
}
