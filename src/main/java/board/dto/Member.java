package board.dto;


public class Member {

	int code ; // 회원 비회원 관리
	String id ; // 회원 아이디
	String pw ; // 회원 비밀번호
	String name ; // 회원 이름
	int admin ; // 관리자 여부
	int pk ; // 회원 관리 seq를 위한 컬럼
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
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
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	@Override
	public String toString() {
		return "Member [code=" + code + ", id=" + id + ", pw=" + pw + ", name=" + name + ", admin=" + admin + ", pk="
				+ pk + "]";
	}
	
	
	
	
}
