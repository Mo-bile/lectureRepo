package kr.co.rland.web.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	void testFindAll() {
		List<Category> list = repository.findAll();
		Category category = list.get(0); //get 이뜨면 롬복성공
		
		System.out.println("작업완료");
		System.out.println(list);
	}

}
