package kr.co.rland.web.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.web.entity.MenuView;

@RestController("apiMenuController")
public class MenuController {
	
	//rest 가 아니면 문서에 대한 url이 돼
	//사용자에게 갈 데이터 구조야!
	//사용자는 restConroller 에 요청하면 사용자가 받는건 데이터
	
	//나중에 메소드가 아니라 공통분모에 몰아주자!
	@GetMapping("/menus") 
	public String getList(){
		return "menu List";
		
	};
	
	@GetMapping("/menus/3") 
	public String get(int id){
		return "menu 3";
		
	};
	
	@PutMapping("/menus/3") 
	public String edit(){
		return "menu edit";
	};
	
	@GetMapping("/menus/3") 
	public String delete(int id){
		return "menu del";
		
	};
	
	@PostMapping("/menus") 
	public String insert(){
		return "menu insert";
		
	};
	
}
