package com.cg.hms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.hms.entity.Application;
import com.cg.hms.entity.Student;
import com.cg.hms.entity.Transaction;

import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.RecordNotFoundException;
import com.cg.hms.service.ApplicationService;
import com.cg.hms.service.StudentService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
@RequestMapping("/student")


public class StudentController {
	
	@Autowired
	private StudentService studentService;
    @Autowired
    private ApplicationService applicationService;
    

	@ApiOperation(value = "find Student by Id",
			response = Student.class,
			tags = "find-student-by-id",
			consumes = "Student",
			httpMethod = "GET")
	@GetMapping("/studentdata/{student_id}")
	public ResponseEntity<Student> getStudent(long student_id) throws RecordNotFoundException{
		try {
			Student student = studentService.getProfile(student_id);
			
		return new ResponseEntity<>(student, HttpStatus.OK);
			
		}catch(RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@ApiOperation(value = "find transaction by Id",
			response = Transaction.class,
			tags = "find-transaction-by-id",
			consumes = "Transaction Object",
			httpMethod = "GET")
	
	@GetMapping("/transactionbyid/{transactionId}")
	public ResponseEntity<Transaction> findByTransactionId(@PathVariable Long transactionId) throws RecordNotFoundException{
		try {
			 Transaction trans = studentService.getTransaction(transactionId);
			 return new ResponseEntity<>(trans, HttpStatus.OK);
		}catch( RecordNotFoundException e) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@ApiOperation(value = "Add details of students",
			response = Application.class,
			tags = "add-students",
			consumes = "Application Object",
			httpMethod = "POST")
	
	@PostMapping("/apply")
	public ResponseEntity<Application> addDetails(@RequestBody Application application)
	{
		try
		{
			Application app=applicationService.addApplication(application);
			 return new ResponseEntity<>(app, HttpStatus.OK);
	    }
		catch(HMAException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Add details of students",
			response = Application.class,
			tags = "add-students",
			consumes = "Application Object",
			httpMethod = "PUT")
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student)
	{
		try
		{
			Student stu=studentService.updateStudent(student);
			 return new ResponseEntity<>(stu, HttpStatus.OK);
	    }
		catch(HMAException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	


}
