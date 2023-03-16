package kr.co.rland.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration //@bean을 위해서 componet대신에 이거 써 (의미 살리기)
public class TilesConfig {

	//리졸버가 타일즈의 역할하는 역할자야
	
	//리졸버가 명령어를 가지고 명령어를 찾는녀석이야
	//뷰 정보를 찾아주는애를 뷰 리졸버라고 해!
	//리소스 뷰 리졸버에서 타일즈 뷰 리졸버 라고해
	//타일즈가 리소스를 가지게 돼
	
	
	
	@Bean
	//리졸버 깨우기
	public UrlBasedViewResolver tilesBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//		resolver.setViewClass(Tiles);
		return resolver;
	}
	
	//설정파일 어디있는지 알려주기
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
	}
	
}
