package com.capgemini.hms.application;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.hms.application.HostelManagementAppApplication;
import com.cg.hms.entity.Student;
import com.cg.hms.entity.Visitor;
import com.cg.hms.exception.RecordNotFoundException;
import com.cg.hms.repository.StudentDAO;
import com.cg.hms.repository.VisitorDAO;
import com.cg.hms.service.AdminService;
import com.cg.hms.service.VisitorService;



@SpringBootTest(classes=HostelManagementAppApplication.class)
public class WardenControllerTest {
	
	@Mock
	VisitorService visitorService;
	
    @Mock
    VisitorDAO visitorDAO;
    
    @Mock
    AdminService adminService;
    
    @Mock
    StudentDAO studentDAO;
    
    
	
    @Test
	void testAdd()  {
		Visitor visitor = new Visitor();
		visitorService.add(visitor);
		
		verify(visitorService, times(1)).add(visitor);
	}
	
	@Test
	void testUpdateUser()  {
		Visitor visitor = new Visitor();
		visitorService.add(visitor);
		
		visitor.setRelation("Brother");
		visitor.setVisitorName("Abc");
		
		visitorService.update(visitor);
		
		verify(visitorService, times(1)).add(visitor);
		verify(visitorService, times(1)).update(visitor);
	}

	@Test
	void testDelete()  {
		Visitor visitor = new Visitor();
		visitorService.add(visitor);
		
	    try {
			visitorService.deleteById(1);
		} catch (RecordNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		verify(visitorService, times(1)).add(visitor);
		try {
			verify(visitorService, times(1)).deleteById(1);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	void testFindByVisitorId()  {

		Visitor visitor = new Visitor();

		try {
			Visitor visitor1  = visitorService.findByVisitorId(1);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			verify(visitorService, times(1)).findByVisitorId(1);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testSearch()  {
		Visitor visitor1 = new 	Visitor();
		Visitor visitor2 = new 	Visitor();
		Visitor visitor3 = new 	Visitor();
		visitorService.add(visitor1);
		visitorService.add(visitor2);
		visitorService.add(visitor3);
		
		List<Visitor> visitorList = new ArrayList<Visitor>();
		visitorList.add(visitor1);
		visitorList.add(visitor2);
		visitorList.add(visitor3);
		
		when(visitorService.search()).thenReturn(visitorList);

		List<Visitor> getVisitorList = visitorService.search();
		verify(visitorService, times(1)).search();
		
		assertEquals(3, getVisitorList.size());
	}

    


	@Test
	void testGetAllStudents()  {
	    Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		adminService.addStudent(student1);
		adminService.addStudent(student2);
		adminService.addStudent(student3);
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		when(adminService.getAllStudents()).thenReturn(studentList);

		List<Student> studentList1 = adminService.getAllStudents();
		verify(adminService, times(1)).getAllStudents();
		
		assertEquals(3, studentList1.size());
	}

    
    
   }
