package com.example.lesson03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson03Ex01RestController {
	
	// 요청 URL : http://localhost:8080/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review ex01() {
		return ;
	}

}
