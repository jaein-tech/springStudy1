package ems.member;

public class Student {

	private String number;
	private String id;
	private String pw;
	private String name;
	private int ages;
	private String gender;
	private String hobby;
	
	public Student(String number, String id, String pw, String name,
			int ages, String gender, String hobby) {
		this.number = number;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.ages = ages;
		this.gender = gender;
		this.hobby = hobby;
	};
	
	public String getnumber() {
		return number;
	}
	
	public void setnumber(String number) {
		this.number = number;
	}
	
	public String getid() {
		return id;
	}
	
	public void setid(String id) {
		this.id = id;
	}
	
	public String getpw() {
		return pw;
	}
	
	public void setpw(String pw) {
		this.pw = pw;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public int getages() {
		return ages;
	}
	
	public void setages(int ages) {
		this.ages = ages;
	}
	
	public String getgender() {
		return gender;
	}
	
	public void setgender(String gender) {
		this.gender = gender;
	}
	
	public String gethobby() {
		return hobby;
	}
	
	public void sethobby(String hobby) {
		this.hobby = hobby;
	}
	
}
