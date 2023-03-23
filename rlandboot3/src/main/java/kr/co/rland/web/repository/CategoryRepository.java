 package kr.co.rland.web.repository;

import java.util.List;

//ibatis가 원래 이름이야!
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;

//이것을 구현한 구현체를 알아서 repo에 보내주는거야! 
@Mapper
public interface CategoryRepository {

	List<Category> findAll();
	Category findById(long id);
	
	int insert(Category category);
	int update(Category category);
	void delete(long id);
	

}
