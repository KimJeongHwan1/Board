package ojt.member.dao.face;

import org.springframework.stereotype.Repository;

import ojt.board.dto.BoardDto;
import ojt.member.dto.MemberDto;


@Repository
public interface MemberDao {
	
	// 유저 아이디로 Name 조회
	public String getMember_name(String mem_id);
	
	// 회원 가입
	public void member_insert(MemberDto member);
	
	// 유저정보 조회
	public MemberDto selectByMember(MemberDto member);
	
	// 로그인 데이터와 일치하는 행 수를 조회 
	public int selectCntLogin(MemberDto member);
	
	// 회원가입시 아이디 중복 체크
	public int joinCheckid(String mem_id);
	
	
}
