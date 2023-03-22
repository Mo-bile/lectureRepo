package kr.co.rland.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.rland.web.entity.RcmdMenuView;
import kr.co.rland.web.repository.MenuRepository;
import kr.co.rland.web.repository.RcmdMenuRepository;

@Service
public class DefaultRcmdMenuService implements RcmdMenuService {

	@Autowired
	private RcmdMenuRepository repository;
	
//	public void setRepository(RcmdMenuRepository repository) {
//		this.repository = repository;
//	}
	
	@Override
	public List<RcmdMenuView> getViewListMenuId(int menuId) {
		// TODO Auto-generated method stub
		
		return repository.findViewAllByMenuId(menuId);
	}

}
