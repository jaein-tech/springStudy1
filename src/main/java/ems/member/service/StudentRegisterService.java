package ems.member.service;

import ems.member.Student;
import ems.member.dao.StudentDAO;

public class StudentRegisterService {

	private StudentDAO studentDAO;
	
	public StudentRegisterService(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public boolean verify(String number) {
		Student student = studentDAO.select(number);
		return student == null ? true : false;
	}
	
	public void register(Student student) {
		if(verify(student.getnumber())) {
			studentDAO.insert(student);
		}else {
			System.out.println("The student has already registered.");
		}
	}
	
}
