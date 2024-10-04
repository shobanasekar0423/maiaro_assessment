package com.assignment.Maiora;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	public Student save(Student student);
	public List<Student> findAll();
	@Query("Select a from Student a where a.age>=?1 AND a.age<=?2")
	public List<Student> findStudentBetweenAges(int fromAge, int toAge);
}
