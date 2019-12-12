package board.service.face;

import board.dto.Member;



public interface MemberService {
	
	// 로그인 처리
	public Boolean login(Member member);
	
	// 회원 아이디로 회원 코드 가져오기
	public int getMember_code(String loginid);
	
	// 회원가입
	public void join(Member member);
	
	// 로그인한 회원 데이터 가져오기
	public Member getMember(Member member);
	
	public boolean idCheck(String member_id);
}
