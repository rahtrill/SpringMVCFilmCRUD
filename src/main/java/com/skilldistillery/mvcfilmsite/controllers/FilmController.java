package com.skilldistillery.mvcfilmsite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.mvcfilmsite.data.FilmDAO;
import com.skilldistillery.mvcfilmsite.entities.Actor;
import com.skilldistillery.mvcfilmsite.entities.Film;

//String title;
//private String description;
//private Integer releaseYear;
//private int languageId;
//private int rentalDuration;
//private double rentalRate;
//private Integer length;
//private double replacementCost;
//private String rating;
//String specialFeatures;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "WEB-INF/index.html";
	}

	@RequestMapping(path = "findByID.do", method = RequestMethod.GET)
	public ModelAndView findByID(int id) {
		ModelAndView mv = new ModelAndView();

		Film film = filmDao.findFilmById(id);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/result.jsp");

		return mv;
	}

	@RequestMapping(path = "findByKeyword.do", method = RequestMethod.GET)
	public ModelAndView findByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();

		List<Film> film = filmDao.findFilmByKeyword(keyword);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/keyword.jsp");

		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(String title, String description, int releaseYear, int languageId,
			int rentalDuration, double rentalRate, int length, double replacementCost, String rating,
			String specialFeatures, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();

		Film film = new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
		film.setLanguageId(languageId);
		film.setRentalDuration(rentalDuration);
		film.setRentalRate(rentalRate);
		film.setLength(length);
		film.setReplacementCost(replacementCost);
		film.setRating(rating);
		film.setSpecialFeatures(specialFeatures);

		filmDao.createFilm(film);

		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmAdded.do");

		return mv;
	}

	// This method sends it to the HTML search page.
	@RequestMapping(path = "filmUpdatePage.do", method = RequestMethod.GET)
	public ModelAndView sendToUpdate(int id) {
		ModelAndView mv = new ModelAndView();

		Film film = filmDao.findFilmById(id);

		mv.addObject("film", film);
		mv.setViewName("update.jsp");

		return mv;
	}
	// This method sends it to the update page.

	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(@RequestParam("id") int id, String title, String description, Integer releaseYear,
			int rentalDuration, double rentalRate, Integer length, double replacementCost, String rating,
			String specialFeatures, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();

		Film film = filmDao.findFilmById(id);
		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
		film.setRentalDuration(rentalDuration);
		film.setRentalRate(rentalRate);
		film.setLength(length);
		film.setReplacementCost(replacementCost);
		film.setRating(rating);
		film.setSpecialFeatures(specialFeatures);

		filmDao.updateFilm(film);

		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmUpdated.do");

		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(int id, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();

		Film film = filmDao.findFilmById(id);
		filmDao.deleteFilm(id);

		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmDeleted.do");

		return mv;
	}

	@RequestMapping(path = "filmAdded.do", method = RequestMethod.GET)
	public ModelAndView filmAdded() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/result.jsp");

		return mv;
	}

	@RequestMapping(path = "filmUpdated.do", method = RequestMethod.GET)
	public ModelAndView filmUpdated(Film film) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/result.jsp");

		return mv;
	}

	@RequestMapping(path = "filmDeleted.do", method = RequestMethod.GET)
	public ModelAndView filmDeleted(Film film) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("film", film);
		mv.setViewName("WEB-INF/delete.jsp");

		return mv;
	}
	
	//ACTOR STUFF
	
	@RequestMapping(path = "findActorByID.do", method = RequestMethod.GET)
	public ModelAndView findActorByID(int id) {
		ModelAndView mv = new ModelAndView();

		Actor actor = filmDao.findActorById(id);
		mv.addObject("actor", actor);
		mv.setViewName("WEB-INF/actorResult.jsp");

		return mv;
	}
	
	@RequestMapping(path = "addActor.do", method = RequestMethod.POST)
	public ModelAndView createActor(String firstName, String lastName, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();

		Actor actor = new Actor();
		actor.setFirstName(firstName);
		actor.setLastName(lastName);

		filmDao.createActor(actor); // TODO: Create createActor() in DAO

		redir.addFlashAttribute("actor", actor);
		mv.setViewName("redirect:actorAdded.do");

		return mv;
	}
	
	@RequestMapping(path = "actorAdded.do", method = RequestMethod.GET)
	public ModelAndView actorAdded() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/actorResult.jsp");

		return mv;
	}
	
	@RequestMapping(path = "deleteActor.do", method = RequestMethod.POST)
	public ModelAndView deleteActor(int id, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();

		Actor actor = filmDao.findActorById(id);
		filmDao.deleteActor(id); // TODO: Create deleteActor() in DAO

		redir.addFlashAttribute("actor", actor);
		mv.setViewName("redirect:filmDeleted.do");

		return mv;
	}
	
	@RequestMapping(path = "actorDeleted.do", method = RequestMethod.GET)
	public ModelAndView actorDeleted() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/actorDelete.jsp");

		return mv;
	}
	
	// This method sends it to the HTML search page.
		@RequestMapping(path = "actorUpdatePage.do", method = RequestMethod.GET)
		public ModelAndView sendToActorUpdate(int id) {
			ModelAndView mv = new ModelAndView();

			Actor actor = filmDao.findActorById(id);

			mv.addObject("actor", actor);
			mv.setViewName("WEB-INF/actorUpdate.jsp");

			return mv;
		}
		
		// This method sends it to the update page.

		@RequestMapping(path = "updateActor.do", method = RequestMethod.POST)
		public ModelAndView updateActor(@RequestParam("id") int id, String firstName, String lastName, RedirectAttributes redir) {
			ModelAndView mv = new ModelAndView();

			Actor actor = filmDao.findActorById(id);
			actor.setFirstName(firstName);
			actor.setLastName(lastName);
			
			filmDao.updateActor(actor); // TODO: Create updateActor() in DAO

			redir.addFlashAttribute("actor", actor);
			mv.setViewName("redirect:actorUpdated.do");

			return mv;
		}
		
		@RequestMapping(path = "actorUpdated.do", method = RequestMethod.GET)
		public ModelAndView actorUpdated() {
			ModelAndView mv = new ModelAndView();

			mv.setViewName("WEB-INF/actorResult.jsp");

			return mv;
		}
		
		@RequestMapping(path = "addActorToFilm.do", method = RequestMethod.POST)
		public ModelAndView addActorToFilm(int actorId, int id, RedirectAttributes redir) {
			ModelAndView mv = new ModelAndView();

			Actor actor = filmDao.findActorById(actorId);
			filmDao.addActorToFilm(actorId, id);

			redir.addFlashAttribute("actor", actor);
			mv.setViewName("redirect:actorAddedToFilm.do");

			return mv;
		}
}
