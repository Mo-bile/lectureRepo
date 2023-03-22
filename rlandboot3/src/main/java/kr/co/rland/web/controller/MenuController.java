package kr.co.rland.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.entity.RcmdMenuView;
import kr.co.rland.web.service.CategoryService;
import kr.co.rland.web.service.MenuService;
import kr.co.rland.web.service.RcmdMenuService;
import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;

@Controller 
@RequestMapping("/menu")
public class MenuController {

	
	@Autowired
	private MenuService service; // 메뉴가 주인인 곳에서의 service
	
	@Autowired
	private CategoryService categoryservice;
	//다른 곳에서의 주인은... 이름 더 붙이기!
	
	@Autowired
	private RcmdMenuService rcmdMenuService;
	
	
	@RequestMapping("list")
	public String list(
			//안받을 때 디폴트값용
			@RequestParam(name = "p", defaultValue = "1") int page,
			//null일수 있어서 기본값은 안넣어
			//그리고 이 경우를 대비하기 위해서 Integer로 넣어
			@RequestParam(name = "c" ,required = false) Integer categoryId,
			@RequestParam(name = "q",required = false) String query,
			Model model) {
		
		List<Category> categoryList = categoryservice.getList();
		
		//여기에 맞추기 위해서 1이 아니라 3가지 값을 넣어서 보내준다
//		List<MenuView> list = service.getViewList(1);
		List<MenuView> list = service.getViewList(page, categoryId, query);
		
//		model.addAttribute("data", "Hello");
//		System.out.println("result"+ categoryList);
		
		model.addAttribute("categoryList",categoryList);
		
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
	public String detail(
			long id, Model model) {
		
		Menu menu = service.getById(id);
		List<RcmdMenuView> rcmdMenuServices = rcmdMenuService.getViewListMenuId((int) id);
		
		model.addAttribute("menu", menu);
		model.addAttribute("rcmdMenuServices",rcmdMenuServices);
		
		return "menu/detail";
	}
	
}
