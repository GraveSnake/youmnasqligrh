package ma.ensao.youmna.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	private String welcome;
	

	/**
	 * @param welcome the welcome to set
	 */
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

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

	//Show all collaborators
	@RequestMapping(value = "collaborators", method = RequestMethod.GET)
	public ModelAndView collaborators() {
		ModelAndView mav = new ModelAndView("collaborators");  
		  List<Collaborateur> collaborateur = collaborateurService.getAllCollaborateurs(); 
		  mav.addObject("ListCollab", collaborateur);
		  mav.addObject("VIEW", "show");
		   DateFormat dateFormat = new SimpleDateFormat("yyyy");
		   //get current date time with Date()
		   Date date = new Date();
		   System.out.println(dateFormat.format(date));
		return mav;
	}
	
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
	
	//Update collab & redirecting to show all collab
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
	
	 //Update collab
	 @RequestMapping(value="updateCollab", method=RequestMethod.POST)  
	 public ModelAndView update(@ModelAttribute("editCollab") Collaborateur collaborateur)  
	 {  
	ModelAndView mav = new ModelAndView("collaborators");
	  collaborateurService.updateCollaborateur(collaborateur); 
	  mav.addObject("VIEW","view");
	  return mav;  
	 } 
	 
	 //view collab
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
		
		 
		 @RequestMapping(value="deleteCollab", method=RequestMethod.POST)  
		 public ModelAndView delete(@ModelAttribute("editCollab") Collaborateur collaborateur)  
		 {  
		  return null;  
		 } 

	@RequestMapping(value = "collaborators", method = RequestMethod.POST)
	public ModelAndView saveCollaborator(@ModelAttribute("newCollab") Collaborateur collaborateur) {
		System.out.println(collaborateur.getNom());
		// saving a new account
		Compte compte=collaborateur.getCompte();
		if(compte!=null){
			if("Manager".equals(collaborateur.getRole())){
				compte.setActive(true);
				compte.setAuthorities("ROLE_USER");
			}else if("Ambassadeur".equals(collaborateur.getRole())){
				compte.setActive(true);
				compte.setAuthorities("ROLE_ADMIN");
			}else{
				compte.setActive(false);
			}
			compteService.createCompte(compte);
		}
		// saving a new collaborator
		collaborateurService.createCollaborateur(collaborateur);
		
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
				String to=collaborateur.getCompte().getEmail();
				compteService.sendMessage(to, welcome, welcome);

	}

		return new ModelAndView("redirect:/collaborators");
	}

//	@RequestMapping("reporting")
//	public ModelAndView reporting() {
//		return new ModelAndView("reporting");
//	}

	@RequestMapping("administration")
	public ModelAndView administration() {
		return new ModelAndView("administration");
	}

	@RequestMapping("account")
	public ModelAndView account() {
		return new ModelAndView("account");
	}
	
	
}
