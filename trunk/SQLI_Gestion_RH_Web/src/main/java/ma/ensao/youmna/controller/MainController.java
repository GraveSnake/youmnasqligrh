package ma.ensao.youmna.controller;

import java.util.List;

import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.service.CollaborateurService;
import ma.ensao.youmna.service.SecurityContextAccessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@Autowired
	SecurityContextAccessor securityContextAccessor;

	@Autowired
	private CollaborateurService collaborateurService;

	private String main;

	/**
	 * @return the main
	 */
	public String getMain() {
		return main;
	}

	/**
	 * @param main
	 *            the main to set
	 */
	public void setMain(String main) {
		this.main = main;
	}

	/*
	 * Home View
	 */
	@RequestMapping("index")
	public ModelAndView main() {
		return new ModelAndView(main);
	}

	/*
	 * Login View
	 */
	@RequestMapping(value = { "/", "login" })
	public ModelAndView root() {
		if (securityContextAccessor.isCurrentAuthenticationAnonymous()) {
			return new ModelAndView("login");
		} else {
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			 auth.getName();
//			 collaborateurService.get
			return new ModelAndView("redirect:" + main);
		}
	}

	/*
	 * AdminManager View
	 */
	@RequestMapping("adminManagers")
	public ModelAndView managers() {
		ModelAndView mav = new ModelAndView("admin_managers");
		List<Collaborateur> managers = collaborateurService
				.getAllCollaborateursByRole("Manager");
		mav.addObject("ListManager", managers);
		mav.addObject("VIEW", "show");

		return mav;
	}

	/*
	 * Collaborators View
	 */
	@RequestMapping(value = "collaborators", method = RequestMethod.GET)
	public ModelAndView collaborators() {
		ModelAndView mav = new ModelAndView("collaborators");
		List<Collaborateur> collaborateur = collaborateurService
				.getAllCollaborateursByRole("Collaborateur");
		mav.addObject("ListCollab", collaborateur);
		mav.addObject("VIEW", "show");
		return mav;
	}

	/*
	 * Administration View
	 */
	@RequestMapping("administration")
	public ModelAndView administration() {
		return new ModelAndView("administration");
	}

	/*
	 * Account View
	 */
	@RequestMapping("account")
	public ModelAndView account() {
		return new ModelAndView("account");
	}
	
	
}
