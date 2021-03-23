//package com.cg.hms.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.cg.hms.entity.Hostel;
//import com.cg.hms.exception.HMAException;
//import com.cg.hms.exception.RecordNotFoundException;
//import com.cg.hms.repository.HostelDAO;
//import com.cg.hms.service.HostelService;
//
///***
// * This class implements HostelService interface from service layer 
// * and implements its methods.
// * @author sunny
// *
// */
//@Service
//@Transactional
//public class HostelServiceImpl implements HostelService{
//	@Autowired
//	private HostelDAO hostelDao;
//	
//	@Override
//	public Hostel searchByHostelId(long hostelId) {
//		
//		try {
//			Optional<Hostel> optional= hostelDao.findById(hostelId);
//			if(optional.isPresent()) {
//				return optional.get();
//			}else {
//				throw new Exception("Invalid Hostel Id");
//			}
//		}catch(DataAccessException e) {
//			//converting SQLException to EmployeeException
//			throw new HMAException(e.getMessage());
//		}catch(Exception e) {
//			//converting SQLException to EmployeeException
//			throw new HMAException(e.getMessage());
//		}
//		
//	}
//
////	@Override
////	public Hostel searchByHostelName(String hostelName) {
////		try {
////			Hostel hostel= hostelDao.searchByHostelName(hostelName);
////			if ( hostel == null ) {
////				throw new Exception("Invalid Hostel Name");
////			}else{
////				return hostel;
////			}
////		}catch(DataAccessException e) {
////			//converting SQLException to EmployeeException
////			throw new HMAException(e.getMessage());
////		}catch(Exception e) {
////			//converting SQLException to EmployeeException
////			throw new HMAException(e.getMessage());
////		}
////	
////	}
//
//	@Override
//	public List<Hostel> search() {
//		try {
//			return hostelDao.findAll();
//		}catch(DataAccessException e) {
//			//converting SQLException to EmployeeException
//			throw new HMAException(e.getMessage());
//		}catch(Exception e) {
//			//converting SQLException to EmployeeException
//			throw new HMAException(e.getMessage());
//		}
//		
//	}
//
//}
