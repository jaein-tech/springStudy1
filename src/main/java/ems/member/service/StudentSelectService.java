package ems.member.service;

import ems.member.Student;
import ems.member.dao.StudentDAO;

public class StudentSelectService {

	private StudentDAO studentDAO;
	
	public StudentSelectService(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public boolean verify(String number) {
		Student student = studentDAO.select(number);
		return student != null ? true : false;
	}
	
	public Student select(String number) {
		if(verify(number)) {
			return studentDAO.select(number);
		}else {
			System.out.println("Student information is not available");
		}
		
		return null;
	}
	
}
