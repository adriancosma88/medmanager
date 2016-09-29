package com.cleancode.reservations;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
	public Person(String firstname, String familyname, LocalDate date, boolean membercard, String email) {
		this.firstname = firstname;
		this.familyname = familyname;
		this.date = date;
		this.membercard = membercard;
		this.email = email;
	}
	
	public String firstname;
	public String familyname;
	public LocalDate date;
	public boolean membercard;
	public String email;
	
	@Override	
	public String toString() {
		return "Person [firstname=" + firstname + ", familyname=" + familyname + ", date=" + date + ", membercard="
				+ membercard + ", email=" + email + "]";
	}
	
	public boolean isSenior(){
		return this.date.until(LocalDate.now(), ChronoUnit.YEARS) > 60;
	}
	
	public boolean isJunior(){
		return this.date.until(LocalDate.now(), ChronoUnit.YEARS) < 18;
	}
	
}
