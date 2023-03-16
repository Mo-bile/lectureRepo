package kr.co.rland.web.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Calculator 진짜 = new DefaultCalculator(3,4);
		 Calculator 진짜2 = new DefaultCalculator(5,6);
	      
		 //가짜를 만들자
		 //프록시를 만들어주는 API를 쓰자!
		 
		 Calculator 가짜 = (Calculator) Proxy.newProxyInstance(
				 
			//1. 첫번째 실제로 가진녀석의 기능알 알려주어야해
				 DefaultCalculator.class.getClassLoader()
			//2. 두번째 인터페이스 목록을 넣어주자!
				 //구현체가 구현하고있는 인터페이스목록이야
				 //여러개면 다 넣어주자! 
				 , new Class[] {Calculator.class}
			//3. 세번째 곁다리를 넣어주는거야!
				 //넣어주느 공간이야!
				 //람다로 바꾸어줬어
				,(Object proxy, Method method, Object[] ags) -> {
					// TODO Auto-generated method stub
					
					//이렇게 앞뒤로 다 꽂아넣을 수있어
					System.out.printf("호출되고있는 메소드 이름 %s\n", method.getName());
					System.out.printf("%s 메소드 호출 전\n",method.getName());
					Object result = method.invoke(진짜2, ags); //정적으로 calc호출하는것
					System.out.printf("결과값 : %d \n ",result);
					System.out.printf("%s 메소드 호출 후\n",method.getName());
					
					return (int) result;
				});
		 
		  Calculator calc = 가짜;
		 
	      int result = 0;
	      
	      result = calc.plus();
	      System.out.printf("plus result : %d\n", result);
	      System.out.println();
	      result = calc.sub();
	      System.out.printf("sub result : %d\n", result);
	      System.out.println();
	      result = calc.multi();
	      System.out.printf("multi result : %d\n", result);
	      System.out.println();
	
	
	}

}
