package kr.co.rland.web.entity;

import java.util.Date;

//본 파일은 조인한 결과를 담을 수있는 그릇이야!
public class MenuView extends Menu{
	
	private String categoryName;
	
	public MenuView() {
		// TODO Auto-generated constructor stub
		
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public MenuView(long id, String name, Integer price, String img, Date regDate, int categoryId, long regMemberId, String categoryName)  {
		super(id, name, price, img, regDate, categoryId, regMemberId);
		// TODO Auto-generated constructor stub
		
		this.categoryName = categoryName;
	}

	public MenuView(String name, Integer price, String img, int categoryId, long regMemberId) {
		super(name, price, img, categoryId, regMemberId);
		// TODO Auto-generated constructor stub
		this.categoryName = categoryName;
	}
	
	
}
