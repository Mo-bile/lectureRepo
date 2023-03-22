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
public class RcmdMenuView extends RcmdMenu{
	
	private String img;
	private String name;
	
}
