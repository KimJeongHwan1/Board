package ojt.board.dto;

import java.util.Date;

public class BoardFileDto {

	int file_no ;
	String file_origin_name ;
	String file_stored_name ;
	int ojt_board_no ;
	String mem_id ;
	String ojt_board_nick ;
	Date file_date ;
	String file_del_flug ;
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
	@Override
	public String toString() {
		return "BoardFileDto [file_no=" + file_no + ", file_origin_name=" + file_origin_name + ", file_stored_name="
				+ file_stored_name + ", ojt_board_no=" + ojt_board_no + ", mem_id=" + mem_id + ", ojt_board_nick="
				+ ojt_board_nick + ", file_date=" + file_date + ", file_del_flug=" + file_del_flug + ", getFile_no()="
				+ getFile_no() + ", getFile_origin_name()=" + getFile_origin_name() + ", getFile_stored_name()="
				+ getFile_stored_name() + ", getOjt_board_no()=" + getOjt_board_no() + ", getMem_id()=" + getMem_id()
				+ ", getOjt_board_nick()=" + getOjt_board_nick() + ", getFile_date()=" + getFile_date()
				+ ", getFile_del_flug()=" + getFile_del_flug() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
