package ojt.board.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardDto {
	
	int ojt_board_no ; // 게시글 seq
	String ojt_board_category ; // 게시글 구분
	String ojt_board_title ; // 게시글 제목
	String ojt_board_content ; // 게시글 내용
	int ojt_board_recommend ; // 게시글 추천수
	int ojt_board_hit ; // 게시글 조회수
	Date ojt_board_last_date ; // 게시글 마지막 작성/수정 시간
	int ojt_board_block ; // 공개 비공개  0 / 1 ( Default 0 )
	int ojt_board_import ; // 일반 중요 0 / 1 ( Default 1 )
	String mem_id ; // 회원 아이디
	String ojt_board_nick ; // 비회원 닉네임
	String ojt_board_nick_pw ; // 비회원 작성 / 수정 비밀번호
	String ojt_board_del_plug ; // N / Y 로 구별하여 게시글 삭제 여부 확인 ( Default N )
	String last_date ; // String형 게시글 마지막 작성/수정 시간
	String mem_name ; // 회원 이름
	String file_stored_name ; // 업로드된 파일 이름
	int rnum ; // 게시글 번호
	int file_count ; // 파일이 존재하는지 유무
	
	public int getOjt_board_no() {
		return ojt_board_no;
	}
	public void setOjt_board_no(int ojt_board_no) {
		this.ojt_board_no = ojt_board_no;
	}
	public String getOjt_board_category() {
		return ojt_board_category;
	}
	public void setOjt_board_category(String ojt_board_category) {
		this.ojt_board_category = ojt_board_category;
	}
	public String getOjt_board_title() {
		return ojt_board_title;
	}
	public void setOjt_board_title(String ojt_board_title) {
		this.ojt_board_title = ojt_board_title;
	}
	public String getOjt_board_content() {
		return ojt_board_content;
	}
	public void setOjt_board_content(String ojt_board_content) {
		this.ojt_board_content = ojt_board_content;
	}
	public int getOjt_board_recommend() {
		return ojt_board_recommend;
	}
	public void setOjt_board_recommend(int ojt_board_recommend) {
		this.ojt_board_recommend = ojt_board_recommend;
	}
	public int getOjt_board_hit() {
		return ojt_board_hit;
	}
	public void setOjt_board_hit(int ojt_board_hit) {
		this.ojt_board_hit = ojt_board_hit;
	}
	public Date getOjt_board_last_date() {
		return ojt_board_last_date;
	}
	public void setOjt_board_last_date(Date ojt_board_last_date) {
		this.ojt_board_last_date = ojt_board_last_date;
	}
	public int getOjt_board_block() {
		return ojt_board_block;
	}
	public void setOjt_board_block(int ojt_board_block) {
		this.ojt_board_block = ojt_board_block;
	}
	public int getOjt_board_import() {
		return ojt_board_import;
	}
	public void setOjt_board_import(int ojt_board_import) {
		this.ojt_board_import = ojt_board_import;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getOjt_board_nick() {
		return ojt_board_nick;
	}
	public void setOjt_board_nick(String ojt_board_nick) {
		this.ojt_board_nick = ojt_board_nick;
	}
	public String getOjt_board_nick_pw() {
		return ojt_board_nick_pw;
	}
	public void setOjt_board_nick_pw(String ojt_board_nick_pw) {
		this.ojt_board_nick_pw = ojt_board_nick_pw;
	}
	public String getOjt_board_del_plug() {
		return ojt_board_del_plug;
	}
	public void setOjt_board_del_plug(String ojt_board_del_plug) {
		this.ojt_board_del_plug = ojt_board_del_plug;
	}
	public String getLast_date() {
		return last_date;
	}
	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getFile_stored_name() {
		return file_stored_name;
	}
	public void setFile_stored_name(String file_stored_name) {
		this.file_stored_name = file_stored_name;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getFile_count() {
		return file_count;
	}
	public void setFile_count(int file_count) {
		this.file_count = file_count;
	}
	@Override
	public String toString() {
		return "BoardDto [ojt_board_no=" + ojt_board_no + ", ojt_board_category=" + ojt_board_category
				+ ", ojt_board_title=" + ojt_board_title + ", ojt_board_content=" + ojt_board_content
				+ ", ojt_board_recommend=" + ojt_board_recommend + ", ojt_board_hit=" + ojt_board_hit
				+ ", ojt_board_last_date=" + ojt_board_last_date + ", ojt_board_block=" + ojt_board_block
				+ ", ojt_board_import=" + ojt_board_import + ", mem_id=" + mem_id + ", ojt_board_nick=" + ojt_board_nick
				+ ", ojt_board_nick_pw=" + ojt_board_nick_pw + ", ojt_board_del_plug=" + ojt_board_del_plug
				+ ", last_date=" + last_date + ", mem_name=" + mem_name + ", file_stored_name=" + file_stored_name
				+ ", rnum=" + rnum + ", file_count=" + file_count + ", getOjt_board_no()=" + getOjt_board_no()
				+ ", getOjt_board_category()=" + getOjt_board_category() + ", getOjt_board_title()="
				+ getOjt_board_title() + ", getOjt_board_content()=" + getOjt_board_content()
				+ ", getOjt_board_recommend()=" + getOjt_board_recommend() + ", getOjt_board_hit()="
				+ getOjt_board_hit() + ", getOjt_board_last_date()=" + getOjt_board_last_date()
				+ ", getOjt_board_block()=" + getOjt_board_block() + ", getOjt_board_import()=" + getOjt_board_import()
				+ ", getMem_id()=" + getMem_id() + ", getOjt_board_nick()=" + getOjt_board_nick()
				+ ", getOjt_board_nick_pw()=" + getOjt_board_nick_pw() + ", getOjt_board_del_plug()="
				+ getOjt_board_del_plug() + ", getLast_date()=" + getLast_date() + ", getMem_name()=" + getMem_name()
				+ ", getFile_stored_name()=" + getFile_stored_name() + ", getRnum()=" + getRnum() + ", getFile_count()="
				+ getFile_count() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
