package kr.co.rland.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller 
@RequestMapping("/menu")
public class MenuController {

	@RequestMapping("list")
	public String list(Model model) {
		
		model.addAttribute("data", "Hello");
		
		//이거하면 메인만 보이는애가 나와!
		return "menu/list";
	}

	@RequestMapping("detail")
	public String detail() {
		return "menu detail";
	}
	
}
