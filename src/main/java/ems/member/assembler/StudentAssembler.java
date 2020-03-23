package ems.member.assembler;

import ems.member.dao.StudentDAO;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

public class StudentAssembler {

	// DAO객체를 선언하고 나머지 객체에 DAO를 하나씩 주입해준다.
	private StudentDAO studentDAO;
	private StudentRegisterService registerService;
	private StudentModifyService modifyService;
	private StudentDeleteService deleteService;
	private StudentSelectService selectService;
	private StudentAllSelectService allSelectService;
	
	public StudentAssembler() {
		studentDAO = new StudentDAO();
		registerService = new StudentRegisterService(studentDAO);
		modifyService = new StudentModifyService(studentDAO);
		deleteService = new StudentDeleteService(studentDAO);
		selectService = new StudentSelectService(studentDAO);
		allSelectService = new StudentAllSelectService(studentDAO);
	}
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public StudentRegisterService getRegisterService() {
		return registerService;
	}
	
	public void setRegisterService(StudentRegisterService registerService) {
		this.registerService = registerService;
	}
	
	public StudentModifyService getModifyService() {
		return modifyService;
	}
	
	public void setModifyService(StudentModifyService modifyService) {
		this.modifyService = modifyService;
	}
	
	public StudentDeleteService getDeleteService() {
		return deleteService;
	}
	
	public void setDeleteService(StudentDeleteService deleteService) {
		this.deleteService = deleteService;
	}
	
	public StudentSelectService getSelectService() {
		return selectService;
	}
	
	public void setSelectService(StudentSelectService selectService) {
		this.selectService = selectService;
	}
	
	public StudentAllSelectService getAllSelectService() {
		return allSelectService;
	}
	
	public void setAllSelectService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	
}
