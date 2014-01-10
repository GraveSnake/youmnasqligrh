package ma.ensao.youmna.controller;

import ma.ensao.youmna.service.AccountService;
import ma.ensao.youmna.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
		
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/rest/login",method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody User login(@RequestBody User userDto){
		try {
			System.out.println("Receiving Request....");
			System.out.println("infos : "+userDto.getUsername()+" "+userDto.getPassword());
			User result = accountService.loginAccount(userDto);
			System.out.println("After Logging : returning result.");
			return result;
		} catch (Exception e) {
			return null;
		}
		
	}
	
//	@RequestMapping(value="/account/activate/{hash}")
//	public String activate(@PathVariable String hash,Model model){
//		try {
//			logger.info(hash);
//			accountService.activateAccount(hash);
//			return "home";
//		} catch (Exception e) {
//			model.addAttribute("error", e.getMessage());
//			return "home";
//		} 
//	}

}
