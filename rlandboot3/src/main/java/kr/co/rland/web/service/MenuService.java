package kr.co.rland.web.service;

import java.util.List;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;

public interface MenuService {

	List<Menu> getList();
	List<Menu> getList(int page);
	List<Menu> getList(int page, String query);
	List<Menu> getList(int page, int categoryId);
	List<Menu> getList(int page, int categoryId, String query);
	
//	서비스는 업무적인 단위로 이름을 지어주어야해 
//	그래서 update보다는 다른거하자
	void pointUp();
	
	List<MenuView> getViewList();
	List<MenuView> getViewList(int page);
	List<MenuView> getViewList(int page, String query);
	List<MenuView> getViewList(int page, int categoryId);
	List<MenuView> getViewList(int page, int categoryId, String query);
	
	Menu getById(long id);
	
}