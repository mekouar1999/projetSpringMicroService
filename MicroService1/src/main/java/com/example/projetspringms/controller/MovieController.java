package com.example.projetspringms.controller;

import com.example.projetspringms.models.Date;
import com.example.projetspringms.models.Film;
import com.example.projetspringms.models.Actor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
public class MovieController {

	private static Map<String, Film> films = new HashMap<String, Film>();
	private static Map<String, Actor> actors = new HashMap<String, Actor>();



	static {
		Actor a1 = new Actor("othman", "mekouar", new Date(30, 1, 1974));
		Actor a2 = new Actor("youssef", "mekouar", new Date(9, 8, 1968));
		Actor a3 = new Actor("omar", "mekouar", new Date(6, 7, 1946));
		Actor a4 = new Actor("hamza", "mekouar", new Date(2, 3, 1982));

		Film f1 = new Film("The Pale Blue Eye", "Scott Cooper", a1, new Date(1, 5, 2022));
		Film f2 = new Film("Le Samaritain", "Julius Avery", a3, new Date(31, 1, 2022));

		a2.addFilm(f1);
		a4.addFilm(f2);

		films.put(f1.getTitle(), f1);
		films.put(f1.getTitle(), f2);

		actors.put(a1.getFirstName() + " " + a1.getLastName(), a1);
		actors.put(a2.getFirstName() + " " + a2.getLastName(), a1);
		actors.put(a3.getFirstName() + " " + a3.getLastName(), a1);
		actors.put(a4.getFirstName() + " " + a4.getLastName(), a1);
	}

	@RequestMapping(value = "/getAllActors", method = RequestMethod.GET)
	public List<Actor> getAllActors() {
		System.out.println("Getting All Actors");

		List<Actor> allActors = new ArrayList<Actor>(actors.values());
		return allActors;
	}

	@RequestMapping(value = "/getActorByName/{name}", method = RequestMethod.GET)
	public Actor getActorByName(@PathVariable String name) {
		System.out.println("Getting Actor " + name);
		return actors.get(name);
	}

	@RequestMapping(value = "/getActorsByFilm", method = RequestMethod.GET)
	public List<Actor> getActorsByFilm(@PathVariable String title) {
		System.out.println("Getting Actors by film title " + title);
		Collection<Actor> c1 = actors.values();
		List<Actor> result = new ArrayList<Actor>();
		for (Actor a : c1) {
			if (a.inFilmography(title)) result.add(a);
		}
		return result;
	}

	@RequestMapping(value = "/getAllFilms", method = RequestMethod.GET)
	public List<Film> getAllFilms() {
		System.out.println("Getting All Films");

		List<Film> allFilms = new ArrayList<Film>(films.values());
		return allFilms;
	}

	@RequestMapping(value = "/getFilmByTitle/{name}", method = RequestMethod.GET)
	public Film getFilmByTitle(@PathVariable String title, @PathVariable String name) {
		System.out.println("Getting Film " + title);
		return films.get(title);
	}

	@RequestMapping(value = "/getFilmsByReleaseYear", method = RequestMethod.GET)
	public List<Film> getFilmsByReleaseYear(@PathVariable int year) {
		System.out.println("Getting Films by release year " + year);
		Collection<Film> c1 = films.values();
		List<Film> result = new ArrayList<Film>();
		for (Film f : c1) {
			if (f.getReleaseDate().getYear() == year) result.add(f);
		}
		return result;
	}
}
