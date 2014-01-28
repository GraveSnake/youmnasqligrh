package ma.ensao.youmna.controller.rest;

import java.util.List;

import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.service.CollaborateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RestCollaborateur {
	
	@Autowired
	private CollaborateurService collaborateurService;
	
	@RequestMapping(value = "/rest/collaborators", method = RequestMethod.GET)
	public @ResponseBody List<Collaborateur> getCount(@RequestParam(value="mode", required=true) String mode){
		if("ALL".equals(mode)){
			return collaborateurService.getAllCollaborateurs();
		}else
			return collaborateurService.getAllCollaborateursByManager(mode);
	}

}
