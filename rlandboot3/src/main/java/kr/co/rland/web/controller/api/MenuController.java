package kr.co.rland.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.service.MenuService;

@RestController("apiMenuController")
@RequestMapping("menus")
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	//rest 가 아니면 문서에 대한 url이 돼
	//사용자에게 갈 데이터 구조야!
	//사용자는 restConroller 에 요청하면 사용자가 받는건 데이터
	
	//나중에 메소드가 아니라 공통분모에 몰아주자!
	@GetMapping
	public List<MenuView> getList(
				@RequestParam(name = "p", defaultValue = "1") int page, 
				@RequestParam(name = "c", required = false)	Integer categoryId, 
				@RequestParam(name = "q", required = false)  String query		) {
		
//		List <Menu> list = service.getList();
		List <MenuView> list = service.getViewList(page, categoryId, query);
		
//		try {
//		Thread.sleep(10000);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		return "menu List";
		return list ;
		
	};
	
	@GetMapping("{id}") 
	public Menu get(
			@PathVariable("id") int id){
		
		Menu menu = service.getById(id);
		
		
//		return "menu " + id;
		return menu;
		//객체를 못전달해 이를 다 표현하기 위해 문자열로 바꾸거나,바꾸는 표현식을 써야해!
		//요새 트렌드는 JSON과 XML을 써야
		
	};
	
	@PutMapping
	public String edit(
			@PathVariable("id") int id){
		return "menu edit:" + id ;
	};
	
	@DeleteMapping("{id}")
	public String delete(
		@PathVariable("id") int id){
			return "menu del:" + id ;
		};
		
	@PostMapping
	public String insert() {
		return "menu insert";
		
	};
	
}
