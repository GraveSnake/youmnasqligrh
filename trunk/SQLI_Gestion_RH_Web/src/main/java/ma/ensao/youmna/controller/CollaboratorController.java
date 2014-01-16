package ma.ensao.youmna.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.Plot;
import com.googlecode.charts4j.Plots;

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
	 * Redirecting to form : newCollab
	 */
	// Redirecting to form newCollab
	@RequestMapping(value = "newColaborateur", method = RequestMethod.GET)
	public ModelAndView newcollaborators() {
		ModelAndView mav = new ModelAndView("collaborators");
		List<String> managers = collaborateurService
				.getAllCollaborateurs("Manager");
		List<String> technologies=technologieService.technologies();
		mav.addObject("technologies", technologies);
		mav.addObject("managers", managers);
		mav.addObject("newCollab", new Collaborateur());
		mav.addObject("VIEW", "new");
		return mav;
	}

	/*
	 * Save New Collaborator
	 */
	@RequestMapping(value = "collaborators", method = RequestMethod.POST)
	public ModelAndView saveCollaborator(
			@ModelAttribute("newCollab") Collaborateur collaborateur) {

		// saving a new account
		Compte compte = collaborateur.getCompte();
		collaborateur.setRole("Collaborateur");
		if (compte != null) {
				compte.setActive(false);
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
	 * Redirecting to Form : Edit Collaborator
	 */
	@RequestMapping(value = "updateCollab", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("COLLAB_ID") String COLLAB_ID) {
		ModelAndView mav = new ModelAndView("collaborators");
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
		List<String> managers = collaborateurService
				.getAllCollaborateurs("Manager");
		mav.addObject("managers", managers);
		mav.addObject("editCollab", collaborateur);
		mav.addObject("technologiesSize", technologies.size());
		mav.addObject("diplomesSize", diplomes.size());
		mav.addObject("VIEW", "edit");
		return mav;
	}

	/*
	 * Updating collaborator
	 */
	@RequestMapping(value = "updateCollab", method = RequestMethod.POST)
	public ModelAndView update(
			@ModelAttribute("editCollab") Collaborateur collaborateur) {
		ModelAndView mav = new ModelAndView("redirect:/collaborators");
		Compte compte = collaborateur.getCompte();
		compte.setActive(false);
		compteService.updateCompte(compte);
		// Updating collaborator
		collaborateurService.updateCollaborateur(collaborateur);
		// Archive Requirement Verification
		if (collaborateurService.requireArchive(collaborateur)) {
			archiveService.saveCollab(collaborateur);
		}
		// updating all diplomes related to this collaborator
		List<Diplome> diplomes = collaborateur.getDIPLOME();
		Diplome dip = null;
		if (diplomes != null) {
			for (Diplome diplome : diplomes) {
				dip = diplome;
				dip.setCollaborateur(collaborateur);
				diplomeService.updateDiplome(dip);
			}
		}

		// updating all technologies related to this collaborator
		List<Technologie> technologies = collaborateur.getTECHNOLOGIE();
		Technologie tech = null;
		if (technologies != null) {
			for (Technologie technologie : technologies) {
				tech = technologie;
				tech.setCollaborateur(collaborateur);
				technologieService.updateTechnologie(tech);

				
				// updating all competences related to this technology
				List<Competence> competences = collaborateur.getCOMPETENCE();
				Competence comp = null;
				if (competences != null) {
					for (Competence competence : competences) {
						comp = competence;
//						comp.setTechnologie(tech);
//						competenceService.updateCompetence(comp);
					}
				}

			}

		}
		mav.addObject("VIEW", "show");
		return mav;
	}

	/*
	 * View a Collaborator
	 */
	@RequestMapping(value = "viewCollab", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("COLLAB_ID") String COLLAB_ID) {
		ModelAndView mav = new ModelAndView("collaborators");
		Collaborateur collaborateur = collaborateurService
				.getCollaborateurById(COLLAB_ID);
		List<Diplome> diplomes = diplomeService.getAll(COLLAB_ID);
		List<Technologie> technologies = technologieService.getAll(COLLAB_ID);
		List<Competence> competences = new ArrayList<Competence>();
		for (Technologie tech : technologies) {
			competences.addAll(competenceService.getAll(tech.getId()));
		}
		mav.addObject("technologiesSize", technologies.size());
		mav.addObject("diplomesSize", diplomes.size());
		mav.addObject("DIPLOME", diplomes);
		mav.addObject("COMPETENCE", competences);
		mav.addObject("TECHNOLOGIE", technologies);
		mav.addObject("viewCollab", collaborateur);
		mav.addObject("VIEW", "view");
		
		// Salaire reporting
		List<Double> salaire= new ArrayList<Double>();
		salaire.add((double) 0);
		List<String> date=new ArrayList<String>();
		date.add("0");
		Map<String, String> map=collaborateurService.getSalaireByYear(COLLAB_ID);
		Set set = map.entrySet();
	      Iterator i = set.iterator();
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         salaire.add(Double.valueOf((String) me.getValue())/100);
	         date.add(String.valueOf(me.getKey()).substring(0, 10));   
	      }
	      
        Plot plot = Plots.newPlot(Data.newData(salaire));
        LineChart chart = GCharts.newLineChart(plot);
        chart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, 10000));
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels(date));
        chart.setSize(500, 300);
        AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.BLACK, 13, AxisTextAlignment.CENTER);
        AxisLabels score = AxisLabelsFactory.newAxisLabels("Salaire (Dh)", 50.0);
        score.setAxisStyle(axisStyle);
        AxisLabels year = AxisLabelsFactory.newAxisLabels("Année", 50.0);
        year.setAxisStyle(axisStyle);
        chart.addYAxisLabels(score);
        chart.addXAxisLabels(year);
        mav.addObject("chartSalaireUrl", chart.toURLString());
        mav.addObject("map", map);
        
        
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
