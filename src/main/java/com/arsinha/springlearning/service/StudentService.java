package com.arsinha.springlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arsinha.springlearning.model.Student;
import com.arsinha.springlearning.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired 
	StudentRepository studentRepository;
	
	public void saveOrUpdate(Student students) {
		studentRepository.save(students);
	}
	public Student getStudentById(int studentId) {
		return studentRepository.findById(studentId).get();
	}
	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}
	public void deleteStudentById(int studentId) {
		
		 studentRepository.deleteById(studentId);
	}

}
