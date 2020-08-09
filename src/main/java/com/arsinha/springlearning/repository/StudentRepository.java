package com.arsinha.springlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.arsinha.springlearning.model.Student;  


public interface StudentRepository extends CrudRepository <Student, Integer>{

}
