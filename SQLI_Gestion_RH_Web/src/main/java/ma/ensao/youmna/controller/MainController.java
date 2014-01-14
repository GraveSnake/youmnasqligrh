package ma.ensao.youmna.controller;

import java.util.List;
import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.service.CollaborateurService;
import ma.ensao.youmna.service.SecurityContextAccessor;
import org.springframework.beans.factory.annotation.Autowired;
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
	 * @param main the main to set
	 */
	public void setMain(String main) {
		this.main = main;
	}

	/*
	 *  Home View
	 */
	@RequestMapping("index")
	public ModelAndView main() {
		return new ModelAndView(main);
	}

	/*
	 *  Login View
	 */
	@RequestMapping(value = { "/", "login" })
	public ModelAndView root() {
		if (securityContextAccessor.isCurrentAuthenticationAnonymous()) {
			return new ModelAndView("login");
		} else {
			return new ModelAndView("redirect:" + main);
		}
	}

	/*
	 *  AdminManager View
	 */
	@RequestMapping("adminManagers")
	public ModelAndView managers() {
		return new ModelAndView("admin_managers");
	}

	/*
	 *  Collaborators View
	 */
	@RequestMapping(value = "collaborators", method = RequestMethod.GET)
	public ModelAndView collaborators() {
		ModelAndView mav = new ModelAndView("collaborators");
		List<Collaborateur> collaborateur = collaborateurService
				.getAllCollaborateurs();
		mav.addObject("ListCollab", collaborateur);
		mav.addObject("VIEW", "show");
		return mav;
	}

	// @RequestMapping("reporting")
	// public ModelAndView reporting() {
	// return new ModelAndView("reporting");
	// }

	/*
	 *  Administration View
	 */
	@RequestMapping("administration")
	public ModelAndView administration() {
		return new ModelAndView("administration");
	}

	/*
	 *  Account View
	 */
	@RequestMapping("account")
	public ModelAndView account() {
		return new ModelAndView("account");
	}
}
