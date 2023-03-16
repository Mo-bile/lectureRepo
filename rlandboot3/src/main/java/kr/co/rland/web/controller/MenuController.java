package kr.co.rland.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller 
@RequestMapping("/menu")
public class MenuController {

	@RequestMapping("list")
	public String list() {
		
		return "menulist";
//		return "/WEB-INF/view/inc/layout.jsp";
	}

	@RequestMapping("detail")
	public String detail() {
		return "menu detail";
	}
	
}
