package ojt.board.dao.face;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ojt.board.dto.BoardDto;
import ojt.board.dto.BoardFileDto;
import ojt.board.dto.BoardRecommendDto;
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

	// 체크박스로 게시글 삭제
	public void deleteBoardList(String names);
	
	// 파일첨부 Insert
	public void insertFile( BoardFileDto boardFileDto ) ;
	
	// 게시글 번호로 닉네임 비밀번호 가져오기
	public String nick_pw( BoardDto boardDto ) ;
	
	// ID와 게시글 번호를 COUNT 매겨 추천 했는지 확인
	public int saveRecBlock( BoardRecommendDto boardRecommendDto ) ;
	
	// BOARD_NO로 총 추천수 확인
	public int saveRecCount( int ojt_board_no ) ;
	
	// 테이블에서 게시글번호와 ID를 합친 값을 지움
	public void deleteRec( BoardRecommendDto boardRecommendDto  ) ;
	
	// 테이블에서 게시글번호와 ID를 합친 값을 넣음
	public void saveRecId( BoardRecommendDto boardRecommendDto  ) ;
	
	// 추천수 + 1
	public void RecUp( int ojt_board_no ) ;
	
	// 추천수 - 1
	public void RecDown( int ojt_board_no ) ;
	
	// 파일 Del_flug를 'N'으로 바꿈
	public void deleteFile( int ojt_board_no ) ;
	
	// 수정페이지 첨부파일
	public void updateFile( BoardFileDto boardFileDto ) ;
	
	// 리스트로 삭제시 첨부파일 Y 처리
	public void deleteListFile( String names ) ;
	
	// 파일 리스트를 상세보기 페이지에 보여주는 리스트
	public List<BoardFileDto> selectNoFile( BoardFileDto boardFileDto ) ;
	
}
