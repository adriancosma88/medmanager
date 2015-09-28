package controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import data.repository.UserRepository;
import domain.security.User;

@Controller
public class LoginController {	
	private final UserRepository userRepo;
	@Autowired
	public LoginController (UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@RequestParam String userName,
			@RequestParam String password,
			Model model) {
		User user = userRepo.findByUserName(userName).get(0);
		
		if (password.equalsIgnoreCase(user.getPassword())) {
			model.addAttribute("name", userName);
			return "mainPage";
		} else {
			model.addAttribute("error", "invalid login!");
			return "login";
		}		
	}
}
