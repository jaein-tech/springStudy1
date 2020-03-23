package ems.member.dao;

import java.util.HashMap;
import java.util.Map;

import ems.member.Student;

public class StudentDAO {
	
	// 데이터베이스를 사용하지 않기 때문에 맵이라는 자료형을 사용해서 데이터를 쌓아 놓는다.
	private Map<String, Student> studentDB = new HashMap<String, Student>();
	
	public void insert(Student student) {
		studentDB.put(student.getnumber(), student);
	}
	
	public Student select(String number) {
		return studentDB.get(number);
	}
	
	public void update(Student student) {
		studentDB.put(student.getnumber(), student);
	}
	
	public void delete(String number) {
		studentDB.remove(number);
	}
	
	public Map<String, Student> getStudentDB(){
		return studentDB;
	}
	
}
