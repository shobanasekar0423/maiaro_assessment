package com.assignment.Maiora;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;
	
	public void save(Student student) {
		repo.save(student);
	}
	
	public List<Student> findAll() {
		return repo.findAll();
	}

	public int calculateAge(Student student) {
		// TODO Auto-generated method stub
		LocalDate dob = 
	            LocalDate.of(student.getBirthYear(), Month.of(student.getBirthMonth()), student.getBirthDate());
		LocalDate currentDate = LocalDate.now();
		Period periodBetween = Period.between(dob, currentDate);
		int age = periodBetween.getYears();
		return age;
		
	}

	public List<Student> findStudentBetweenAges(int fromAge, int toAge) {
		// TODO Auto-generated method stub
		return repo.findStudentBetweenAges(fromAge, toAge);
	}
}
