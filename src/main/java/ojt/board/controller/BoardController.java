package ojt.board.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ojt.board.dto.BoardDto;
import ojt.board.dto.BoardFileDto;
import ojt.board.dto.BoardRecommendDto;
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
			
		@RequestParam(defaultValue="1") int curPage,
		Model model, BoardDto boardDto, HttpSession session
			,String row, HttpServletRequest req ) {
		
		// 세션에 등록된 정보불러오기
		String loginid = (String)session.getAttribute("id");
		
		model.addAttribute("loginid" , loginid ) ;
		logger.debug("BoardList Form");
		
		// 리스트 불러와서 페이징
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("curPage",curPage);

		Paging paging = boardService.getCurPage(map);
		
		model.addAttribute("paging",paging);		
				
		List list = boardService.getBoardList(paging);
		
		model.addAttribute("list", list);
		

	}
	
	// 상세보기 페이지 GET
	@RequestMapping(value = "/board/view.do", method = RequestMethod.GET)
	public void view( BoardDto viewBoard , Model model , HttpSession session , BoardRecommendDto boardRecommendDto,
			BoardFileDto boardFileDto) {
		// 세션에 등록된 정보불러오기
		String loginid = (String)session.getAttribute("id");
				
		model.addAttribute("loginid" , loginid ) ;
		viewBoard = boardService.selectView(viewBoard) ;
		logger.debug("viewBoard");
		model.addAttribute( "viewBoard" , viewBoard ) ;
		
		boardRecommendDto.setMem_id( loginid );
		
		int recCheck = boardService.RecCheck(boardRecommendDto);
		
		model.addAttribute( "recCheck" , recCheck) ;
		
		int recnum = boardService.saveRecCount(viewBoard.getOjt_board_no());
		
		model.addAttribute( "rec_no" , recnum ) ;
		
		List<BoardFileDto> list = new ArrayList<BoardFileDto>();
		list = (ArrayList<BoardFileDto>) boardService.selectFileView(boardFileDto);
		model.addAttribute("boardFileDto" , list );
		
		
	}
	
	// 글 쓰기 폼 GET
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET)
	public void write(MemberDto memberDto, Model model, HttpSession session , BoardDto boardDto) {
		// 세션에 등록된 정보불러오기
	      String loginid = (String)session.getAttribute("id");
	      if ( loginid != null ) {
	      boardDto.setMem_id(loginid);
	      logger.debug(boardDto.toString());
	      String name = memberService.getMember_name(loginid);
	      
	      model.addAttribute( "name" , name );
	}
		
	      
		
	}
	
	// 글 쓰기 폼 POST
	@RequestMapping(value = "/board/write.do", method = RequestMethod.POST)
	   public String writeProc(HttpSession session, BoardDto boardDto,
	         MultipartHttpServletRequest mreq, MemberDto memberDto, Model model, BoardFileDto boardFileDto){
	      logger.debug(boardDto.toString());
	      
	      // 세션에 등록된 정보불러오기
	      String loginid = (String)session.getAttribute("id");
	      if ( loginid != null ) {
	      boardDto.setMem_id(loginid);
	
	      String name = memberService.getMember_name(loginid);
	      boardDto.setMem_name(name);
	      
	      }
	      System.out.println( mreq );
	      if ( mreq == null || boardFileDto.getFile_origin_name() == "") {
	      boardService.insertwrite(boardDto);
	      } else {
	    	  if( loginid != null ) boardFileDto.setMem_id(loginid);
	    	  if( loginid == null ) boardFileDto.setOjt_board_nick(boardDto.getOjt_board_nick());
	    	  boardService.insertwrite(boardDto);
	    	  boardService.insertFile(context, boardFileDto, mreq);
	      }
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
		}

		boardService.update(boardDto);
		
		return "redirect:"+"/board/list.do";

	}

	@RequestMapping(value = "/board/listDelete.do", method = RequestMethod.POST)
	public String listDelete( String names , HttpServletRequest req) {
		names = req.getParameter("checkRow");
		System.out.println(names);
	
		if ( names != null && !names.equals("")) {
		boardService.boardListDelete(names);
		return "redirect:"+"/board/list.do";
		} else
		return null ;
		}
	
	@RequestMapping(value="/board/rec/recommend.do", method=RequestMethod.GET)
	public void recommend(int ojt_board_no, HttpSession session, Model model, BoardRecommendDto boardRecommendDto) {

		String mem_id= (String) session.getAttribute("id");

		boardService.saveRecId( mem_id, ojt_board_no);

		int rec_no = boardService.saveRecCount(ojt_board_no);


		model.addAttribute("rec_no", rec_no);

		boardRecommendDto.setOjt_board_no(ojt_board_no);
		boardRecommendDto.setMem_id(mem_id);

		int recCheck = boardService.RecCheck(boardRecommendDto);

		model.addAttribute("recCheck", recCheck);
		// return "/board/rec/recommend";
	}

	@RequestMapping(value="/board/rec/recBtn.do", method=RequestMethod.GET)
	public void recobtn(int ojt_board_no, HttpSession session, Model model, BoardRecommendDto boardRecommendDto) {
		String mem_id = (String) session.getAttribute("id");

		boardRecommendDto.setOjt_board_no(ojt_board_no);
		boardRecommendDto.setMem_id(mem_id);

		int recCheck = boardService.RecCheck(boardRecommendDto);

		model.addAttribute("recCheck", recCheck);

		// return "/board/rec/recBtn";
	}
	
}
