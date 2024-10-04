package com.assignment.Maiora;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	public Student save(Student student);
	public List<Student> findAll();
}
