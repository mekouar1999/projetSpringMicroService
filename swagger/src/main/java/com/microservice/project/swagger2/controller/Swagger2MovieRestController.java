package com.microservice.project.swagger2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.project.swagger2.model.Actor;
import com.microservice.project.swagger2.model.Date;
import com.microservice.project.swagger2.model.Film;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Swagger2MovieRestController", description = "REST Apis related to Film and Actor Entities!!")
@RestController
public class Swagger2MovieRestController {


	private List<Film> films = new ArrayList<Film>();
	private List<Actor> actors = new ArrayList<Actor>();

	{
		Actor a1 = new Actor("othman", "mekouar", new Date(30, 1, 1974));
		Actor a2 = new Actor("youssef", "mekouar", new Date(9, 8, 1968));
		Actor a3 = new Actor("omar", "mekouar", new Date(6, 7, 1946));
		Actor a4 = new Actor("hamza", "mekouar", new Date(2, 3, 1982));

		Film f1 = new Film("The Pale Blue Eye", "Scott Cooper", a1, new Date(1, 5, 2022));
		Film f2 = new Film("Le Samaritain", "Julius Avery", a3, new Date(31, 1, 2022));

		films.add(new Film("The Pale Blue Eye", "Scott Cooper", actors.get(0), new Date(1, 5, 2022)));
		films.add(new Film("Le Samaritain", "Julius Avery", actors.get(2), new Date(31, 1, 2022)));
	}

	@ApiOperation(value = "Get list of Actors ", response = Iterable.class, tags = "getActors")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	@RequestMapping(value = "/getActors")
	public List<Actor> getActors() {
		return actors;
	}

	@ApiOperation(value = "Get list of Films ", response = Iterable.class, tags = "getFilms")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	@RequestMapping(value = "/getFilm")
	public List<Film> getFilms() {
		return films;
	}

	@ApiOperation(value = "delete specific Actor in the System ", response = Actor.class, tags = "deleteActor")
	@RequestMapping(value = "/deleteActor/{name}")
	public Actor deleteActor(@PathVariable(value = "name") String name) {
		for (Actor actor : actors) {
			if (name.equals(actor.getFirstName() + " " + actor.getLastName())) {
				actors.remove(actor);
				return actor;
			}
		}
		return null;
	}

	@ApiOperation(value = "delete specific Film in the System ", response = Actor.class, tags = "deleteFilm")
	@RequestMapping(value = "/deleteFilm/{title}")
	public Film deleteFilm(@PathVariable(value = "title") String title) {
		for (Film film : films) {
			if (title.equals(film.getTitle())) {
				films.remove(film);
				return film;
			}
		}
		return null;
	}
}
