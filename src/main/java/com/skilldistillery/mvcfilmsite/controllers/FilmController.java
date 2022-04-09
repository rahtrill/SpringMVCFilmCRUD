package com.skilldistillery.mvcfilmsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.mvcfilmsite.data.FilmDAO;
import com.skilldistillery.mvcfilmsite.entities.Film;

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
		
		Film film = filmDao.findFilmByKeyword(keyword );
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/result.jsp");
		
		return mv;
	}
	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(Film film, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		
		 filmDao.createFilm(film );
	
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmAdded.do");
		
		return mv;
	}
	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(Film film, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		
		filmDao.updateFilm(film );
		
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmUpdated.do");
		
		return mv;
	}
	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(Film film, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		
		filmDao.deleteFilm(film );
		
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmDeleted.do");
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(path="filmAdded.do", method = RequestMethod.GET)
	public ModelAndView filmAdded (Film film) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("WEB-INF/result.jsp");
		
		
		
		return mv;
	}
	@RequestMapping(path="filmUpdated.do", method = RequestMethod.GET)
	public ModelAndView filmUpdated (Film film) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("WEB-INF/result.jsp");
		
		
		
		return mv;
	}
	@RequestMapping(path="filmDeleted.do", method = RequestMethod.GET)
	public ModelAndView filmDeleted (Film film) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("WEB-INF/result.jsp");
		
		return mv;
	}
}
