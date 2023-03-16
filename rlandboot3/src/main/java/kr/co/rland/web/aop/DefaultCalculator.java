package kr.co.rland.web.aop;

public class DefaultCalculator implements Calculator {

	private int x;
	private int y;
	
	public DefaultCalculator() {
		// TODO Auto-generated constructor stub
	}
	
	
	public DefaultCalculator(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int plus() {
		
		int result = this.x + this.y;
		//여기 사이에 들가는건 사용자가 원하는건 아냐 
		//로그처리 트랜잭션처리 예외처리 등의 경우! 
		
		
		
		return result;
	}

	@Override
	public int sub() {
		// TODO Auto-generated method stub
		int result = x - y;
		
		
		
		
		return result;
	}

	@Override
	public int multi() {
		// TODO Auto-generated method stub
		int result = x * y;
		
		
		
		return result;
	}

}
