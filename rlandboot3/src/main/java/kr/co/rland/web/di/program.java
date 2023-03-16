package kr.co.rland.web.di;

import java.util.Date;
import java.util.List;

import kr.co.rland.web.di.Config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.qos.logback.core.pattern.parser.Parser;
import kr.co.rland.web.entity.JSONParser;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.repository.MenuRepository;
import kr.co.rland.web.service.MenuService;

public class program {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
//		ApplicationContext context 
//			= new ClassPathXmlApplicationContext("kr/co/rland/web/di/context.xml");
//		
		ApplicationContext context 
			= new AnnotationConfigApplicationContext(Config.class);
		String hello = (String) context.getBean("hello");
		System.out.println(hello);
		
		
		//XML 기반의 DI ============================
		
//		
////		MenuRepository menuRepository = context.getBean(MenuRepository.class);
////		List<Menu> list = menuRepository.findAll();
//		
//		//인터페이스 만 가져오고, 구현체를 context.xml 에서 들고 
////		MenuService service = context.getBean(MenuService.class);
//		MenuService service = (MenuService) context.getBean("service");
//		List<Menu> list = service.getList();
//	
//		
//		System.out.println(list);
		
		//----------------------------
		
//		Menu menu = new Menu();
//		menu.setId(1);
//		menu.setName("아메리카노");
//		menu.setPrice(3000);
////		menu.setRegDate(new Date("2023-03-02"));
//		
//		
//		JSONParser parser = new JSONParser (menu);
//		String json = parser.toJSON();
//		
//		//{"id":1 , "name":"아메리카노", ...}
//		System.out.println(json);
	}

}
