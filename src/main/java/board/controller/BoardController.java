package board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

import board.dto.Board;
import board.service.face.BoardService;
import board.util.Paging;


/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired BoardService boardService ;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public void list(
			
		@RequestParam(defaultValue="1") int curPage, Model model, Board board, HttpSession session) {
		
		logger.info("BoardList Form");
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("curPage",curPage);

		Paging paging = boardService.getCurPage(map);
		
		model.addAttribute("paging",paging);		
				
		List list = boardService.getBoardList(paging);
		
		model.addAttribute("list", list);
		
	}
		
	@RequestMapping(value = "/board/view", method = RequestMethod.GET)
	public void view( Board board , Model model , HttpSession session ) {

		board = boardService.view(board) ;
		
		model.addAttribute( "viewBoard" , board ) ;
		
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public void write( ) { }
}
	
