package com.cg.hms.service.impl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Admin;
import com.cg.hms.entity.Allotment;
import com.cg.hms.entity.Student;
import com.cg.hms.entity.Warden;
import com.cg.hms.exception.HMAException;
import com.cg.hms.repository.AdminDAO;
import com.cg.hms.repository.AllotmentDAO;
import com.cg.hms.repository.StudentDAO;
import com.cg.hms.repository.WardenDAO;
import com.cg.hms.service.AdminService;

/**
 * Admin service implementation class emplements all the methods declared in admin service interface
 * @author Ajay
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
	private WardenDAO wardenDao;
	@Autowired
	private StudentDAO studentDao;
	
	@Autowired
	private AllotmentDAO allotmentDao;
	@Autowired
	private AdminDAO adminDao;
	
	@Override
	public Warden addWarden(Warden warden) throws HMAException {
		try {			
			return wardenDao.save(warden);
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public Warden updateWarden(Warden warden) throws HMAException {
		try {			
			return wardenDao.save(warden);
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public void deleteWarden(Long wardenId) throws HMAException {
		try {			
			wardenDao.deleteById(wardenId);
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
		
	}
	@Override
	public Warden getWardenById(Long wardenId) throws HMAException {
		try {			
			Optional<Warden> optional=wardenDao.findById(wardenId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Warden Id");
			}
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public List<Warden> getAllWardens() throws HMAException {
		try {			
			return  wardenDao.findAll();
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public Student addStudent(Student student) throws HMAException {
		try {			
			return studentDao.save(student);
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public Student updateStudent(Student student) throws HMAException {
		try {			
			return studentDao.save(student);
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public void deleteStudent(Long studentId) throws HMAException {
		try {			
			studentDao.deleteById(studentId);
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
		
		
	}
	@Override
	public Student getStudentById(Long studentId) throws HMAException {
		try {			
			Optional<Student> optional=studentDao.findById(studentId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Student Id");
			}
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public List<Student> getAllStudents() throws HMAException {
		try {			
			return  studentDao.findAll();
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public Allotment addAllotment(Allotment allotment) throws HMAException {
		try {			
			return allotmentDao.save(allotment);
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public Allotment updateAllotment(Allotment allotment) throws HMAException {
		try {			
			return allotmentDao.save(allotment);
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public void deleteAllotment(Long allotmentId) throws HMAException {
		try {			
			allotmentDao.deleteById(allotmentId);
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
		
	}
	@Override
	public Allotment getAllotmentById(Long allotmentId) throws HMAException {
		try {			
			Optional<Allotment> optional=allotmentDao.findById(allotmentId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Student Id");
			}
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	@Override
	public List<Allotment> getAllAllotments() throws HMAException {
		try {			
			return  allotmentDao.findAll();
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}
	
	
	

}
