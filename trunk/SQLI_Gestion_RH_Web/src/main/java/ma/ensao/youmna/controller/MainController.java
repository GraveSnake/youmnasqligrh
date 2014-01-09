package ma.ensao.youmna.controller;

import java.util.List;

import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.model.Competence;
import ma.ensao.youmna.model.Compte;
import ma.ensao.youmna.model.Diplome;
import ma.ensao.youmna.model.Technologie;
import ma.ensao.youmna.service.CollaborateurService;
import ma.ensao.youmna.service.CompetenceService;
import ma.ensao.youmna.service.CompteService;
import ma.ensao.youmna.service.DiplomeService;
import ma.ensao.youmna.service.SecurityContextAccessor;
import ma.ensao.youmna.service.TechnologieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	private DiplomeService diplomeService;

	@Autowired
	private TechnologieService technologieService;

	@Autowired
	private CompetenceService competenceService;
	
	@Autowired
	private CompteService compteService;

	private String main;

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	@RequestMapping("index")
	public ModelAndView main() {
		return new ModelAndView(main);
	}

	@RequestMapping(value = { "/", "login" })
	public ModelAndView root() {
		if (securityContextAccessor.isCurrentAuthenticationAnonymous()) {
			return new ModelAndView("login");
		} else {
			return new ModelAndView("redirect:" + main);
		}
	}

	@RequestMapping("adminManagers")
	public ModelAndView managers() {
		return new ModelAndView("admin_managers");
	}

	@RequestMapping(value = "collaborators", method = RequestMethod.GET)
	public ModelAndView collaborators() {
		ModelAndView mav = new ModelAndView("collaborators","command",new Collaborateur());
//		Collaborateur Collaborateur = new Collaborateur();
//		mav.getModelMap().put("newCollaborateur", Collaborateur);
		return mav;
	}

	@RequestMapping(value = "collaborators", method = RequestMethod.POST)
	public ModelAndView newCollaborator(@ModelAttribute() Collaborateur collaborateur) {
		System.out.println(collaborateur.getNom());
		// saving a new account
		//Compte compte=collaborateur.getCompte();
		//compteService.createCompte(compte);
		
		// saving a new collaborator
		collaborateurService.createCollaborateur(collaborateur);
		
		// saving all diplomes related to this collaborator
		List<Diplome> diplomes = collaborateur.getDIPLOME();
		Diplome dip = null;
		if (diplomes != null) {
			for (Diplome diplome : diplomes) {
				dip = diplome;
				diplomeService.saveDiplome(dip);
			}
		}
		
		// saving all technologies related to this collaborator
		List<Technologie> technologies = collaborateur.getTECHNOLOGIE();
		Technologie tech = null;
		if (technologies != null) {
			for (Technologie technologie : technologies) {
				tech = technologie;
				tech.setCollaborateur(collaborateur);
				technologieService.saveTechnologie(tech);
				// saving all competences related to this technology
				List<Competence> competences = collaborateur.getCOMPETENCE();
				Competence comp = null;
				if (competences != null) {
					for (Competence competence : competences) {
						comp = competence;
						comp.setTechnologie(tech);
						competenceService.saveCompetence(comp);
					}
				}

			}

		}

		return new ModelAndView("collaborators");
	}

	@RequestMapping("reporting")
	public ModelAndView reporting() {
		return new ModelAndView("reporting");
	}

	@RequestMapping("administration")
	public ModelAndView administration() {
		return new ModelAndView("administration");
	}

	@RequestMapping("account")
	public ModelAndView account() {
		return new ModelAndView("account");
	}
}
