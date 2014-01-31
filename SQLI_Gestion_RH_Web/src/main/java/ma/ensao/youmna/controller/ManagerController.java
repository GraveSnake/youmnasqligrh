package ma.ensao.youmna.controller;

import java.util.ArrayList;
import java.util.List;

import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.model.Competence;
import ma.ensao.youmna.model.Compte;
import ma.ensao.youmna.model.Diplome;
import ma.ensao.youmna.model.Technologie;
import ma.ensao.youmna.service.ArchiveService;
import ma.ensao.youmna.service.CollaborateurService;
import ma.ensao.youmna.service.CompetenceService;
import ma.ensao.youmna.service.CompteService;
import ma.ensao.youmna.service.DiplomeService;
import ma.ensao.youmna.service.TechnologieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerController {

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

	@Autowired
	private ArchiveService archiveService;

	private String welcome;

	/*
	 * Redirecting to form : newManager
	 */
	// Redirecting to form newManager

	/**
	 * @param welcome
	 *            the welcome to set
	 */
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	@RequestMapping(value = "newManager", method = RequestMethod.GET)
	public ModelAndView newManager() {
		ModelAndView mav = new ModelAndView("admin_managers");
		List<String> technologies=technologieService.technologies();
		mav.addObject("technologies", technologies);
		mav.addObject("newManager", new Collaborateur());
		mav.addObject("VIEW", "new");
		return mav;
	}

	/*
	 * Save New Manager
	 */
	@RequestMapping(value = "newManager", method = RequestMethod.POST)
	public ModelAndView saveManager(
			@ModelAttribute("newManager") Collaborateur manager) {

		// saving a new account
		Compte compte = manager.getCompte();
		manager.setRole("Manager");
		if (compte != null) {
			compte.setActive(true);
			compte.setAuthorities("ROLE_USER");
			compteService.createCompte(compte);
		}
		// saving a new Manager
		manager.setMgrhActuel("");
		manager.setMgrhAncien("");
		collaborateurService.createCollaborateur(manager);

		// saving an archive copy
		archiveService.saveCollab(manager);

		// saving all diplomes related to this collaborator
		List<Diplome> diplomes = manager.getDIPLOME();
		Diplome dip = null;
		if (diplomes != null) {
			for (Diplome diplome : diplomes) {
				dip = diplome;
				dip.setCollaborateur(manager);
				diplomeService.saveDiplome(dip);
			}
		}

		// saving all technologies related to this collaborator
		List<Technologie> technologies = manager.getTECHNOLOGIE();
		Technologie tech = null;
		if (technologies != null) {
			for (Technologie technologie : technologies) {
				tech = technologie;
				tech.setCollaborateur(manager);
				technologieService.saveTechnologie(tech);

				// saving all competences related to this technology
				List<Competence> competences = manager.getCOMPETENCE();
				Competence comp = null;
				if (competences != null) {
					for (Competence competence : competences) {
						comp = competence;
						comp.setTechnologie(tech);
						competenceService.saveCompetence(comp);
					}
				}

			}
			String to = manager.getCompte().getEmail();
			compteService.sendMessage(to, welcome, welcome);

		}

		return new ModelAndView("redirect:/admin_managers");
	}

	/*
	 * Redirecting to Form : Edit Collaborator
	 */
	@RequestMapping(value = "updateManager", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("MANAGER_ID") String COLLAB_ID) {
		ModelAndView mav = new ModelAndView("admin_managers");
		Collaborateur collaborateur = collaborateurService
				.getCollaborateurById(COLLAB_ID);
		List<Diplome> diplomes = diplomeService.getAll(COLLAB_ID);
		List<Technologie> technologies = technologieService.getAll(COLLAB_ID);
		List<Competence> competences = new ArrayList<Competence>();
		for (Technologie tech : technologies) {
			competences.addAll(competenceService.getAll(tech.getId()));
		}
		collaborateur.setCOMPETENCE(competences);
		collaborateur.setTECHNOLOGIE(technologies);
		collaborateur.setDIPLOME(diplomes);
		mav.addObject("editManager", collaborateur);
		mav.addObject("technologiesSize", technologies.size());
		mav.addObject("diplomesSize", diplomes.size());
		mav.addObject("VIEW", "edit");
		return mav;
	}

	/*
	 * Updating Manager
	 */

	@RequestMapping(value = "updateManager", method = RequestMethod.POST)
	public ModelAndView update(
			@ModelAttribute("editManager") Collaborateur manager) {

		// saving a new account
		Compte compte = manager.getCompte();
		compteService.updateCompte(compte);
		// updating the new Manager
		collaborateurService.updateCollaborateur(manager);

		// saving an archive copy
		if (collaborateurService.requireArchive(manager)) {
			archiveService.saveCollab(manager);
		}

		// updating all diplomes related to this collaborator
		List<Diplome> diplomes = manager.getDIPLOME();
		Diplome dip = null;
		if (diplomes != null) {
			for (Diplome diplome : diplomes) {
				dip = diplome;
				dip.setCollaborateur(manager);
				diplomeService.updateDiplome(dip);
			}
		}

		// updating all technologies related to this collaborator
		List<Technologie> technologies = manager.getTECHNOLOGIE();
		Technologie tech = null;
		if (technologies != null) {
			for (Technologie technologie : technologies) {
				tech = technologie;
				tech.setCollaborateur(manager);
				technologieService.updateTechnologie(tech);

				// updating all competences related to this technology
				List<Competence> competences = manager.getCOMPETENCE();
				Competence comp = null;
				if (competences != null) {
					for (Competence competence : competences) {
						comp = competence;
						comp.setTechnologie(tech);
						competenceService.updateCompetence(comp);
					}
				}

			}

		}
		return new ModelAndView("redirect:/adminManagers");
	}

	/*
	 * View a Manager
	 */
	@RequestMapping(value = "viewManager", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("MANAGER_ID") String COLLAB_ID) {
		ModelAndView mav = new ModelAndView("admin_managers");
		Collaborateur collaborateur = collaborateurService
				.getCollaborateurById(COLLAB_ID);
		List<Diplome> diplomes = diplomeService.getAll(COLLAB_ID);
		List<Technologie> technologies = technologieService.getAll(COLLAB_ID);
		List<Competence> competences = new ArrayList<Competence>();
		for (Technologie tech : technologies) {
			competences.addAll(competenceService.getAll(tech.getId()));
		}
//		collaborateur.setCOMPETENCE(competences);
//		collaborateur.setTECHNOLOGIE(technologies);
//		collaborateur.setDIPLOME(diplomes);
		mav.addObject("technologiesSize", technologies.size());
		mav.addObject("diplomesSize", diplomes.size());
		mav.addObject("DIPLOME", diplomes);
		mav.addObject("COMPETENCE", competences);
		mav.addObject("TECHNOLOGIE", technologies);
		mav.addObject("viewCollab", collaborateur);
		mav.addObject("VIEW", "view");
		return mav;
	}
	
	@RequestMapping(value = "desactivateManager", method = RequestMethod.GET)
	public ModelAndView desactivateManager(@RequestParam("MANAGER_ID") String COLLAB_ID) {
		Collaborateur coll=collaborateurService.getCollaborateurById(COLLAB_ID);
		System.out.println(coll.getNom());
		Compte compte=coll.getCompte();
		compte.setActive(false);
		compteService.updateCompte(compte);
		ModelAndView mav = new ModelAndView("redirect:/adminManagers");
		return mav;
	}
	
	@RequestMapping(value = "activateManager", method = RequestMethod.GET)
	public ModelAndView activateManager(@RequestParam("MANAGER_ID") String COLLAB_ID) {
		Collaborateur coll=collaborateurService.getCollaborateurById(COLLAB_ID);
		System.out.println(coll.getNom());
		Compte compte=coll.getCompte();
		compte.setActive(true);
		compteService.updateCompte(compte);
		ModelAndView mav = new ModelAndView("redirect:/adminManagers");
		return mav;
	}
}
