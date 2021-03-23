package com.cg.hms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.hms.entity.Student;
import com.cg.hms.entity.User;
import com.cg.hms.entity.Visitor;
import com.cg.hms.entity.Warden;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.RecordNotFoundException;
import com.cg.hms.service.AdminService;

import com.cg.hms.service.VisitorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@Api
@RestController
@RequestMapping("/warden")

public class WardenController {
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private AdminService adminService;
	

	@ApiOperation(value = "Add visitor",
			response = Visitor.class,
			tags = "add-visitor",
			consumes = "visitor",
			httpMethod = "POST")
	
	@PostMapping("/addvisitor")
	public ResponseEntity<Visitor> add(@RequestBody Visitor visitor) {
		try {
			Visitor vis= visitorService.add(visitor);
			return new ResponseEntity<>(vis, HttpStatus.OK);
		}catch(HMAException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	@ApiOperation(value = "Update visitor",
			response = Visitor.class,
			tags = "update-visitor",
			consumes = "visitor",
			httpMethod = "PUT")
	
	@PutMapping("/updatevisitor")
	public ResponseEntity<Visitor> update(@RequestBody Visitor visitor) {
		try {
			Visitor vis= visitorService.update(visitor);
			return new ResponseEntity<>(vis, HttpStatus.OK);
		}catch(HMAException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@ApiOperation(value = "Delete visitor",
			response = String.class,
			tags = "delete-visitor",
			consumes = "visitorId",
			httpMethod = "DELETE")
	
	@DeleteMapping("/deletevisitor/{visitorId}")
	public ResponseEntity<String> delete(@PathVariable Long visitorId) throws RecordNotFoundException {
		try {
			visitorService.deleteById(visitorId);
			return new ResponseEntity<>("Visitor deleted", HttpStatus.OK);
		}catch(RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@ApiOperation(value = "Visitor by id",
			response = Visitor.class,
			tags = "visitor-by-id",
			consumes = "visitorId",
			httpMethod = "GET")
	
	@GetMapping("/visitorbyid/{visitorId}")
	public ResponseEntity<Visitor> findByVisitorId(@PathVariable Long visitorId) throws RecordNotFoundException{
		try {
			Visitor vis = visitorService.findByVisitorId(visitorId);
			return new ResponseEntity<>(vis, HttpStatus.OK);
		}catch(RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	
	/* @ApiOperation(value = "Find my name Visitor",
			response = Visitor.class,
			tags = "find-by-name"
			consumes = "visitorName",
			httpMethod = "Get")  */
	
//	@GetMapping("/visitors/{visitorId}")
//	public ResponseEntity<Visitor> findByName(@PathVariable String visitorName){
//		try {
//			Visitor vis = visitorService.findByName(visitorName);
//			return new ResponseEntity<>(vis, HttpStatus.OK);
//		}catch(HMAException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//
//	}
	@ApiOperation(value = "Get all visitors",
			response = Visitor.class,
			tags = "search-visitor",
			consumes = "visitor",
			httpMethod = "GET")
	 
	
	@GetMapping("/getallvisitors")
	public ResponseEntity<List<Visitor>> search(){
		try {
			List<Visitor> visitorList = visitorService.search();
			return new ResponseEntity<>(visitorList, HttpStatus.OK);
		}catch(HMAException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@ApiOperation(value = "Get all students",
			response = Visitor.class,
			tags = "get-all-students",
			consumes = "visitor",
			httpMethod = "GET")
	
	@GetMapping("/getallstudents")
	public ResponseEntity<List<Student>>getAllstudent(){
		try {
			List<Student> studentList = adminService.getAllStudents();
			return new ResponseEntity<>(studentList, HttpStatus.OK);
			
		}catch(HMAException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	}
