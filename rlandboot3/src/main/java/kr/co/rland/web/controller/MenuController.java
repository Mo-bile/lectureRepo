package kr.co.rland.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.service.MenuService;
import kr.co.rland.web.entity.Menu;


@Controller 
@RequestMapping("/menu")
public class MenuController {

	
	@Autowired
	private MenuService service;
	
	
	@RequestMapping("list")
	public String list(Model model) {
		
//		model.addAttribute("data", "Hello");
		
		List<MenuView> list = service.getViewList(1);
		model.addAttribute("list",list);
		
		//오버라이딩방법
//		service.getList();
//		service.getList(1);
//		service.getList(1, "아");
//		service.getList(1, 1/*category*/);
//		service.getList(1,1,"아");
		
		//이거하면 메인만 보이는애가 나와!
		return "menu/list";
	}

	@RequestMapping("detail")	//주소와 같게 해주면
	public String detail(long id, Model model) {
		
		Menu menu = service.getById(id);
		
		model.addAttribute("menu", menu);
		
		return "menu/detail";
	}
	
}
