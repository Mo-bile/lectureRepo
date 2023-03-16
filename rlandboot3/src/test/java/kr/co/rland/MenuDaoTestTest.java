package kr.co.rland;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.repository.MenuRepository;
import kr.co.rland.web.repository.jdbc.jdbcMenuRepository;

class MenuDaoTestTest {

	@Test
	void testTest() {

		MenuRepository repository = new jdbcMenuRepository();
//		if(repository.findAll() == null);
		List<Menu> list = repository.findAll();
		System.out.println(list.size());
		System.out.println("작업종료");
	
	}

}
