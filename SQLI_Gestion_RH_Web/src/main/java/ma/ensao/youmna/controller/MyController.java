package ma.ensao.youmna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {
	private String main;

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}


//	String message = "NAJAH Mustapha\nOUAFTOUH Yasser";
//	@RequestMapping("/showMessage")
//	public ModelAndView displayMessage(){
//		return new ModelAndView("showMessage","message",message);
//	}

	@RequestMapping("/main")
	public ModelAndView login(){
		return new ModelAndView("main");
	}
//	  @RequestMapping("/main") 
//	  public String setUp(Model model){ 
//	    return "main"; 
//	  } 

}
