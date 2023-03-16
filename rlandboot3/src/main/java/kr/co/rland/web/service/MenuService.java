package kr.co.rland.web.service;

import java.util.List;

import kr.co.rland.web.entity.Menu;

public interface MenuService {

	List<Menu> getList();
	
//	서비스는 업무적인 단위로 이름을 지어주어야해 
//	그래서 update보다는 다른거하자
	void pointUp();
	
	
}
