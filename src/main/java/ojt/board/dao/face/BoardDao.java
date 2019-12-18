package ojt.board.dao.face;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ojt.board.dto.BoardDto;
import ojt.board.dto.BoardFileDto;
import ojt.board.util.Paging;

@Repository
public interface BoardDao {
	
	/**
	 * 테이블 전체 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블 전체 조회 결과
	 */
	public List selectAll( Paging paging ) ;
	
	/**
	 * 테이블 전체 COUNT 조회
	 * 
	 * @return 테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll( Map<String, Object> map ) ;
	
	/**
	 * 상세보기 게시글 조회 // 글쓰기 수정에 사용
	 * 
	 * @param viewBoard - 조회 대상
	 * @return Board - 게시글 조회 결과
	 */
	public BoardDto selectBoardByBoardno( BoardDto viewBoard ) ;
	
	// 회원이 게시글 작성했을 때
	public void userwrite( BoardDto boardDto ) ;

	// 비회원이 게시글 작성했을 떼
	public void nickwrite( BoardDto boardDto ) ;
	
	// 번호를 0으로 바꾸고 조건문을 걸어 게시글을 가림
	public void deleteList( int ojt_board_no ) ;
	
	// 게시글 수정
	public void update(BoardDto boardDto) ;
	
	// 조회수 증가
	public void updateHit( BoardDto viewBoard ) ;
	
	// 추천수 증가
	public void recommend( int ojt_board_no ) ;
	
	// 추천수 감소
	public void d_recommand( int ojt_board_no ) ;
	
	// 게시글 리스트 갯수 조정
	public void row( String row ) ;

	public void deleteBoardList(String names);
	
	public void insertFile( BoardFileDto boardFileDto ) ;
	
}
