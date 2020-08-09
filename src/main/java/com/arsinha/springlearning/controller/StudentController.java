package com.arsinha.springlearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arsinha.springlearning.model.Student;
import com.arsinha.springlearning.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping(value="/all")
	private Iterable<Student> getAllStudent() {
		Iterable<Student> students = new ArrayList<Student>();  
		students=studentService.findAll(); 
		return students;
		
	}
	
	@PostMapping("/student")
	private void CreateStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
	}
	@PutMapping("/student")
	private void UpdateStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
	}
	@GetMapping("/student/{studentId}")
	private Student getStudentById(@PathVariable("studentId") int studentId) {
		return studentService.getStudentById(studentId);
	}

	@DeleteMapping("/student/{studentId}")
	private void deleteStudentById(@PathVariable("studentId") int studentId) {
		 studentService.deleteStudentById(studentId);
	}

}
