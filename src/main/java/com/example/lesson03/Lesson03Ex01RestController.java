package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 요청 URL : http://localhost:8080/lesson03/ex01
	// 요청 URL : http://localhost:8080/lesson03/ex01?id=5
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터 value생략가능
			//@RequestParam(value="id") int id // 필수 파라미터 > 파라미터가 없는 경우 400에러 발생
			//@RequestParam(value="id", required=true) int id // 필수 파라미터 required=true > 필수 파라미터라는 문법
			//@RequestParam(value="id", required=false) Integer id // 비필수 파라미터 null일수도 있으니 대문자타입으로
			//@RequestParam(value="id", defaultValue="1") int id // 비필수 파라미터, 디폴트값 1 따라서 null일수 없어서 int
			) { 
		return reviewBO.getReview(id); // response body -> json으로 내려감
	}

	
}
