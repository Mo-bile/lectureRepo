package kr.co.rland.web.aop;

public interface Calculator {

//	int plus(int x , int y); //함수가 넘겨받는거라 호출 할때 마다 값이 달라져 
	
	int plus(); //멤버값으로서 공유변수가 한번 설정하면 이래저래 쓸수있어 
	int sub();
	int multi();
	
}
