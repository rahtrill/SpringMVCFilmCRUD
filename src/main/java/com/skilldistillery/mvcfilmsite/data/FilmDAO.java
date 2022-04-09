package com.skilldistillery.mvcfilmsite.data;

import java.util.List;

import com.skilldistillery.mvcfilmsite.entities.Actor;
import com.skilldistillery.mvcfilmsite.entities.Film;
import com.skilldistillery.mvcfilmsite.entities.Language;

public interface FilmDAO {
	public Film findFilmById(int filmId);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);

	public Film findFilmByKeyword(String input);

	public Language languageFromId(int idForLanguage);

	public Film createFilm(Film film);
}
