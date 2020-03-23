package ems.member.main;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import ems.member.Student;
import ems.member.assembler.StudentAssembler;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

public class MainClass {

	public static void main(String[] args) {
		// 데이터 베이스를 사용하지 않았기 때문에 배열로 임시로 데이터 관리
		String[] number = {
				"3S01", "3S02", "3S03", "3S04",
				"3S05", "3S06", "3S07", "3S08",
				"3S09", "3S10"
		};
		String[] id = {
				"puppy", "tiger", "horse", "pig", "cat", 
				"duck", "rion", "bird", "snake", "rabbit"
		};
		String[] pw = {
				"3121", "5218", "6531", "5893", "8883",
				"5441", "8723", "1235", "2561", "8712"
		};
		String[] name = {
				"lee", "joo", "park", "shin", "oh", 
				"kim", "kang", "han", "na","jang"
		};
		int[] ages = {
				15, 16, 17, 16, 15, 14, 14, 15, 15, 16
		};
		String[] gender = {
				"Man", "Woman", "Woman", "Woman", "Man", 
				"Woman", "Man", "Woman", "Man", "Woman",
		};
		String[] hobby = {
				"swim", "running", "movie", "soccer", "baseball", 
				"golf", "read", "game", "programming", "cooking" 
		};
		
		// assembler에서 객체를 선언해줄때마다 DAO객체를 각각 하나씩 주입해준다. -- Dependency Injection
		StudentAssembler assembler = new StudentAssembler();
		
		StudentRegisterService registerService = assembler.getRegisterService();
		for(int j = 0; j < number.length; j++) {
			Student student = new Student(
					number[j], id[j], pw[j], name[j], ages[j], gender[j], hobby[j]
			);
			registerService.register(student);
		}
		
		StudentModifyService modifyService = assembler.getModifyService();
		modifyService.modify(new Student("Student Number", "Student ID", "Student Password", 
				"Student Name", 00, "Student Gender", "Student Hobbies"));
		
		StudentSelectService selectService = assembler.getSelectService();
		Student modifiedStudent = selectService.select("3S01");
		System.out.println("Number:" + modifiedStudent.getnumber() + "\t");
		System.out.println("|ID:" + modifiedStudent.getid() + "\t");
		System.out.println("|PW:" + modifiedStudent.getpw() + "\t");
		System.out.println("|Name:" + modifiedStudent.getname() + "\t");
		System.out.println("|Ages:" + modifiedStudent.getages() + "\t");
		System.out.println("|Gender:" + modifiedStudent.getgender() + "\t");
		System.out.println("|Hobby:" + modifiedStudent.gethobby() + "\n\n");
		
		StudentAllSelectService allSelectService = assembler.getAllSelectService();
		Map<String, Student> allStudent = allSelectService.allSelect();
		Set<String> keys = allStudent.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.println("Number:" + student.getnumber() + "\t");
			System.out.println("|ID:" + student.getid() + "\t");
			System.out.println("|PW:" + student.getpw() + "\t");
			System.out.println("|Name:" + student.getname() + "\t");
			System.out.println("|Ages:" + student.getages() + "\t");
			System.out.println("|Gender:" + student.getgender() + "\t");
			System.out.println("|Hobby:" + student.gethobby() + "\t");
		}
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String str = "";
			
			System.out.println("\n====================================================================================="
					+"=================================================================================================");
			System.out.println("1. Check Studetn Information");
			System.out.println("2. Exit");
			
			str = scanner.next();
			if(str.equals("2")) {
				System.out.println("Exit");
				break;
			}else {
				System.out.println("Please input your student number.");
				
				str = scanner.next();
				Student student = selectService.select(str);
				System.out.println("Number:" + student.getnumber() + "\t");
				System.out.println("|ID:" + student.getid() + "\t");
				System.out.println("|PW:" + student.getpw() + "\t");
				System.out.println("|Name:" + student.getname() + "\t");
				System.out.println("|Ages:" + student.getages() + "\t");
				System.out.println("|Gender:" + student.getgender() + "\t");
				System.out.println("|Hobby:" + student.gethobby() + "\t");
				
			}
			
		}
		
	}
		
}
