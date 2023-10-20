package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;


@Service
public class StudentBO {
	@Autowired
	private StudentMapper studentMapper; // mybatis
	
	@Autowired
	private StudentRepository studentRepository; // JPA
	
	// mybatis
	// input : Student
	// output : X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	// JPA
	// input:파라미터들		output:StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder() // setter는 미완성 상태로 생성될 수 있음 builder는 모든 date를 넣고 생성시킴
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimstamp 있으면 생략가능
				.build();
		return studentRepository.save(student);
	}
}
