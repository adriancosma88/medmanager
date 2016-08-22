package com.cleancode.reservations;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Movie {	
	public Movie(String title, String genre, boolean _3d, List<LocalTime> hour) {
		super();
		this.title = title;
		this.genre = genre;
		this._3d = _3d;
		this.hours = hour;
	}
	private String title;
	private String genre;
	private boolean _3d;
	private List<LocalTime> hours;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public boolean is_3d() {
		return _3d;
	}
	public void set_3d(boolean _3d) {
		this._3d = _3d;
	}
	public List<LocalTime> getHours() {
		return hours;
	}
	public void setHour(List<LocalTime> hours) {
		this.hours = hours;
	}
	@Override
	public String toString() {
		String hoursString = "";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		for (LocalTime hourItem : hours) {
			hoursString += hourItem.format(dtf) + " ";
		}
		return title + (_3d ? " 3D" : "") + " - " + genre + ": " + hoursString;
		
	}	
}
