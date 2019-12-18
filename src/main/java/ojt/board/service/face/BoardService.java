package ojt.board.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ojt.board.dto.BoardDto;
import ojt.board.dto.BoardFileDto;
import ojt.board.util.Paging;


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
	public BoardDto selectView(BoardDto viewBoard);

	// 게시글 작성
	public void insertwrite(BoardDto boardDto) ;
	
	//public void imgsave(ServletContext context, Board board , MultipartHttpServletRequest mtfRequest) ;
	
	// 게시글 삭제 ( delete 컬럼을 0으로 바꿈 )
	public void deleteList(int ojt_board_no) ;
	
	// 게시글 수정
	public void update( BoardDto boardDto ) ;
	
	// 추천수 + 1
	public void recommend(int ojt_board_no);
	
	// 추천수 - 1
	public void d_recommend(int ojt_board_no);
	
	// 리스트 게시글 수
	public void row( String row ) ;
	
	// 리스트 삭제
	public void boardListDelete(String names);
	
	// 파잁첨부
	public void insertFile(ServletContext context , BoardFileDto boardFileDto , MultipartHttpServletRequest req ) ;
	
}
