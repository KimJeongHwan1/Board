package ojt.board.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
			, HttpServletRequest req ) {
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
	         MultipartHttpServletRequest mreq, MemberDto memberDto, Model model, BoardFileDto boardFileDto,
	         HttpServletRequest req){
	      logger.debug(boardDto.toString());
	      
	      // 세션에 등록된 정보불러오기
	      String loginid = (String)session.getAttribute("id");
	      if ( loginid != null ) {
	      boardDto.setMem_id(loginid);
	
	      String name = memberService.getMember_name(loginid);
	      boardDto.setMem_name(name);
	      }
	      
	      
	     if( loginid != null ) boardFileDto.setMem_id(loginid);
	     if( loginid == null ) boardFileDto.setOjt_board_nick(boardDto.getOjt_board_nick());
	     boardService.insertwrite(boardDto);  
	     boardService.insertFile(context, boardFileDto, mreq);
	    	  
	      return "redirect:"+"/board/list.do";
	   }
	
	// 게시글 삭제 GET
	@RequestMapping(value = "/board/delete.do", method = RequestMethod.GET)
	public String deleteList(HttpSession session , int ojt_board_no) {
		
		boardService.deleteList(ojt_board_no);
		 
		return "redirect:/board/list.do" ;
		
	}
	
	@RequestMapping(value = "/board/update.do", method = RequestMethod.GET)
	public void update(HttpSession session, Model model, BoardDto viewBoard, int ojt_board_no , BoardFileDto boardFileDto) {
		BoardDto BoardDto = boardService.selectView(viewBoard);
		model.addAttribute("viewBoard", BoardDto);
		
		List<BoardFileDto> list = new ArrayList<BoardFileDto>();
		list = (ArrayList<BoardFileDto>) boardService.selectFileView(boardFileDto);
		model.addAttribute("file" , list );
	}
	
	@RequestMapping(value = "/board/update.do", method = RequestMethod.POST)
	public String update2(HttpSession session, BoardDto boardDto,
			MultipartHttpServletRequest mreq, MemberDto memberDto, Model model , BoardFileDto boardFileDto
			, int ojt_board_no ) {
		// 세션에 등록된 정보불러오기
		String loginid = (String)session.getAttribute("id");
		
		if ( loginid != null ) {
			boardDto.setMem_id(loginid);
			boardFileDto.setMem_id(loginid);
		}
		if ( loginid == null ) {
			boardFileDto.setOjt_board_nick(boardDto.getOjt_board_nick());
		}
		boardFileDto.setOjt_board_no(ojt_board_no);
		boardService.update(boardDto);
		boardService.upFile(context, boardFileDto, mreq);
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
	
	@RequestMapping(value = "/board/upDelFile.do", method = RequestMethod.POST)
	public String upDelFile( String names , HttpServletRequest req) {
		names = req.getParameter("checkRow");
		System.out.println(names);
	
		if ( names != null && !names.equals("")) {
		boardService.upDelFile(names);
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
	
	@RequestMapping(value="/board/down/file.do", method=RequestMethod.GET)
	public void down( HttpServletResponse res , BoardFileDto boardFileDto ,HttpServletRequest req , int file_no) {
		
		boardFileDto = boardService.selectFile(file_no);
		String orgName = boardFileDto.getFile_origin_name();
		String newName = boardFileDto.getFile_stored_name();
		SimpleDateFormat sysdate = new SimpleDateFormat( "yyyyMMdd" );
		Date time = new Date();
		
		String time1 = sysdate.format(time);
		
		res.setContentType("application/octet-stream");
		
		
		// 파일명 지정
		try {
			res.setHeader("Content-Disposition", "attachment; filename=\""+time1+"_"+URLEncoder.encode(orgName , "UTF-8")+"\"");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println( orgName );
		System.out.println( newName );
		// 경로지정
		String path = "C:\\Users\\jeong\\Documents\\workspace-sts-3.9.10.RELEASE\\Board\\src\\main\\webapp\\upload";
		
		try {
			orgName = new String( orgName.getBytes("UTF-8"), "iso-8859-1");
			OutputStream os = res.getOutputStream();
			FileInputStream fis = new FileInputStream( path + File.separator + newName ) ;
			
			int n = 0;
	        byte[] b = new byte[512];
	        while((n = fis.read(b)) != -1 ) {
	            os.write(b, 0, n);
	        }
	        
	        fis.close();
	        os.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 리스트 비공개 글 비밀번호 입력받는 페이지
	@RequestMapping(value = "/board/pwListCheck.do", method=RequestMethod.GET)
	public void list_pw_check(BoardDto viewBoard , Model model ) {
		viewBoard = boardService.selectView(viewBoard) ;
		logger.debug("viewBoard");
		model.addAttribute( "viewBoard" , viewBoard ) ;		
	}
	
	@RequestMapping(value = "/board/pwListCheck.do", method=RequestMethod.POST)
	public String list_pw_check2(BoardDto viewBoard,HttpServletRequest req) {
		viewBoard = boardService.selectView(viewBoard) ;
		logger.debug("viewBoard");
		int board_no = viewBoard.getOjt_board_no();
		String nick_pw = boardService.nick_pw(viewBoard);
		String pw_check = req.getParameter("ojt_board_nick_pw");
		
		System.out.println(board_no +'|'+ nick_pw+'|'+pw_check);
		
		if ( nick_pw.equals(pw_check) ) {
			return "redirect:"+"/board/view.do?ojt_board_no="+board_no;
		} else {
			return "redirect:"+"/board/list.do" ;
		}
	}
	
	// 뷰 비공개 글 비밀번호 입력받는 페이지
	@RequestMapping(value = "/board/pwViewCheck.do", method=RequestMethod.GET)
	public void view_pw_check(BoardDto viewBoard , Model model ) {
		viewBoard = boardService.selectView(viewBoard) ;
		logger.debug("viewBoard");
		model.addAttribute( "viewBoard" , viewBoard ) ;		
	}
	
	@RequestMapping(value = "/board/pwViewCheck.do", method=RequestMethod.POST)
	public String view_pw_check2(BoardDto viewBoard,HttpServletRequest req) {
		viewBoard = boardService.selectView(viewBoard) ;
		logger.debug("viewBoard");
		int board_no = viewBoard.getOjt_board_no();
		String nick_pw = boardService.nick_pw(viewBoard);
		String pw_check = req.getParameter("ojt_board_nick_pw");
		
		System.out.println(board_no +'|'+ nick_pw+'|'+pw_check);
		
		if ( nick_pw.equals(pw_check) ) {
			return "redirect:"+"/board/update.do?ojt_board_no="+board_no;
		} else {
			return "redirect:"+"/board/list.do" ;
		}
	}
	
	// 뷰 비공개 글 비밀번호 입력받는 페이지
	@RequestMapping(value = "/board/pwDelCheck.do", method=RequestMethod.GET)
	public void del_pw_check(BoardDto viewBoard , Model model ) {
		viewBoard = boardService.selectView(viewBoard) ;
		logger.debug("viewBoard");
		model.addAttribute( "viewBoard" , viewBoard ) ;		
	}

	@RequestMapping(value = "/board/pwDelCheck.do", method=RequestMethod.POST)
	public String del_pw_check2(BoardDto viewBoard,HttpServletRequest req) {
		viewBoard = boardService.selectView(viewBoard) ;
		logger.debug("viewBoard");
		int board_no = viewBoard.getOjt_board_no();
		String nick_pw = boardService.nick_pw(viewBoard);
		String pw_check = req.getParameter("ojt_board_nick_pw");

		System.out.println(board_no +'|'+ nick_pw+'|'+pw_check);

		if ( nick_pw.equals(pw_check) ) {
			return "redirect:"+"/board/delete.do?ojt_board_no="+board_no;
		} else {
			return "redirect:"+"/board/update.do?ojt_board_no="+board_no;
		}
	}
		
	/* 상세보기 수정 버튼 클릭시 띄울것
	 * @RequestMapping(value="/board/check/pw.do", method =
	 * {RequestMethod.POST,RequestMethod.GET}) public String
	 * pw_check(HttpServletRequest req , BoardDto boardDto ) { int board_no =
	 * Integer.parseInt(req.getParameter("no")); boardDto.setOjt_board_no(board_no);
	 * String pw = boardService.nick_pw(boardDto); String pw_check =
	 * req.getParameter("check"); System.out.println( "board_no : " + board_no);
	 * System.out.println( "pw : " + pw); System.out.println( "pw_check : " +
	 * pw_check);
	 * 
	 * if (pw.equals(pw_check)) { return
	 * "redirect:"+"/board/view.do?ojt_board_no="+board_no; } else { return
	 * "redirect:"+"/board/list.do" ; } }
	 */
	
}
