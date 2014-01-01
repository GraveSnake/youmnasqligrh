package ma.ensao.youmna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	private String main;

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	@RequestMapping("/main")
	public ModelAndView main(){
		return new ModelAndView(main);
	}

	@RequestMapping("/adminManagers")
	public ModelAndView managers(){
		return new ModelAndView("admin_managers");
	}
	@RequestMapping("/collaborators")
	public ModelAndView collaborators(){
		return new ModelAndView("collaborators");
	}
	
	@RequestMapping("/reporting")
	public ModelAndView reporting(){
		return new ModelAndView("reporting");
	}
	
	@RequestMapping("/administration")
	public ModelAndView administration(){
		return new ModelAndView("administration");
	}
	
	@RequestMapping("/account")
	public ModelAndView account(){
		return new ModelAndView("account");
	}
}
