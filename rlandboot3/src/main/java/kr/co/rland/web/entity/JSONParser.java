package kr.co.rland.web.entity;

import java.lang.reflect.Field;

import org.springframework.data.relational.core.sql.Column;

public class JSONParser {

	private Object entity;
	
	//일반적으로 파서는 제네릭이 아니라 오브젝트 형식을 이용
	public JSONParser(Object entity) {
		
		this.entity = entity;
	}
	
	
	public String toJSON() throws IllegalArgumentException, IllegalAccessException {

		StringBuilder builder = new StringBuilder();
		
		builder.append("{");
		
		//필드 값 얻어내기!
		Field[] fileds = entity.getClass().getDeclaredFields();
		for (Field f : fileds) {
			String name = f.getName();
			column col = f.getAnnotation(column.class);
			
			
			if(col != null)
				name = col.value();
			
			f.setAccessible(true);
			Object value = f.get(entity);

			String fieldValue = String.format("\"%s\" :%s", name,value);
			
		}
		
		
		builder.append("}");
		
//		String json = "{";

		String json = builder.toString();
		
		return json;
	}
	
}
