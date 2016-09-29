package com.cleancode.reservations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
	private static final String ACTION = "Action";
	private static final String COMEDY = "Comedy";

	public static void main(String[] args) {
		System.out.println(doLogic());
	}

	@SuppressWarnings({ "resource" })
	private static String doLogic() {

		List<Person> persons = Arrays
				.asList(new Person("Adrian", "Cosma", LocalDate.of(1988, 9, 4), true, "adrian.cosma@asentinel.com"),
						new Person("Bogdan", "Popescu", LocalDate.of(1988, 7, 18), true,
								"bogdan.popescu@asentinel.com"),
				new Person("Sorin", "Slavic", LocalDate.of(2007, 8, 23), true, "sorin.slavic@asentinel.com"),
				new Person("Denisa", "Cirstescu", LocalDate.of(1989, 8, 28), false, "denisa.cirstescu@asentinel.com"),
				new Person("Sorin", "Iulus", LocalDate.of(1943, 3, 2), true, "sorin.iulus@asentinel.com"));

		List<Movie> movies = Arrays.asList(
				new Movie("Ice Age 3", COMEDY, true,
						Arrays.asList(LocalTime.of(12, 15), LocalTime.of(18, 45), LocalTime.of(20, 00))),
				new Movie("The Avangers", ACTION, true,
						Arrays.asList(LocalTime.of(18, 15), LocalTime.of(19, 45), LocalTime.of(21, 15))),
				new Movie("Hangover 2", COMEDY, false,
						Arrays.asList(LocalTime.of(16, 45), LocalTime.of(19, 00), LocalTime.of(20, 15),
								LocalTime.of(21, 30))),
				new Movie("The Millers", COMEDY, false, Arrays.asList(LocalTime.of(14, 45), LocalTime.of(16, 30),
						LocalTime.of(20, 00), LocalTime.of(21, 15))));


		// if you write an email that does not exist for 3 times the application
		// will exit and you need to start it again in order to make another
		// reservation.
		Scanner scanner = new Scanner(System.in);
		Person person = null;
		person = login(persons, scanner, person);
		
		if(isNull(person)){
			return "3 wrong attemps. Application will exit.";
		}		
		
		//This is where you see the list of movies.
		System.out.println("Please choose the movie you want to see:");
		printMovies(movies);

		int minute = scanner.nextInt();
		Movie movie = movies.get(minute - 1);
		BigDecimal price = processRequest(movies, scanner, person, minute, movie);

		return "The price of your ticket is: " + price;
	}

	private static BigDecimal processRequest(List<Movie> movies, Scanner scanner, Person person, int minute,
			Movie movie) {
		printMovie(movies, minute);
		int h = scanner.nextInt();
		scanner.close();
		LocalTime hour = movies.get(minute - 1).getHours().get(h - 1);

		// Now you compute the price using an algorithm.
		BigDecimal price = computeRegularPrice(movie, hour);

		// Here we apply discounts seniors an youngsters.
		price = applyDiscount(person, price);
		return price;
	}

	private static void printMovie(List<Movie> movies, int minute) {
		List<LocalTime> movieSchedule = movies.get(minute - 1).getHours();
		for (int i = 0; i < movieSchedule.size(); i++) {
			System.out.println(i + 1 + ". " + movieSchedule.get(i));
		}
	}

	private static void printMovies(List<Movie> list2) {
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + 1 + ". " + list2.get(i));
		}
	}



	private static Person login(List<Person> list, Scanner s, Person prs) {
		for (int i = 0; i < 3; i++) {
			System.out.println("Please enter your email for login.");
			System.out.println("email:");
			String account = s.next();
			for (Person p : list)
				if (p.email.equalsIgnoreCase(account)) {
					prs = p;
					break;
				}
			if (isNull(prs))
				System.out.println("Account " + account + " does not exist.");
			else
				break;
		}
		if (prs != null) {
			System.out.println(prs);
		} 
		return prs;
	}

	private static boolean isNull(Object obj) {
		return obj == null;
	}
	private static BigDecimal applyDiscount(Person prs, BigDecimal price) {
		if (prs.isJunior())
			price = applyJuniorDiscount(price);

		if (prs.isSenior())
			price = applySeniorDiscount(price);
		
		return price;
	}

	private static BigDecimal applySeniorDiscount(BigDecimal price) {
		price = price.multiply(BigDecimal.valueOf(0.7));
		return price;
	}

	private static BigDecimal applyJuniorDiscount(BigDecimal price) {
		price = price.multiply(BigDecimal.valueOf(0.8));
		return price;
	}

	private static BigDecimal computeRegularPrice(Movie mov, LocalTime hour) {
		BigDecimal price = BigDecimal.valueOf(0);
		if (hour.isBefore(LocalTime.of(17, 0))) {
			if (!mov.is_3d())
				price = BigDecimal.valueOf(16.5);
			else
				price = BigDecimal.valueOf(19.0);
		} else {
			if (!mov.is_3d())
				price = BigDecimal.valueOf(23.0);
			else
				price = BigDecimal.valueOf(27.0);
		}
		return price;
	}
	
	
	
}
