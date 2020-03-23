package ems.member.service;

import ems.member.Student;
import ems.member.dao.StudentDAO;

public class StudentDeleteService {
	
	private StudentDAO studentDAO;
	
	public StudentDeleteService(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public boolean verify(String number) {
		Student student = studentDAO.select(number);
		return student != null ? true : false;
	}
	
	public void delete(Student student) {
		if(verify(student.getnumber())) {
			studentDAO.delete(student.getnumber());
		}else {
			System.out.println("Student information is not available.");
		}
	}
	
}
