package board.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.dto.Board;
import board.util.Paging;


public interface BoardService {
	
	/**
	 * 게시글 리스트 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 게시글을 조회한 결과
	 */
	public List getBoardList( Paging paging ) ;
	
	public Paging getCurPage(Map<String,Object> map);

	// 게시글 상세보기
	public Board view(Board board);

	// 게시글 작성
	public void insertwrite(Board board) ;
	
	//public void imgsave(ServletContext context, Board board , MultipartHttpServletRequest mtfRequest) ;
	
	// 게시글 삭제 ( delete 컬럼을 0으로 바꿈 )
	public void deleteList(int no) ;
}
