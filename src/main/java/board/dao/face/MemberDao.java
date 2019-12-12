package board.dao.face;

import org.springframework.stereotype.Repository;

import board.dto.Member;


@Repository
public interface MemberDao {
	
	// 유저 아이디로 pk 조회
	public int getMember_codeDao(String id);
	
	// 가입
	public void member_insert(Member member);
	
	// 유저정보 조회
	public Member selectByMember(Member member);
	
	// 로그인 데이터와 일치하는 행 수를 조회
	public int selectCntLogin(Member member);
	
	// 회원가입시 아이디 중복 체크
	public int joinCheckid(String member_id);
	
}
