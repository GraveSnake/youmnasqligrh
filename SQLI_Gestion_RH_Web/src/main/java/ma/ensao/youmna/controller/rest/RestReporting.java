package ma.ensao.youmna.controller.rest;

import ma.ensao.youmna.service.CollaborateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RestReporting {
	
	@Autowired
	CollaborateurService collaborateurService;
	
	@RequestMapping(value = "/rest/ratio", method = RequestMethod.GET)
	public @ResponseBody Integer getRatio(@RequestParam(value="gender", required=true) String gender){
		if("F".equals(gender)){
			return collaborateurService.getAllCollaborateurs('F');
		}else if("M".equals(gender)){
			return collaborateurService.getAllCollaborateurs('M');
		}
	return 0;
	}
}
