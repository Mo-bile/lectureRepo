package kr.co.rland.web.controller.admin;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.repository.MenuRepository;
import kr.co.rland.web.service.MenuService;

@Controller("adminMenuController")
@RequestMapping("/admin/menu/")
public class MenuController {
	
	@Autowired
	private MenuService service;

	@GetMapping("list")
	public String list(
			@RequestParam(name ="p", defaultValue = "1") int page,
			@RequestParam(name = "c", required = false) Integer categoryId,
			@RequestParam(name = "q", required = false) String query,
			@RequestHeader("Accept-Language") String language,
			Model model
			) throws UnsupportedEncodingException {
			
		List <MenuView> list = service.getViewList(page, categoryId, query);;
		model.addAttribute("list",list);
		
		return "admin/menu/list";
	}

	@GetMapping("detail")
	public String detail() {
		return "admin menu detail";
	}
	
	
//	@RequestMapping("reg")

	@GetMapping("reg")
	//등록 폼을 주세요
	public String reg() {
		return "/WEB-INF/view/admin/menu/reg.jsp";
	}
	
//	@RequestMapping("reg")
	@PostMapping("reg")
	// 폼입력해서 제출이요 
	public String reg(String title) {
		//등록 후
		
		System.out.println("메뉴 등록 완료");
		return "redirect:list";
	}
	
	
	
}
