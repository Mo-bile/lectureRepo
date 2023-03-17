 package kr.co.rland.web.repository;

import java.util.List;

//ibatis가 원래 이름이야!
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;

//이것을 구현한 구현체를 알아서 repo에 보내주는거야! 
@Mapper
public interface MenuRepository {
	//jdbc 와 mybatis로 구현한게 두개야!
	
	
//	List<Menu> findAll();
//	
//	List<Menu> findAll (Integer offset,
//						Integer size);
	
//	@Select("select * from menu")
	List<Menu> findAll(	Integer offset,
						Integer size, 
						String query,
						Integer categoryId,
						Integer price,
						String orderField,
						String orderDir
						);
	
	List<MenuView> findviewAll(
					Integer offset,
					Integer size, 
					String query,
					Integer categoryId,
					Integer price,
					String orderField,
					String orderDir
					);
	
	List<Menu> findAllByIds(List<Long> ids);
//	@Select("select * from menu where id=#{id}")
	Menu findById(long id);
	
	int count(
			String query,
			Integer categoryId,
			Integer price
			);
	
	int insert(Menu menu);
	int update(Menu menu);
	void delete(long id);


}
