package com.cg.hms.service.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Warden;
import com.cg.hms.exception.HMAException;
import com.cg.hms.repository.WardenDAO;
import com.cg.hms.service.WardenService;

/**
 * Warden service implementation class implements all methods declared in warden service interface
 * @author Aniket
 *
 */
@Service
@Transactional
public class WardenServiceImpl implements WardenService{
	@Autowired
	private WardenDAO wardenDao;

	@Override
	public Warden add(Warden warden) {
		try {			
			return wardenDao.save(warden);
		}catch(DataAccessException e) {
			//converting SQLException to HMAException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to HMAException
			throw new HMAException(e.getMessage());
		}
		
	}

	@Override
	public Warden update(Warden warden) {
		try {
			return wardenDao.save(warden);
		}catch(DataAccessException e) {
			//converting SQLException to HMAException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to HMAException
			throw new HMAException(e.getMessage());
		}
	}

	@Override
	public void delete(long wardenId){
		try {
			wardenDao.deleteById(wardenId);
		}catch(DataAccessException e) {
			//converting SQLException to HMAException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to HMAException
			throw new HMAException(e.getMessage());
		}
	}


	@Override
	public Warden findByWardenId(long wardenId)  {
		try {
			Optional<Warden> optional= wardenDao.findById(wardenId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid wardenId");
			}
		}catch(DataAccessException e) {
			//converting SQLException to HMAException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to HMAException
			throw new HMAException(e.getMessage());
		}
	}

	@Override
	public List<Warden> getAllWarden(){
		try {
			return wardenDao.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to HMAException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to HMAException
			throw new HMAException(e.getMessage());
		}
	}

//	@Override
//	public Warden findByWardenName(String wardenName) {
//		
//		try {
//			Warden warden= wardenDao.findByWardenName(wardenName);
//			if(warden != null ) {
//				return warden;
//			}else {
//				throw new Exception("Invalid Warden Name");
//			}
//		}catch(DataAccessException e) {
//			//converting SQLException to HMAException
//			throw new HMAException(e.getMessage());
//		}catch(Exception e) {
//			//converting SQLException to HMAException
//			throw new HMAException(e.getMessage());
//		}
//	}

}

