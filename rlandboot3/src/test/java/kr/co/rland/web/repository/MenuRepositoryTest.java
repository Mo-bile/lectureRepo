package kr.co.rland.web.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.rland.web.entity.Menu;

//DB에 대해서 실제로 존재하는것을 이용하겠다
//다른것으로 리플레이스 하지않겠다는 의미이다
@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
//@AutoConfigureMybatis
//@SpringBootTest
class MenuRepositoryTest {

	//이거를 쓰려면 스프링의 IoC 컨테이너를 load해야해!
	//컨테이너에 담긴적 없으면 본 repo는 null이야
	@Autowired
	private MenuRepository repository;
	
//	@Test
	void testFindAll() {
//		assertNull(repository);
		
		List<Menu> list= repository.findAll();
		System.out.println(list);
	}
	
	/*   
	  
	  아메리카노 / 5000원 / 음료 / 함께하면 좋은메뉴 :5개 
	  소금라떼  / 20000원 / 음료 / 함께하면 좋은메뉴:5개 
	  치즈쿠키 / 1000원 / 음료 / 함께하면 좋은메뉴:5개 
	  아메리카노 / 5000원 / 음료 / 함께하면 좋은메뉴:5개 
	  아메리카노 / 5000원 / 음료 / 함께하면 좋은메뉴:5개 
	  
	  
	 */
	
//	@Test
	void testFindAllByIds() {
		
		List<Long> ids = new ArrayList<>();
		ids.add(616L);
		ids.add(617L);
		ids.add(713L);
		ids.add(737L);
		
		List<Menu> list= repository.findAllByIds(ids);
		System.out.println(ids);
		System.out.println(list);
	}

//	@Test
	void testUpdate() {

		Menu menu = new Menu();
		menu.setId(844);
		menu.setName("김치아메리카노");
		menu.setImg("qqq");
		
		
		int m = repository.update(menu);
		System.out.println(m);
		
	}
	
	@Test
	void testCount() {
		int count = repository.count(null, null, null);
		System.out.println(count);
	}

}
