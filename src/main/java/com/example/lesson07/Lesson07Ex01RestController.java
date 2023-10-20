package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RestController
@RequestMapping("/lesson07/ex01")
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	//  C U D
	
	// C:create, insert
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "김하늘";
		String phoneNumber = "01011112345";
		String email = "sky@kakao.com";
		String dreamJob = "배우";
		
		// 지금 들어간 id값도 바로 꺼낼 수 있다. getID();
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
}
