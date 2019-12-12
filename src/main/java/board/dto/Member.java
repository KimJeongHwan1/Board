package board.dto;


public class Member {

	int code ;
	String id ;
	String pw ;
	String name ;
	int admin ;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Member [code=" + code + ", id=" + id + ", pw=" + pw + ", name=" + name + ", admin=" + admin + "]";
	}
	
	
}
