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
import ma.ensao.youmna.service.TechnologieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdministrationController {
	
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
	
	
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		ModelAndView mav=new ModelAndView("ExportExcel");
		List<Collaborateur> collabList = collaborateurService.getAllCollaborateurs();
		List<Competence> competList= competenceService.getAll() ;
		List<Compte> compteList= compteService.getAll() ;
		List<Technologie> techList= technologieService.getAll() ;
		List<Diplome> dipList= diplomeService.getAll() ;
		
		mav.addObject("collabList",collabList);
		mav.addObject("competList",competList);
		mav.addObject("compteList",compteList);
		mav.addObject("techList",techList);
		mav.addObject("dipList",dipList);
		return mav;
	}

}
