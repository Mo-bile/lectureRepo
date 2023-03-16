package kr.co.rland.web.repository.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.repository.MenuRepository;

//@Repository
public class MbMenuResponsitory implements MenuRepository {

	private SqlSession session;
	
	//각 메소드마다 선언하는게 아니라 여기서 한번에 선언한다.
	private MenuRepository repository;
	
	public MbMenuResponsitory() {
		// TODO Auto-generated constructor stub
	}

	//여기에다가 주입한다!
	@Autowired
	public MbMenuResponsitory(SqlSession session) {
		super();
		
		//sqlSession을 주입하고,
		this.session = session;
		
		//마찬가지로 외부의 session의 getMapper로 repository에 주입한다.
		//본 클래스의 멤버 repository에 모두 적용이 된다 
		this.repository = session.getMapper(MenuRepository.class);
	}

//	@Override
//	public List<Menu> findAll() {
//		
////		MenuRepository repository = session.getMapper (MenuRepository.class);
////		return repository.findAll(0, 10, null, null, null, null, null);
//		
//		//옛날방식
//		return session.selectList("kr.co.rland.web.repository.MenuRepository.findAll");
//		
//	}
	

//	@Override
//	public List<Menu> findAll (Integer offset, Integer size){
//		
////	MenuRepository repository = session.getMapper (MenuRepository.class);
//	return repository.findAll (offset, size, null, null, null, null, null);
//	
//	}

	@Override
	public List<Menu> findAll(Integer offset, Integer size, String query, Integer categoryId, Integer price,
			String orderField, String orderDir) {

//		MenuRepository repository = session.getMapper(MenuRepository.class);
		
		return repository.findAll (null, null, null, null, null, null, null);
	}

	@Override
	public List<Menu> findAllByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		
		MenuRepository repository = session.getMapper(MenuRepository.class);
		
		return repository.findAllByIds(ids);
	}

	@Override
	public Menu findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu insert(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Menu menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
