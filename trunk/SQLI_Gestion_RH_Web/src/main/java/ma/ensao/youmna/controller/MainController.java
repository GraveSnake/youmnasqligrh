package ma.ensao.youmna.controller;

import java.util.ArrayList;
import java.util.List;

import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.service.CollaborateurService;
import ma.ensao.youmna.service.CompteService;
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
	
	@Autowired
	private CompteService compteService;

	private String main;
	
	private static Collaborateur currentCollab;
	

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
			getCurrent();
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
		for(int i=0;i<managers.size();i++){
			managers.get(i).setStatus(compteService.getCompteByLogin(managers.get(i).getCompte().getLogin()).getActive());	
		}
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
		List<Collaborateur> collaborateur =new ArrayList<Collaborateur>();
		getCurrent();
		if("Manager".equals(currentCollab.getRole()))
			collaborateur =collaborateurService.getAllCollaborateursByManager(currentCollab.getNom());
		else collaborateur =collaborateurService.getAllCollaborateursByRole("Collaborateur");
		mav.addObject("ListCollab", collaborateur);
		mav.addObject("VIEW", "show");
		return mav;
	}

	private void getCurrent() {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 currentCollab=collaborateurService.getCollaborateurByLogin(auth.getName());
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
