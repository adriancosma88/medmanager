package com.cleancode.reservations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTestCase {
	private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStream() {
		System.setOut(new PrintStream(outputContent));
	}
	
	@After
	public void cleanUpStream() {
		System.setOut(null);
	}
	
	@Test
	public void enter3UnexistentEmails_shouldDisplay3wrongAttemps_AndExitTheApplication() throws Exception {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("wrong attempt 3times".getBytes());
		System.setIn(inputStream);
		
		App.main(null);
		
		Assert.assertEquals(("Please enter your email for login.email:"
					+ "Account wrong does not exist."
					+ "Please enter your email for login.email:"
					+ "Account attempt does not exist."
					+ "Please enter your email for login."
					+ "email:Account 3times does not exist."
					+ "3 wrong attemps. Application will exit."),
				outputContent.toString().replace(System.getProperty("line.separator"), ""));	
	}
	
	@Test
	public void enterExistentEmail_ChooseRegularEveningMovie_shouldCost23() {		
		ByteArrayInputStream inputStream = new ByteArrayInputStream("adrian.cosma@asentinel.com 4 4".getBytes());
		System.setIn(inputStream);
		
		App.main(null);
		
		Assert.assertEquals(("Please enter your email for login.\r\n" + 
				"email:\r\n" +
				"Person [firstname=Adrian, familyname=Cosma, date=1988-09-04, membercard=true, email=adrian.cosma@asentinel.com]\r\n" + 
				"Please choose the movie you want to see:\r\n" + 
				"1. Ice Age 3 3D - Comedy: 12:15 18:45 20:00 \r\n" + 
				"2. The Avangers 3D - Action: 18:15 19:45 21:15 \r\n" + 
				"3. Hangover 2 - comedy: 16:45 19:00 20:15 21:30 \r\n" + 
				"4. The Millers - Conedy: 14:45 16:30 20:00 21:15 \r\n" + 
				"1. 14:45\r\n" + 
				"2. 16:30\r\n" + 
				"3. 20:00\r\n" + 
				"4. 21:15\r\n" + 
				"The price of your ticket is: 23.0").replace(System.getProperty("line.separator"), ""),
				outputContent.toString().replace(System.getProperty("line.separator"), ""));
	}
	
	@Test
	public void enterExistentEmailWithSeniorDiscount_ChooseRegularMorningMovie_shouldCost1155() {		
		ByteArrayInputStream inputStream = new ByteArrayInputStream("sorin.iulus@asentinel.com 3 1".getBytes());
		System.setIn(inputStream);
		
		App.main(null);
		
		Assert.assertEquals(("Please enter your email for login.\r\n" + 
				"email:\r\n" + 
				"Person [firstname=Sorin, familyname=Iulus, date=1943-03-02, membercard=true, email=sorin.iulus@asentinel.com]\r\n" + 
				"Please choose the movie you want to see:\r\n" + 
				"1. Ice Age 3 3D - Comedy: 12:15 18:45 20:00 \r\n" + 
				"2. The Avangers 3D - Action: 18:15 19:45 21:15 \r\n" + 
				"3. Hangover 2 - comedy: 16:45 19:00 20:15 21:30 \r\n" + 
				"4. The Millers - Conedy: 14:45 16:30 20:00 21:15 \r\n" +
				"1. 16:45\r\n" + 
				"2. 19:00\r\n" + 
				"3. 20:15\r\n" + 
				"4. 21:30\r\n" + 
				"The price of your ticket is: 11.55").replace(System.getProperty("line.separator"), ""),
				outputContent.toString().replace(System.getProperty("line.separator"), ""));
	}
}
