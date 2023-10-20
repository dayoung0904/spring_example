package com.example.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	//Stirng JPA DATA : JpaRepository 자동으로 함수들을 만들어주는 구문
	
}
