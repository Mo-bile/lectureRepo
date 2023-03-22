package kr.co.rland.web.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import kr.co.rland.web.entity.RcmdMenuView;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class RcmdMenuRepositoryTest {
	
	@Autowired
	private RcmdMenuRepository repository;

	@Test
	void RcmdMenutest() {
		
		List<RcmdMenuView> menu = repository.findViewAllByMenuId(617);
		
		System.out.println(menu);
		
		
		
	}

}
