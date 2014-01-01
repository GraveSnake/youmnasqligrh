package ma.ensao.youmna.controller.rest;

import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.service.CollaborateurService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RestCollaborateur {
	
CollaborateurService colServ;

//	@Secured("")
	@RequestMapping("/rest/createCollaborator")
	public void createCollaborateur(@RequestBody Collaborateur col){
		colServ.createCollaborateur(col);
	}

}
