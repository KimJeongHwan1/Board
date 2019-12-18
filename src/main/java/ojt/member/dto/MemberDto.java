package ojt.member.dto;


public class MemberDto {

	String mem_id ; // 회원 아이디 PK
	String mem_name ; // 회원 이름
	String mem_pw ; // 회원 비밀번호
	int mem_admin ; // 회원 관리자 여부
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public int getMem_admin() {
		return mem_admin;
	}
	public void setMem_admin(int mem_admin) {
		this.mem_admin = mem_admin;
	}
	@Override
	public String toString() {
		return "Member [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_pw=" + mem_pw + ", mem_admin=" + mem_admin
				+ "]";
	}
	
	
	
}
