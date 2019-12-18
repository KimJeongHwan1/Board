package ojt.board.dto;

import java.util.Date;

public class BoardFileDto {

	int ojt_board_no ;
	int file_no ;
	String file_origin_name ;
	String file_stored_name ;
	
	public int getOjt_board_no() {
		return ojt_board_no;
	}
	public void setOjt_board_no(int ojt_board_no) {
		this.ojt_board_no = ojt_board_no;
	}
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
	
	@Override
	public String toString() {
		return "BoardFileDto [ojt_board_no=" + ojt_board_no + ", file_no=" + file_no + ", file_origin_name="
				+ file_origin_name + ", file_stored_name=" + file_stored_name + ", getOjt_board_no()="
				+ getOjt_board_no() + ", getFile_no()=" + getFile_no() + ", getFile_origin_name()="
				+ getFile_origin_name() + ", getFile_stored_name()=" + getFile_stored_name() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
