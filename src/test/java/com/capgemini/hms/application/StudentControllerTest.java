package com.capgemini.hms.application;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.hms.application.HostelManagementAppApplication;
import com.cg.hms.entity.Application;
import com.cg.hms.entity.Student;
import com.cg.hms.entity.Transaction;
import com.cg.hms.exception.RecordNotFoundException;
import com.cg.hms.repository.ApplicationDAO;
import com.cg.hms.repository.StudentDAO;
import com.cg.hms.repository.TransactionDAO;
import com.cg.hms.service.ApplicationService;
import com.cg.hms.service.StudentService;
import com.cg.hms.service.TransactionService;

//@SpringBootTest


@SpringBootTest(classes=HostelManagementAppApplication.class)
public class StudentControllerTest {

	@Mock
	StudentService studentService;
	
	@Mock
	StudentDAO studentDAO;
	
    @Mock
    ApplicationService applicationService;
    
    @Mock
    ApplicationDAO applicationDAO;
    
    @Mock
    TransactionService transactionService;
    
    @Mock
    TransactionDAO transactionDAO;
    
   
    
	@Test
	void getProfile()  {
		
		Student student=new Student();
		
		try {
			Student student1=studentService.getProfile(1);
		} catch (RecordNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			verify(studentService,times(1)).getProfile(1);
		} catch (RecordNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	@Test
	void testGetTransaction() {

		Transaction transaction = new Transaction();

		try {
			Transaction transaction1  =studentService.getTransaction(1);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			verify(studentService, times(1)).getTransaction(1);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @Test
	void testAddApplication()  {
		Application application = new Application();
		
		Application application1=applicationService.addApplication(application);

		verify(applicationService, times(1)).addApplication(application);
	}
    
    @Test
	void testUpdateStudent()
	{
    	Student student=new Student();
    	
    	Application application = new Application();
    	
    	applicationService.addApplication(application);
    	
		
    	student.setStudent_Name("Abc");
    	
    	student.setEmail("Abc@gmail.com");
		
		studentService.updateStudent(student);
		
		verify(applicationService, times(1)).addApplication(application);
		
		verify(studentService, times(1)).updateStudent(student);
	
    	
    	
	}

    
    
    
    
    
    
}