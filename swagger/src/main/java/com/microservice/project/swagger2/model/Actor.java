package com.microservice.project.swagger2.model;

import java.util.List;
import java.util.ArrayList;

public class Actor {
	private String firstName;
	private String lastName;
	private Date birthday;
	private List<Film> filmography;
	
	public Actor() {
		filmography = new ArrayList<Film>();
	}

	public Actor(String firstName, String lastName, Date birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		filmography = new ArrayList<Film>();
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<Film> getFilmography() {
		return filmography;
	}

	public void setFilmography(List<Film> filmography) {
		this.filmography = filmography;
	}
	
	public boolean inFilmography(String title) {
		for (Film film : filmography) {
			if (film.getTitle().equals(title)) return true;
		}
		return false;
	}
	
	public void addFilm(Film film) {
		filmography.add(film);
	}

	@Override
	public String toString() {
		return "Actor [firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", filmography="
				+ filmography + "]";
	}
}
