package kr.co.rland.web.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.rland.web.repository.jdbc.jdbcMenuRepository;

//스프링이 제공하는 객체 생성 어노테이션
// 이 다섯가지가 붙은 애들은 콩자루( 빈컨테이너) 들어갈 애들이야! 
//@Component
//	@Controller // 주소매핑이 추가된것
//	
//	
//	@Service
//	@Repository
//	@Configuration //얘 자체 의미보다, 안에 bean 이라는 어노테이션 담고있어
//		@Bean // 남의 코두 주석 달수없는 경우 confi이용해서 Bean으로 한

//@Configuration
public class Config {
	
	@Bean
	public jdbcMenuRepository repository() {
		return new jdbcMenuRepository();
	}
	
	@Bean
	public List list() {
		return new ArrayList();
	}
	
	@Bean
	public String hello() {
		return "hello 콩";
	}
	
}
