package com.microservice.project.swagger2.model;

public class Film {
	private String title;
	private String director;
	private Actor mainActor;
	private Date releaseDate;
	
	public Film() {
	}

	public Film(String title, String director, Actor mainActor, Date releaseDate) {
		super();
		this.title = title;
		this.director = director;
		this.mainActor = mainActor;
		this.releaseDate = releaseDate;
		mainActor.addFilm(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Actor getMainActor() {
		return mainActor;
	}

	public void setMainActor(Actor mainActor) {
		this.mainActor = mainActor;
		mainActor.addFilm(this);
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Film [title=" + title + ", director=" + director + ", mainActor=" + mainActor + ", releaseDate="
				+ releaseDate + "]";
	}
}
