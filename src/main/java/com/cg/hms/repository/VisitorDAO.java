package com.cg.hms.repository;

import java.util.List;
import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entity.Visitor;


/**VisitorDao class extends JpaREpository
 * 
 * @author Deeksha
 *
 */
@Repository
public interface VisitorDAO extends JpaRepository<Visitor,Long> {

	//Visitor findByName(String visitorName);

}
