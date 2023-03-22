package kr.co.rland.web.service;

import java.util.List;

import kr.co.rland.web.entity.RcmdMenuView;

//메뉴 컨트롤러에서 사용이 될거야
public interface RcmdMenuService {

	List<RcmdMenuView> getViewListMenuId(int menuId);
	
}
