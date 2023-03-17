package kr.co.rland.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.web.service.MenuService;

@Controller 
@RequestMapping("/menu")
public class MenuController {

	private MenuService service;
	
	
	@RequestMapping("list")
	public String list(Model model) {
		
//		model.addAttribute("data", "Hello");
		
		//오버라이딩방법
		service.getList();
		service.getList(1);
		service.getList(1, "아");
		service.getList(1, 1/*category*/);
		service.getList(1,1,"아");
		
		
		
		//이거하면 메인만 보이는애가 나와!
		return "menu/list";
	}

	@RequestMapping("detail")
	public String detail() {
		return "menu/detail";
	}
	
}
