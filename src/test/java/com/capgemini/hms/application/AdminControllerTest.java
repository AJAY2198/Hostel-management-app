package com.capgemini.hms.application;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.hms.application.HostelManagementAppApplication;
import com.cg.hms.entity.Allotment;
import com.cg.hms.entity.Student;
import com.cg.hms.entity.Warden;
import com.cg.hms.repository.AdminDAO;
import com.cg.hms.repository.AllotmentDAO;
import com.cg.hms.repository.UserDAO;
import com.cg.hms.service.AdminService;


@SpringBootTest(classes=HostelManagementAppApplication.class)
public class AdminControllerTest {

	@Mock
	UserDAO userDAO;

	@Mock
	AdminService adminService;

	@Mock
	AdminDAO adminDAO;

	@Mock
	Allotment allotmentService;

	@Mock
	AllotmentDAO allotmentDAO;



	@Test
	void testAddWarden()  {
		Warden warden = new Warden();
		warden.setEmail("warden@gmail.com");
		warden.setWardenName("Warden1");
		adminService.addWarden(warden);

		verify(adminService, times(1)).addWarden(warden);
	}

	@Test
	void testUpdateWarden()  {
		Warden warden = new Warden();
		adminService.addWarden(warden);

		warden.setWardenName("Warden2");
		warden.setEmail("warden2@gmail.com");

		adminService.updateWarden(warden);

		verify(adminService, times(1)).addWarden(warden);
		verify(adminService, times(1)).updateWarden(warden);
	}

	@Test
	void testDeleteWarden()  {
		Warden warden = new Warden();
		adminService.addWarden(warden);

		adminService.deleteWarden(1l);

		verify(adminService, times(1)).addWarden(warden);
		verify(adminService, times(1)).deleteWarden(1l);

	}

	@Test
	void testFindByVisitorId()  {
		Warden warden  = adminService.getWardenById(1l);
		verify(adminService, times(1)).getWardenById(1l);
	}

	@Test
	void testSearch()  {
		Warden warden1 = new 	Warden();
		Warden warden2 = new 	Warden();
		Warden warden3 = new 	Warden();
		adminService.addWarden(warden1);
		adminService.addWarden(warden2);
		adminService.addWarden(warden3);

		List<Warden> wardenList = new ArrayList<Warden>();
		wardenList.add(warden1);
		wardenList.add(warden2);
		wardenList.add(warden3);

		when(adminService.getAllWardens()).thenReturn(wardenList);

		List<Warden> getWardenList = adminService.getAllWardens();
		verify(adminService, times(1)).getAllWardens();

		assertEquals(3, getWardenList.size());
	}

	@Test
	void testgetAllStudents()
	{
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

	@Test
	void testUpdateStudent()
	{
		Student student = new Student();
		adminService.addStudent(student);

		student.setStudent_Name("Abc");
		student.setEmail("Abc@gmail.com");

		adminService.updateStudent(student);

		verify(adminService, times(1)).addStudent(student);
		verify(adminService, times(1)).updateStudent(student);

	}

	@Test
	void testgetStudentById()
	{
		Student student = new Student();

		Student student1  = adminService.getStudentById(1L);

		verify(adminService, times(1)).getStudentById(1L);

	}

	@Test
	void testDeleteStudent()
	{
		Student student = new Student();
		adminService.addStudent(student);

		adminService.deleteStudent(1L);

		verify(adminService, times(1)).addStudent(student);
		verify(adminService, times(1)).deleteStudent(1L);

	}

	@Test
	void testAddAllotment()
	{
		Allotment allotment=new Allotment();
		Allotment allotment1=adminService.addAllotment(allotment);

		verify(adminService, times(1)).addAllotment(allotment);

	}

	@Test
	void testUpdateAllotment()
	{
		Allotment allotment = new Allotment();
		adminService.addAllotment(allotment);

		allotment.setRoomType("AC");
		allotment.setRoomNo("301");

		adminService.updateAllotment(allotment);

		verify(adminService, times(1)).addAllotment(allotment);
		verify(adminService, times(1)).updateAllotment(allotment);

	}

	@Test
	void testDeleteAllotment()
	{
		Allotment allotment = new Allotment();
		adminService.addAllotment(allotment);

		adminService.deleteAllotment(1L);

		verify(adminService, times(1)).addAllotment(allotment);
		verify(adminService, times(1)).deleteAllotment(1L);

	}

}
