package ems.member.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDAO;
import ems.member.service.EMSInformationService;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

@Configuration
public class MemberConfig {

	@Bean
	public StudentDAO studentDAO() {
		return new StudentDAO();
	}
	
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDAO());
	}
	
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDAO());
	}
	
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDAO());
	}
	
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDAO());
	}
	
	@Bean 
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDAO());
	}
	
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
		DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
		infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		infoDev.setUserId("aaa");
		infoDev.setUserPw("bbb");
		
		return infoDev;
	}
	
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
		DataBaseConnectionInfo infoReal = new DataBaseConnectionInfo();
		infoReal.setJdbcUrl("jdbc:oracle:thin:@111.222.3.4:5555:xe");
		infoReal.setUserId("ccc");
		infoReal.setUserPw("ddd");
		
		return infoReal;
	}
	
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService info = new EMSInformationService();
		info.setInfo("Practice program in 2020");
		info.setCopyRight("COPYRIGHT lalala");
		info.setVer("1.0 Version");
		info.setsYear(2020);
		info.setsMonth(3);
		info.setsDay(20);
		info.seteYear(2020);
		info.seteMonth(3);
		info.seteDay(21);
		
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("Joo");
		developers.add("Jae");
		developers.add("In");
		info.setDevelopers(developers);
		
		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("Jaein", "jaein@g.com");
		administrators.put("Joojaein", "joojaein@a.com");
		info.setAdministrators(administrators);
		
		Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<String, DataBaseConnectionInfo>();
		dbInfos.put("dev", dataBaseConnectionInfoDev());
		dbInfos.put("real", dataBaseConnectionInfoReal());
		info.setDbInfos(dbInfos);
		
		return info;
	}

}
