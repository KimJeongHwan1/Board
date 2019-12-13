package board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.dto.Board;
import board.dto.Member;
import board.service.face.BoardService;
import board.service.face.MemberService;
import board.util.Paging;



/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired BoardService boardService ;
	@Autowired MemberService memberService ;
	@Autowired ServletContext context;
	
	// 리스트 페이지 GET
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public void list(
			
		@RequestParam(defaultValue="1") int curPage, Model model, Board board, HttpSession session) {
		
		logger.info("BoardList Form");
		
		// 리스트 불러와서 페이징
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("curPage",curPage);

		Paging paging = boardService.getCurPage(map);
		
		model.addAttribute("paging",paging);		
				
		List list = boardService.getBoardList(paging);
		
		model.addAttribute("list", list);
	}
	
	// 상세보기 페이지 GET
	@RequestMapping(value = "/board/view", method = RequestMethod.GET)
	public void view( Board board , Model model , HttpSession session ) {

		board = boardService.view(board) ;
		
		model.addAttribute( "viewBoard" , board ) ;
		
	}
	
	// 글 쓰기 폼 GET
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public void write(Member member, Model model, HttpSession session) {
		
		String loginid = (String)session.getAttribute("loginid");
		
	}
	
	// 글 쓰기 폼 POST
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	   public String writeProc(HttpSession session, Board board,
	         MultipartHttpServletRequest mtfRequest, Member member, Model model){
	      logger.info(board.toString());
	      
	      // 세션에 등록된 정보불러오기
	      String loginid = (String)session.getAttribute("id");
	      if ( loginid != null ) {
	      board.setId(loginid);
	  
	      int code = memberService.getMember_code(loginid);
	      board.setCode(code);
	      
	      String name = memberService.getMember_name(loginid);
	      board.setName(name);
	      
	      }
	     // if(mtfRequest == null) {
	        boardService.insertwrite(board);
	    //  } else {
	     //    boardService.imgsave(context, board, mtfRequest);
	    //  }
	         
	      return "redirect:"+"/board/list";
	   }
	
	// 게시글 삭제 GET
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String deleteList(HttpSession session , int no) {
		
		boardService.deleteList(no);
		
		return "redirect:/board/list" ;
		
	}
	
}
