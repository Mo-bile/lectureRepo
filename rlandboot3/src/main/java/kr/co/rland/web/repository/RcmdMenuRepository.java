 package kr.co.rland.web.repository;

import java.util.List;

//ibatis가 원래 이름이야!
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.entity.RcmdMenu;
import kr.co.rland.web.entity.RcmdMenuView;

//이것을 구현한 구현체를 알아서 repo에 보내주는거야! 
@Mapper
public interface RcmdMenuRepository {
	
	List<RcmdMenuView> findViewAllByMenuId(int menuId);
	
	//추천에서는 몇개인지 알필요 없어
//	int count(
//			String query,
//			Integer categoryId,
//			Integer price
//			);
	
	//추천추가할수 있으니 넣기
	int insert(RcmdMenu rcmdmenu);
	
	//update 필요없어
//	int update(RcmdMenu rcmdmenu);
	void delete(long id);


}
