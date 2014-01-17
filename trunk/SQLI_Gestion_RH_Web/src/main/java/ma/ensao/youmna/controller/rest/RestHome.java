package ma.ensao.youmna.controller.rest;

import ma.ensao.youmna.service.HomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RestHome {
	
	@Autowired
	HomeService homeService;
	
	@RequestMapping(value = "/rest/count", method = RequestMethod.GET)
	public @ResponseBody Integer getCount(@RequestParam(value="mode", required=true) String mode){
		if("ALL".equals(mode)){
			return homeService.CountAllCollabs();
		}else if("MAN".equals(mode)){
			return homeService.CountAllManagers();
		}else
			return homeService.CountManagedCollabs(mode);
	}

}
