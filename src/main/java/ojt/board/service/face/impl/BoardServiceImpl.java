package ojt.board.service.face.impl;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ojt.board.dto.BoardDto;
import ojt.board.dto.BoardFileDto;
import ojt.board.service.face.BoardService;
import ojt.board.util.Paging;
import ojt.board.dao.face.BoardDao;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDao boardDao ;
	
	
	@Override
	public Paging getCurPage(Map<String, Object> map) {

		// Board Table의 행을 Count해서 totalCount에 삽입
		int totalCount = boardDao.selectCntAll(map);
		
		// map의 문자열 curPage를 Integer로 파싱해 curPage에 삽입
		int curPage = Integer.parseInt(  map.get("curPage").toString());
		
		// 페이징 객체에 <String , Object> 방식으로 삽입
		Paging paging = new Paging(totalCount,curPage);
		
		return paging;
	}
	
	// 게시글을 조회해서 페이징처리
	@Override
	public List getBoardList(Paging paging) {
		
		return boardDao.selectAll(paging);
	}

	@Override
	public BoardDto selectView(BoardDto viewBoard) {
		
			boardDao.updateHit(viewBoard);
			
		return boardDao.selectBoardByBoardno(viewBoard) ;
		
	}

	// ID 와 Nick 조건으로 회원 비회원 분류
	@Override
	public void insertwrite(BoardDto boardDto) {
		if ( boardDto.getMem_id() != null ) 
		{
			boardDao.userwrite(boardDto);
		} if ( boardDto.getOjt_board_nick() != null ){
			boardDao.nickwrite(boardDto);
		}
	}

	/*
	 * @Override public void imgsave(ServletContext context, Board board,
	 * MultipartHttpServletRequest mtfRequest) { List list = new ArrayList();
	 * List<MultipartFile> fileList = mtfRequest.getFiles("file"); //String src =
	 * mtfRequest.getParameter("src"); //System.out.println("src value : " + src);
	 * int m=0; String path = context.getRealPath("uppage"); for (MultipartFile mf :
	 * fileList) { String originFileName = mf.getOriginalFilename(); // 원본 파일 명 long
	 * fileSize = mf.getSize(); // 파일 사이즈
	 * 
	 * //UUID String uId = UUID.randomUUID().toString().split("-")[4];
	 * 
	 * //저장될 파일의 이름( 원본이름 + UUID) String name = mf.getOriginalFilename()+"_"+uId;
	 * 
	 * System.out.println("originFileName : " + originFileName);
	 * System.out.println("fileSize : " + fileSize);
	 * board.setOriginname(mf.getOriginalFilename()); list.add(m, name); m++; try {
	 * mf.transferTo(new File(path, name)); } catch (IllegalStateException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } catch (IOException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } } }
	 */

	@Override
	public void deleteList(int ojt_board_no) {
		boardDao.deleteList(ojt_board_no);
		
	}

	@Override
	public void update(BoardDto boardDto) {
		if ( boardDto.getMem_id() != null ) 
		{
			boardDao.update(boardDto);
		} if ( boardDto.getOjt_board_nick() != null ){
			boardDao.update(boardDto);
		}
		
	}

	@Override
	public void recommend(int ojt_board_no) {
		boardDao.recommend(ojt_board_no);
		
	}

	@Override
	public void d_recommend(int ojt_board_no) {
		boardDao.d_recommand(ojt_board_no);
		
	}

	@Override
	public void row(String row) {
		boardDao.row(row);
		
	}

	@Override
	public void boardListDelete(String names) {
		boardDao.deleteBoardList(names);
		
	}

	@Override
	public void insertFile(ServletContext context, BoardFileDto boardFileDto, MultipartHttpServletRequest req) {
		List list = new ArrayList();
		List<MultipartFile> fileList = req.getFiles("file");

		int m = 0 ;
		String path = context.getRealPath("upload");

		for ( MultipartFile mf : fileList ) {
			String originFileName = mf.getOriginalFilename() ; // 원본 파일 명
			long fileSize = mf.getSize() ; // 파일 사이즈

			//UUID
			String uId = UUID.randomUUID().toString().split("-")[4];

			//저장될 파일의 이름( 원본이름 + UUID)
			String name = mf.getOriginalFilename()+"_"+uId;

			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);
			boardFileDto.setFile_origin_name(mf.getOriginalFilename());
			list.add(m, name);
			m++;
			try {
				mf.transferTo(new File(path, name));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String saveList = (String)list.get(0);
		for(int i=1; i<list.size(); i++) {
			saveList += " "+(String)list.get(i);
		}
		
		boardFileDto.setFile_stored_name(saveList);
		boardDao.insertFile(boardFileDto);
	}

}


	
