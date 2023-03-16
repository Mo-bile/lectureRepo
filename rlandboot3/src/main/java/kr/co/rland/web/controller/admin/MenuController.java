package kr.co.rland.web.controller.admin;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import kr.co.rland.web.repository.MenuRepository;
import kr.co.rland.web.service.MenuService;

@Controller("adminMenuController")
@RequestMapping("/admin/menu/")
public class MenuController {
	
	@Autowired
	//콩자루 가져 올 준비 => 결합! 을 의미 해
	
	// 구현체를 쓰면안돼 결합력이 강해지기 때문이야!
//	private MenuRepository menuRepository;
	private MenuService service;
	
	
//	public MenuController() {
//		// TODO Auto-generated constructor stub
//	}
//	
//
//	public MenuController(MenuRepository menuRepository) {
//			super();
//			this.menuRepository = menuRepository;
//		}
//
//
//	//	------
//	// 호환되는 녀석을 찾아 스프링이! 있으면 여기다가 인젝션(세팅)해줘!
//	//=> 그러면 멤버가 null 이 아니게 돼
//	// 이거를 DI 라고 한다. 그러면 나는 이제 컨트롤러 이전처럼 시작해주면 돼
//	
//	
//	@Autowired
//	public void setMenuRepository(MenuRepository menuRepository) {
//		
//		System.out.println("Setting 전에 해야 할 일 ");
//		this.menuRepository = menuRepository;
//		System.out.println("Setting 후에 해야 할 일 ");
//	}


	@GetMapping("list")
	public String list(
			@RequestParam(name ="p", defaultValue = "1") int page,
			@RequestParam(name = "q", required = false) String query,
			@CookieValue("my") String myCookie,
			@RequestHeader("Accept-Language") String language
//			HttpServletRequest request
			) throws UnsupportedEncodingException {
			System.out.println(page + " "+query);
			
			System.out.printf("Landuage : %s \n",language);
			
//			String myCookie = "";
//			Cookie[] cookies = request.getCookies();
//			
//			for(Cookie cookie : cookies)
//				if(cookie.getName().equals("my")) {
//					myCookie = cookie.getValue();
//					break;
//				}
			
			myCookie = URLDecoder.decode(myCookie, "utf-8");
			
			System.out.println(service.getList());
			
			System.out.println(myCookie);
			System.out.printf("page :%d, query:%s\n", page,query);
			
			
			return "/WEB-INF/view/admin/menu/list.jsp";
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
