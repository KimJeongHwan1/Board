package board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.face.MemberDao;
import board.dto.Member;
import board.service.face.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDao memberDao;
	
	// 회원가입
	@Override
	public void join(Member member) {
		memberDao.member_insert(member);

	}
	
	// 회원 아이디로 회원 코드 가져오기
	@Override
	public int getMember_code(String loginid) {
		return memberDao.getMember_codeDao(loginid);
	}

	// 로그인한 회원 데이터 가져오기
	@Override
	public Member getMember(Member member) {
		return memberDao.selectByMember(member);
	}

	// 로그인 처리
	@Override
	public Boolean login(Member member) {
		if (memberDao.selectCntLogin(member)>0) {
			return true;
		}
		return false;
	}

	// 아이디 중복확인
	@Override
	public boolean idCheck(String member_id) {
		
		if(memberDao.joinCheckid(member_id)>0){
			return true;
		}
		return false;
	}

	// 회원 아이디로 회원 이름 가져오기
	@Override
	public String getMember_name(String loginid) {
		return memberDao.getMember_name(loginid) ;
	}

}

	
