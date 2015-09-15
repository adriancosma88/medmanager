package controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import domain.User;
import repository.UserRepository;

@Controller
public class MainController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/hello")
	public String mainPage(@RequestParam("name") String name, Model model) {
		User user = new User();
		user.setUserName("cosma");
		user.setPassword("a");
		userRepo.save(user);
		
		User user2 = new User();
		user.setUserName("adrian");
		user.setPassword("a");
		userRepo.save(user2);
		
		User user3 = new User();
		user.setUserName("laurentiu");
		user.setPassword("a");
		userRepo.save(user3);
		
		model.addAttribute("name", userRepo.findByUserName(name));
		return "mainPage";
	}
}
