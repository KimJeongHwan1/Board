package board.dao.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.dto.Board;
import board.util.Paging;

@Repository
public interface BoardDao {
	
	/**
	 * 테이블 전체 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블 전체 조회 결과
	 */
	public List selectAll(Paging paging);
	
	/**
	 * 테이블 전체 COUNT 조회
	 * 
	 * @return 테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll(Map<String, Object> map) ;
	
	/**
	 * 상세보기 게시글 조회
	 * 
	 * @param viewBoard - 조회 대상
	 * @return Board - 게시글 조회 결과
	 */
	public Board selectBoardByBoardno(Board board );
	
	// 회원이 게시글 작성했을 때
	public void userwrite( Board board ) ;

	// 비회원이 게시글 작성했을 떼
	public void nickwrite( Board board ) ;
	
	// 번호를 0으로 바꾸고 조건문을 걸어 게시글을 가림
	public void deleteList( int no ) ;
}
