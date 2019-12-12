package board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.face.MemberDao;
import board.dto.Member;
import board.service.face.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDao memberDao;
	
	@Override
	public void join(Member member) {
		memberDao.member_insert(member);

	}

	@Override
	public int getMember_code(String loginid) {
		return memberDao.getMember_codeDao(loginid);
	}

	@Override
	public Member getMember(Member member) {
		return memberDao.selectByMember(member);
	}

	@Override
	public Boolean login(Member member) {
		if (memberDao.selectCntLogin(member)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean idCheck(String member_id) {
		
		if(memberDao.joinCheckid(member_id)>0){
			return true;
		}
		return false;
	}

}

	
