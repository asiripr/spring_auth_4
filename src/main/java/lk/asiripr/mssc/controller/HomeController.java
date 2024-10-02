package lk.asiripr.mssc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "hello this is home";
	}

	@GetMapping("/private")
	public String secured() {
		return "you have successfully accessed into secured content";
	}
}
