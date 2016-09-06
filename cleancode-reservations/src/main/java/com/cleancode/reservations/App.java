package com.cleancode.reservations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	System.out.println(doLogic());
    }

	private static String doLogic() {
        List<Person> personList = getPersonTestData();
        List<Movie> movieList = getMoviesTestData();
        
        //if you write an email that does not exist for 3 times the application will exit and you need to start it again in order to make another reservation. This can consume time and you don't want that, do you?
        Scanner scanner = new Scanner(System.in);
        Person person = null;
        
		person = getLoggedInPersonFromEmail(personList, scanner, person);
		
		if (person != null) {
			displayPersonIsOkMessage(person);
		} else {
			return getApplicationExitMessage();
		}
        
        displayMovieList(movieList);        
        int movieInputIndex = scanner.nextInt();
        Movie selectedMovie = movieList.get(movieInputIndex-1);
        
        LocalTime hour = getSelectedMovieHour(movieList, scanner, movieInputIndex);
        
        //Now you compute the price using an algorithm.
        BigDecimal price = BigDecimal.valueOf(0);
        if (hour.isBefore(LocalTime.of(17, 0)))
			if (!selectedMovie.is_3d())
				price = BigDecimal.valueOf(16.5);
			else
				price = BigDecimal.valueOf(19.0);
        else 
        	if (!selectedMovie.is_3d())
        		price = BigDecimal.valueOf(23.0);
        	else
        		price = BigDecimal.valueOf(27.0);
        
        //Here we apply discounts seniors an youngsters.
        //The date of birth is taken from the person logged in at line 47
        if (person.date.until(LocalDate.now(), ChronoUnit.YEARS) < 18)
        	price = price.multiply(BigDecimal.valueOf(0.8));
        
        if (person.date.until(LocalDate.now(), ChronoUnit.YEARS) > 60)
        	price = price.multiply(BigDecimal.valueOf(0.7));
        
        return "The price of your ticket is: " + price;
	}

	private static LocalTime getSelectedMovieHour(List<Movie> movieList, Scanner scanner, int movieInputIndex) {
		displaySelectedMovieHours(movieList, movieInputIndex);
        int h = scanner.nextInt();
        scanner.close();
        LocalTime hour = movieList.get(movieInputIndex-1).getHours().get(h-1);
		return hour;
	}

	private static void displaySelectedMovieHours(List<Movie> movieList, int movieInputIndex) {
		for (int i=0; i<movieList.get(movieInputIndex-1).getHours().size() ; i++) {
        	System.out.println(i + 1 + ". " + movieList.get(movieInputIndex-1).getHours().get(i));
        }
	}

	private static void displayMovieList(List<Movie> list2) {
		System.out.println("Please choose the movie you want to see:");
        for(int i=0; i < list2.size() ; i++) {
        	System.out.println(i + 1 + ". " + list2.get(i));
        }
	}

	private static String getApplicationExitMessage() {
		return "3 wrong attemps. Application will exit.";
	}

	private static void displayPersonIsOkMessage(Person person) {
		System.out.println(person);
	}

	private static List<Movie> getMoviesTestData() {
		return Arrays.asList(
        		new Movie("Ice Age 3", "Comedy", true, Arrays.asList(LocalTime.of(12, 15), LocalTime.of(18, 45), LocalTime.of(20, 00))),
        		new Movie("The Avangers", "Action", true, Arrays.asList(LocalTime.of(18, 15), LocalTime.of(19, 45), LocalTime.of(21, 15))),
        		new Movie("Hangover 2", "comedy", false, Arrays.asList(LocalTime.of(16, 45), LocalTime.of(19, 00), LocalTime.of(20, 15), LocalTime.of(21, 30))),
        		new Movie("The Millers", "Conedy", false, Arrays.asList(LocalTime.of(14, 45), LocalTime.of(16, 30), LocalTime.of(20, 00), LocalTime.of(21, 15)))
        		);
	}

	private static List<Person> getPersonTestData() {
		return Arrays.asList(
        		new Person("Adrian", "Cosma", LocalDate.of(1988, 9, 4), true, "adrian.cosma@asentinel.com"),
        		new Person("Bogdan", "Popescu", LocalDate.of(1988, 7, 18), true, "bogdan.popescu@asentinel.com"),
        		new Person("Sorin", "Slavic", LocalDate.of(2007, 8, 23), true, "sorin.slavic@asentinel.com"),
        		new Person("Denisa", "Cirstescu", LocalDate.of(1989, 8, 28), false, "denisa.cirstescu@asentinel.com"),
        		new Person("Sorin", "Iulus", LocalDate.of(1943, 3, 2), true, "sorin.iulus@asentinel.com"));
	}

	private static Person getLoggedInPersonFromEmail(List<Person> list, Scanner scanner, Person person) {
		for (int i = 0; i < 3; i++) {
			String emailInput = getEmailInput(scanner);
			
			for (Person p : list) {
				if (p.email.equalsIgnoreCase(emailInput)) {
					person = p;
					break;
				}
			}
			if (person == null) {
				System.out.println("Account " + emailInput + " does not exist.");
			} else {
				break;
			}
		}
		return person;
	}

	private static String getEmailInput(Scanner scanner) {
		System.out.println("Please enter your email for login.");
		System.out.println("email:");
		String emailInput = scanner.next();
		return emailInput;
	}
}
