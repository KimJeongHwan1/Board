package ojt.board.controller;


import java.util.HashMap;
import java.util.List;
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

import ojt.board.dto.BoardDto;
import ojt.board.service.face.BoardService;
import ojt.board.util.Paging;
import ojt.member.dto.MemberDto;
import ojt.member.service.face.MemberService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired BoardService boardService ;
	@Autowired MemberService memberService ;
	@Autowired ServletContext context;
	
	// 메인 페이지 GET
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public void main() {}
		
	// 리스트 페이지 GET
	@RequestMapping(value = "/board/list.do", method = {RequestMethod.POST,RequestMethod.GET})
	public void list(
			
		@RequestParam(defaultValue="1") int curPage, Model model, BoardDto boardDto, HttpSession session
			,String row) {
		
		logger.info("BoardList Form");
		
		// 리스트 불러와서 페이징
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("curPage",curPage);

		Paging paging = boardService.getCurPage(map);
		
		model.addAttribute("paging",paging);		
				
		List list = boardService.getBoardList(paging);
		
		model.addAttribute("list", list);
		
		boardService.row(row);
		
	}
	
	// 상세보기 페이지 GET
	@RequestMapping(value = "/board/view.do", method = RequestMethod.GET)
	public void view( BoardDto viewBoard , Model model , HttpSession session ) {

		viewBoard = boardService.selectView(viewBoard) ;
		
		model.addAttribute( "viewBoard" , viewBoard ) ;
		
	}
	
	// 글 쓰기 폼 GET
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET)
	public void write(MemberDto memberDto, Model model, HttpSession session , BoardDto boardDto) {
		// 세션에 등록된 정보불러오기
	      String loginid = (String)session.getAttribute("id");
	      if ( loginid != null ) {
	      boardDto.setMem_id(loginid);
	
	      String name = memberService.getMember_name(loginid);
	      
	      model.addAttribute( "name" , name );
	}
		
	      
		
	}
	
	// 글 쓰기 폼 POST
	@RequestMapping(value = "/board/write.do", method = RequestMethod.POST)
	   public String writeProc(HttpSession session, BoardDto boardDto,
	         MultipartHttpServletRequest mtfRequest, MemberDto memberDto, Model model){
	      logger.info(boardDto.toString());
	      
	      // 세션에 등록된 정보불러오기
	      String loginid = (String)session.getAttribute("id");
	      if ( loginid != null ) {
	      boardDto.setMem_id(loginid);
	
	      String name = memberService.getMember_name(loginid);
	     // [[ -- 회원 이름 가져오기 -- ]]
	      
	      }
	     // if(mtfRequest == null) {
	        boardService.insertwrite(boardDto);
	    //  } else {
	     //    boardService.imgsave(context, board, mtfRequest);
	    //  }
	         
	      return "redirect:"+"/board/list.do";
	   }
	
	// 게시글 삭제 GET
	@RequestMapping(value = "/board/delete.do", method = RequestMethod.GET)
	public String deleteList(HttpSession session , int ojt_board_no) {
		
		boardService.deleteList(ojt_board_no);
		
		return "redirect:/board/list.do" ;
		
	}
	
	@RequestMapping(value = "/board/update.do", method = RequestMethod.GET)
	public void update(HttpSession session, Model model, BoardDto viewBoard, int ojt_board_no) {
		BoardDto BoardDto = boardService.selectView(viewBoard);
		model.addAttribute("viewBoard", BoardDto);
	}
	
	@RequestMapping(value = "/board/update.do", method = RequestMethod.POST)
	public String update2(HttpSession session, BoardDto boardDto,
			MultipartHttpServletRequest mtfRequest, MemberDto memberDto, Model model) {
		// 세션에 등록된 정보불러오기
		String loginid = (String)session.getAttribute("id");
		if ( loginid != null ) {
			boardDto.setMem_id(loginid);

			String name = memberService.getMember_name(loginid);
		}

		boardService.update(boardDto);

		return "redirect:"+"/board/list.do";

	}

	@RequestMapping(value = "/board/listDelete.do", method = RequestMethod.POST)
	public String listDelete( String name , HttpServletRequest req) {
		String names = req.getParameter( "names" ) ;
		
		if( !"".equals(names) && names != null) {
			boardService.boardListDelete(names);
		}
		return "sednRedirect"+"/board/list.do";
	}
	
	@RequestMapping(value = "/board/recommend.do")
	public String recommend(int ojt_board_no) {
		return "forward:/board/view.do";
	}
	

	
}
