package ojt.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ojt.member.dto.MemberDto;
import ojt.member.service.face.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired MemberService memberService;
	@Autowired ServletContext context;
	
	
	
	// 로그인 GET
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public void login() {}
	
	// 로그인 POST
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String login2(
			MemberDto member, //로그인 정보 커맨드 객체
			HttpSession session//세션 객체
			) {
		logger.info("로그인 처리");
		logger.info(member.toString());

		String redirectUrl = null;
		if( memberService.login(member) ) {
			//로그인 성공

			//id 로 member 조회
			member = memberService.getMember(member);

			//세션 정보 저장
			session.setAttribute("login", true);
			session.setAttribute("id", member.getMem_id());
			session.setAttribute("name", member.getMem_name());
			session.setAttribute("admin", member.getMem_admin());
			session.setMaxInactiveInterval(60 * 60);

			//리다이렉트 URL 지정
			redirectUrl = "/main.do";

		} else {
			//로그인 실패
			//리다이렉트 URL 지정
			redirectUrl = "/member/login.do";

		}

		return "redirect:" + redirectUrl;
	}
	
	// 로그아웃 GET
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:" + "/main.do";
	}

	// 회원가입 GET
	@RequestMapping(value="/member/join.do", method=RequestMethod.GET)
	public void join(MemberDto member, Model model, HttpSession session) { 
		logger.info("회원가입 폼");	
	}
	
	// 회원가입 POST
	@RequestMapping(value = "/member/join.do", method = RequestMethod.POST)
	public String join2(MemberDto member) {

		memberService.join(member);

		return "redirect:/member/login.do";
	}
		
	@RequestMapping(value="/member/check/idCheck.do", method=RequestMethod.GET)
	public String idCheck(String mem_id, Model model) {

		logger.info("아이디 : "+ mem_id);
		int check = 0;
		if(mem_id.equals("")){
			check = 0;
		} else if(memberService.idCheck(mem_id)) {
			check = 0;
		} else {
			check = 1;
		}
		model.addAttribute("check", check);
		return "member/check/joincheck";
	}

	
}
