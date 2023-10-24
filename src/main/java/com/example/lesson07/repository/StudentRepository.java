package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	//Stirng JPA DATA : JpaRepository 자동으로 함수들을 만들어주는 구문
	
	// sava(객체) - insert, update id가 없으면 insert, id가 있으면 update
	// findById() - id로 select
	// delete(객체) - 객체를 delete
	// findAll() - 전체 조회
	
	// JPQL 문법 : 기본제공 함수가 아닌 경우 - ex02/1
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContaining(String email);
	public List<StudentEntity> findByNameStartingWith(String name);
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	// ex02/2
	// 1) JPQL(DB에 직접가지 않고 Entity로 조회)
	//@Query(value = "select st from new_student st where st.dreamJob = :dreamJob") // 엔티티에서 조회
	
	// 2) native query로 조회
	@Query(value="select * from `new_student` where `dreamJob` = :dreamJob", nativeQuery = true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob")String dreamJob);
}
