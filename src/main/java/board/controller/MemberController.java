package board.controller;

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

import board.dto.Member;
import board.service.face.MemberService;

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
	
	// 메인 페이지 GET
	@RequestMapping(value="/board/main", method=RequestMethod.GET)
	public void main() {}
	
	// 로그인 GET
	@RequestMapping(value="/board/login", method=RequestMethod.GET)
	public void login() {}
	
	// 로그인 POST
	@RequestMapping(value="/board/login", method=RequestMethod.POST)
	public String login2(
			Member member, //로그인 정보 커맨드 객체
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
			session.setAttribute("id", member.getId());
			session.setAttribute("name", member.getName());
			session.setAttribute("admin", member.getAdmin());
			session.setMaxInactiveInterval(60 * 60);

			//리다이렉트 URL 지정
			redirectUrl = "/board/main";

		} else {
			//로그인 실패
			//리다이렉트 URL 지정
			redirectUrl = "/board/login";

		}

		return "redirect:" + redirectUrl;
	}
	
	// 로그아웃 GET
	@RequestMapping(value="/board/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:" + "/board/main";
	}

	// 회원가입 GET
	@RequestMapping(value="/board/join", method=RequestMethod.GET)
	public void join(Member member, Model model, HttpSession session) { 
		logger.info("회원가입 폼");	
	}
	
	// 회원가입 POST
	@RequestMapping(value = "/board/join", method = RequestMethod.POST)
	public String join2(Member member) {

		memberService.join(member);

		return "redirect:/board/login";
	}
		

}
