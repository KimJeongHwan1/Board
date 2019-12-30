package ojt.board.dto;

public class BoardRecommendDto {
	
	int ojt_board_no ;
	String mem_id ;
	

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
	@Override
	public String toString() {
		return "BoardRecommendDto [ ojt_board_no=" + ojt_board_no
				+ ", mem_id=" + mem_id + ", getOjt_board_no()=" + getOjt_board_no() + ", getMem_id()=" + getMem_id() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
