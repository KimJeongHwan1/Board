package ojt.board.dto;

import java.util.Date;

public class BoardFileDto {

	int file_no ; // File idx
	String file_origin_name ; // 실제 파일명
	String file_stored_name ; // 업로드시 파일명
	int ojt_board_no ; // Board_no
	String mem_id ; // 회원 아이디
	String ojt_board_nick ; // 비회원 닉네임
	Date file_date ; // 파일첨부 Sysdate
	String file_del_flug ; // 파일 삭제 여부 Y/N
	int file_count ; // 파일생성시 1 삭제시 0
	
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getFile_origin_name() {
		return file_origin_name;
	}
	public void setFile_origin_name(String file_origin_name) {
		this.file_origin_name = file_origin_name;
	}
	public String getFile_stored_name() {
		return file_stored_name;
	}
	public void setFile_stored_name(String file_stored_name) {
		this.file_stored_name = file_stored_name;
	}
	public int getOjt_board_no() {
		return ojt_board_no;
	}
	public void setOjt_board_no(int ojt_board_no) {
		this.ojt_board_no = ojt_board_no;
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
	public Date getFile_date() {
		return file_date;
	}
	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}
	public String getFile_del_flug() {
		return file_del_flug;
	}
	public void setFile_del_flug(String file_del_flug) {
		this.file_del_flug = file_del_flug;
	}
	
	public int getFile_count() {
		return file_count;
	}
	public void setFile_count(int file_count) {
		this.file_count = file_count;
	}
	@Override
	public String toString() {
		return "BoardFileDto [file_no=" + file_no + ", file_origin_name=" + file_origin_name + ", file_stored_name="
				+ file_stored_name + ", ojt_board_no=" + ojt_board_no + ", mem_id=" + mem_id + ", ojt_board_nick="
				+ ojt_board_nick + ", file_date=" + file_date + ", file_del_flug=" + file_del_flug + ", file_count="
				+ file_count + "]";
	}
	
	
	
	
	
}
