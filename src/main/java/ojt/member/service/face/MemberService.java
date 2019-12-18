package ojt.member.service.face;

import ojt.member.dto.MemberDto;



public interface MemberService {
	
	// 로그인 처리
	public Boolean login(MemberDto member);
	
	// 회원가입
	public void join(MemberDto member);
	
	// 로그인한 회원 데이터 가져오기
	public MemberDto getMember(MemberDto member);
	
	// 아이디 중복확인
	public boolean idCheck(String mem_id);
	
	// 회원 아이디로 회원 이름 가져오기
	public String getMember_name(String loginid);
	
}
