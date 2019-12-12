package board.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.face.BoardDao;
import board.dto.Board;
import board.service.face.BoardService;
import board.util.Paging;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDao boardDao ;

	@Override
	public Paging getCurPage(Map<String, Object> map) {

		int totalCount = boardDao.selectCntAll(map);
		int curPage = Integer.parseInt(  map.get("curPage").toString());
		
		Paging paging = new Paging(totalCount,curPage);
		
		return paging;
	}
	
	@Override
	public List getBoardList(Paging paging) {
		
		return boardDao.selectAll(paging);
	}

	@Override
	public Board view(Board board) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardByBoardno(board) ;
		
	}




	}

	
