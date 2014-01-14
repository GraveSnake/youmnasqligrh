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
public class CollaboratorController {

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

	/**
	 * @param welcome
	 *            the welcome to set
	 */
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	
	/*
	 *  Redirecting to form : newCollab
	 */
	//Redirecting to form newCollab
	@RequestMapping(value = "newColaborateur", method = RequestMethod.GET)
	public ModelAndView newcollaborators() {
		  ModelAndView mav = new ModelAndView("collaborators");
		  List<String> managers=collaborateurService.getAllCollaborateurs("Manager");
		  mav.addObject("managers", managers);
		 mav.addObject("newCollab", new Collaborateur());		  
		  mav.addObject("VIEW", "new");		  
		return mav;
	}

	/*
	 *  Save New Collaborator
	 */
	@RequestMapping(value = "collaborators", method = RequestMethod.POST)
	public ModelAndView saveCollaborator(
			@ModelAttribute("newCollab") Collaborateur collaborateur) {
		
		// saving a new account
		Compte compte = collaborateur.getCompte();
		if (compte != null) {
			if ("Manager".equals(collaborateur.getRole())) {
				compte.setActive(true);
				compte.setAuthorities("ROLE_USER");
			} else if ("Collaborateur".equals(collaborateur.getRole())) {
				compte.setActive(false);
			} else {
				compte.setActive(true);
				compte.setAuthorities("ROLE_ADMIN");				
			}
			compteService.createCompte(compte);
		}
		// saving a new collaborator
		collaborateurService.createCollaborateur(collaborateur);
		
		// saving an archive copy
		archiveService.saveCollab(collaborateur);
		
		// saving all diplomes related to this collaborator
		List<Diplome> diplomes = collaborateur.getDIPLOME();
		Diplome dip = null;
		if (diplomes != null) {
			for (Diplome diplome : diplomes) {
				dip = diplome;
				dip.setCollaborateur(collaborateur);
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
			String to = collaborateur.getCompte().getEmail();
			compteService.sendMessage(to, welcome, welcome);

		}

		return new ModelAndView("redirect:/collaborators");
	}
	

	/*
	 *  Redirecting to Form : Edit Collaborator
	 */
	@RequestMapping(value = "updateCollab", method = RequestMethod.GET)
	 public ModelAndView edit(@RequestParam("COLLAB_ID")String COLLAB_ID) {
		 ModelAndView mav = new ModelAndView("collaborators");  
		  Collaborateur collaborateur = collaborateurService.getCollaborateurById(COLLAB_ID);
		  List<Diplome> diplomes=diplomeService.getAll(COLLAB_ID);
		  List<Technologie> technologies=technologieService.getAll(COLLAB_ID);
		  List<Competence> competences=new ArrayList<Competence>();
		  System.out.println(diplomes.size());
		  System.out.println(technologies.size());
		  for(Technologie tech: technologies){
			  competences.addAll(competenceService.getAll(tech.getId()));
		  }
		  System.out.println(competences.size());
		  collaborateur.setCOMPETENCE(competences);
		  collaborateur.setTECHNOLOGIE(technologies);
		  collaborateur.setDIPLOME(diplomes);
		  List<String> managers=collaborateurService.getAllCollaborateurs("Manager");
		  mav.addObject("managers", managers);
		  mav.addObject("editCollab", collaborateur);
		  mav.addObject("technologiesSize", technologies.size());
		  mav.addObject("diplomesSize", diplomes.size());
		  mav.addObject("VIEW", "edit");		 
		return mav;
	}

	/*
	 *  Updating collaborator
	 */
	@RequestMapping(value = "updateCollab", method = RequestMethod.POST)
	public ModelAndView update(
			@ModelAttribute("editCollab") Collaborateur collaborateur) {
		ModelAndView mav = new ModelAndView("collaborators");
		// Updating collaborator
		collaborateurService.updateCollaborateur(collaborateur);
		// Archive Requirement Verification
		if(collaborateurService.requireArchive(collaborateur)){
			archiveService.saveCollab(collaborateur);
		}
		mav.addObject("VIEW", "view");
		return mav;
	}

	/*
	 *  View a Collaborator
	 */
	@RequestMapping(value = "viewCollab", method = RequestMethod.GET)
	 public ModelAndView view(@RequestParam("COLLAB_ID")String COLLAB_ID) {
		 ModelAndView mav = new ModelAndView("collaborators");  
		  Collaborateur collaborateur = collaborateurService.getCollaborateurById(COLLAB_ID); 
		  List<Diplome> diplomes=diplomeService.getAll(COLLAB_ID);
		  List<Technologie> technologies=technologieService.getAll(COLLAB_ID);
		  List<Competence> competences=new ArrayList<Competence>();
		  for(Technologie tech: technologies){
			  competences.addAll(competenceService.getAll(tech.getId()));
		  }
		  collaborateur.setCOMPETENCE(competences);
		  collaborateur.setTECHNOLOGIE(technologies);
		  collaborateur.setDIPLOME(diplomes);
		  mav.addObject("technologiesSize", technologies.size());
		  mav.addObject("diplomesSize", diplomes.size());
		  mav.addObject("viewCollab", collaborateur);
		  mav.addObject("VIEW", "view");		 
		return mav;
	}

	/*
	 * Delete a Collaborator
	 */
	@RequestMapping(value = "deleteCollab", method = RequestMethod.POST)
	public ModelAndView delete(
			@ModelAttribute("editCollab") Collaborateur collaborateur) {
		return null;
	}
}
