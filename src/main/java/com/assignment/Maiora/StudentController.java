package com.assignment.Maiora;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
	@Autowired
	public StudentService studentService;


    @PostMapping("/createStudentRecord")
	public ResponseEntity<?> saveUser(@RequestBody Student student) {
    	
		Map<String, Object> map = new HashMap<String, Object>();
		LocalDate dob = 
	            LocalDate.of(student.getBirthYear(), Month.of(student.getBirthMonth()), student.getBirthDate());
		student.setDob(dob);
		int age = studentService.calculateAge(student);
		student.setAge(age);
		studentService.save(student);
			map.put("status", 1);
			map.put("message", "Record is Saved Successfully!");
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		}
 @GetMapping("/getAllStudents")
  public ResponseEntity<?> findAllStudents(){
  	Map<String, Object> map = new HashMap<String, Object>();

  	List<Student> studentList = studentService.findAll();
  	if (studentList != null) {
			map.put("status", 1);
			map.put("data", studentList);
			return new ResponseEntity<>(map, HttpStatus.OK);
  	}else {
  		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  	}
 }
  	
  	@PostMapping(value="/getstudentbyage")
	  public ResponseEntity<?>  getstudentbyage(@RequestParam("fromAge") int fromAge, @RequestParam("toAge") int toAge) {
  	  	Map<String, Object> map = new HashMap<String, Object>();

  	  	List<Student> studentList = studentService.findStudentBetweenAges(fromAge, toAge);
  	  	if (studentList != null) {
  				map.put("status", 1);
  				map.put("data", studentList);
  				return new ResponseEntity<>(map, HttpStatus.OK);
  	  	}else {
  	  		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  	  	}
  	}
}
