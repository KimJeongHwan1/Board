package ojt.member.service.face.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.board.dao.face.BoardDao;
import ojt.board.dto.BoardDto;
import ojt.member.dao.face.MemberDao;
import ojt.member.dto.MemberDto;
import ojt.member.service.face.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDao memberDao;
	
	// 회원가입
	@Override
	public void join(MemberDto member) {
		memberDao.member_insert(member);

	}

	// 로그인한 회원 데이터 가져오기
	@Override
	public MemberDto getMember(MemberDto member) {
		return memberDao.selectByMember(member);
	}

	// 로그인 처리
	@Override
	public Boolean login(MemberDto member) {
		if (memberDao.selectCntLogin(member)>0) {
			return true;
		}
		return false;
	}

	// 아이디 중복확인
	@Override
	public boolean idCheck(String mem_id) {
		
		if(memberDao.joinCheckid(mem_id)>0){
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

	
