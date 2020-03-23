package ems.member.service;

import java.util.Map;

import ems.member.Student;
import ems.member.dao.StudentDAO;

public class StudentAllSelectService {

	private StudentDAO studentDAO;
	
	public StudentAllSelectService(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public Map<String, Student> allSelect(){
		return studentDAO.getStudentDB();
	}
	
}
