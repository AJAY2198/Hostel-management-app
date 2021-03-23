package com.cg.hms.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;

import com.cg.hms.entity.Allotment;
import com.cg.hms.entity.Student;
import com.cg.hms.entity.Warden;
import com.cg.hms.exception.HMAException;
import com.cg.hms.service.AdminService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController

@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;

	@ApiOperation(value = "Get Students",
			response = Student.class,

			tags = "get-all Students",			
			httpMethod = "GET")
	@GetMapping("/student/getallstudents")
	public ResponseEntity<List<Student>> getAllStudents() throws HMAException{
		try {
			List<Student> StudentList = adminService.getAllStudents();
			return new ResponseEntity<>(StudentList, HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}


	@ApiOperation(value = "Update Student",
			response = Student.class,
			consumes = "student Object",
			tags = "update-student record-by admin",
			httpMethod = "PUT")
	@PutMapping("/student/updatestudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student st) throws HMAException {
		try {
			Student student=adminService.updateStudent(st);
			return new ResponseEntity<>(student, HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Get Student",
			response = Student.class,
			consumes = "studentId",
			tags = "get-Student by Id",			
			httpMethod = "GET")
	@GetMapping("/student/getstudentbyid/{studentId}")
	public ResponseEntity<Student> getPolicyHolderById(@PathVariable Long studentId) throws HMAException
	{
		try {
			Student student=adminService.getStudentById(studentId);
			return new ResponseEntity<>(student, HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Delete Student",
			response = String.class,
			consumes = "StudentId",
			tags = "delete student record",
			httpMethod = "DELETE")
	@DeleteMapping("/student/deletestudent/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) throws HMAException
	{
		try {
			adminService.deleteStudent(studentId);
			return new ResponseEntity<>("Student Deleted", HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}






	@ApiOperation(value = "Get warden",
			response = Warden.class,
			consumes = "warden_id",
			tags = "get-warden by Id",			
			httpMethod = "GET")
	@GetMapping("/warden/getwardenbyid/{wardenId}")
	public ResponseEntity<Warden> getWardenById(@PathVariable Long wardenId) throws HMAException
	{
		try {
			Warden war=adminService.getWardenById(wardenId);
			return new ResponseEntity<Warden>(war,HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}


	@ApiOperation(value = "Get Warden",
			response = Warden.class,

			tags = "get-all warden",			
			httpMethod = "GET")
	@GetMapping("/warden/getallwardens")
	public ResponseEntity<List<Warden>> getAllWardens() throws HMAException
	{
		try {
			List<Warden> wardenList=adminService.getAllWardens();
			return new ResponseEntity<List<Warden>>(wardenList,HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}
	@ApiOperation(value = "Update Warden",
			response = Warden.class,
			consumes = "Warden Object",
			tags = "update-Warden record-by admin",
			httpMethod = "PUT")
	@PutMapping("/warden/updatewarden")
	public ResponseEntity<Warden> updateWarden(@RequestBody Warden warden) throws HMAException
	{
		try {
			Warden war=adminService.updateWarden(warden);
			return new ResponseEntity<>(war,HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Delete Warden",
			response = String.class,
			consumes = "warden_id",
			tags = "delete-warden record",
			httpMethod = "DELETE")
	@DeleteMapping("/warden/deletewarden/{wardenId}")
	public ResponseEntity<String> deleteAgent(@PathVariable Long wardenId) throws HMAException
	{
		try {
			adminService.deleteWarden(wardenId);
			return new ResponseEntity<>("Agent Deleted",HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}
	
	@ApiOperation(value = "Allot",
			response = Allotment.class,
			consumes = "Allotment object",
			tags = "allotement record-by admin",
			httpMethod = "POST")
	@PostMapping("/allotment/allot")
	public ResponseEntity<Allotment> addAllotment(@RequestBody Allotment allotment) throws HMAException
	{
		try {
			Allotment alot=adminService.addAllotment(allotment);
			return new ResponseEntity<>(alot,HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Allot",
			response = Allotment.class,
			consumes = "Allotment object",
			tags = "upadte allotement record-by admin",
			httpMethod = "PUT")
	@PutMapping("/allotment/updatallotment")
	public ResponseEntity<Allotment> updateAllotment(@RequestBody Allotment allotment) throws HMAException
	{
		try {
			Allotment alot=adminService.updateAllotment(allotment);
			return new ResponseEntity<>(alot,HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Delete Allot",
			response = Allotment.class,
			consumes = "Allotment object",
			tags = "delete allotement record-by admin",
			httpMethod = "DELETE")
	@DeleteMapping("/allotment/deleteallot{allotmentId}")
	public ResponseEntity<String> deleteAllotment(@RequestBody Long allotmentId) throws HMAException
	{
		try {
			adminService.deleteAllotment(allotmentId);
			return new ResponseEntity<>("Allotent Deleted",HttpStatus.OK);
		}catch(HMAException e) {
			throw new HMAException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}


}
