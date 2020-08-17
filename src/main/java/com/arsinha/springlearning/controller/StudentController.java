package com.arsinha.springlearning.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arsinha.springlearning.exceptions.StudentNotFoundException;
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
	private ResponseEntity<?> createStudent(@Valid @RequestBody Student student) {
		
		studentService.saveOrUpdate(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/student")
	private ResponseEntity<?> updateStudent(@Valid @RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	@GetMapping("/student/{studentId}")
	private Student getStudentById(@PathVariable("studentId") int studentId) throws Exception {
		try {
		return studentService.getStudentById(studentId);
		}
		catch(InvalidDataAccessApiUsageException e) {
			throw new StudentNotFoundException("studentId: "+ studentId);

		}
		catch(Exception ex) {
			throw new Exception("studentId: "+ studentId);
		}
	}

	@DeleteMapping("/student/{studentId}")
	private void deleteStudentById(@PathVariable("studentId") int studentId) throws Exception {
		try{Student student=studentService.getStudentById(studentId);
		 if(student==null) { 
			//runtime exception  
			throw new StudentNotFoundException("studentId: "+ studentId);
		 }
		 else {
			 studentService.deleteStudentById(studentId);
		 }
		}catch(InvalidDataAccessApiUsageException e) {
			throw new StudentNotFoundException("studentId: "+ studentId);

		}
		catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception("studentId: "+ studentId);
		}
			}  
	

}
