package kr.co.rland.web.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 엔티티란 DB에서 담을녀석이다 . 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
	
	private long id;
	private String name;
	private Integer price;
	private String img;
	
	//새로 추가한 부분 
	private String description;
	
//	@column("reg_Date")
	private Date regDate;
	private int categoryId;
	private long regMemberId;
	
//	public Menu() {
//		// TODO Auto-generated constructor stub
//	}
//
//	//사용자가 하는 것
//	public Menu(String name, Integer price, String img, int categoryId, long regMemberId) {
//		super();
//		this.name = name;
//		this.price = price;
//		this.img = img;
//		this.categoryId = categoryId;
//		this.regMemberId = regMemberId;
//	}
//	
//	//기본전체!
//	public Menu(long id, String name, Integer price, String img, Date regDate, int categoryId, long regMemberId) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.img = img;
//		this.regDate = regDate;
//		this.categoryId = categoryId;
//		this.regMemberId = regMemberId;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Integer getPrice() {
//		return price;
//	}
//
//	public void setPrice(Integer price) {
//		this.price = price;
//	}
//
//	public String getImg() {
//		return img;
//	}
//
//	public void setImg(String img) {
//		this.img = img;
//	}
//	
//	
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Date getRegDate() {
//		return regDate;
//	}
//
//	public void setRegDate(Date regDate) {
//		this.regDate = regDate;
//	}
//
//	public int getCategoryId() {
//		return categoryId;
//	}
//
//	public void setCategoryId(int categoryId) {
//		this.categoryId = categoryId;
//	}
//
//	public long getRegMemberId() {
//		return regMemberId;
//	}
//
//	public void setRegMemberId(long regMemberId) {
//		this.regMemberId = regMemberId;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", img=" + img + ", regDate=" + regDate
//				+ ", categoryId=" + categoryId + ", regMemberId=" + regMemberId + "]";
//	}
//	

	
	
	
}
