package board.dto;

import java.util.Date;

public class Board {
	
	// 게시글 번호 pk
	int no ;
	// 분류
	String kategorie ;
	// 제목
	String title ;
	// 회원 이름
	String name ;
	// 회원 아이디
	String id ;
	// 추천수
	int hit ;
	// 조회수
	int view ;
	// 작성 날짜
	Date date ;
	// 본문
	String content ;
	// 비회원 닉네임
	String nick ;
	// 파일 번호
	int file_no ;
	// 파일 원본 이름
	String originname ;
	// 첨부된 파일 이름
	String storedname ;
	// 공개 비공개
	int blocksee ;
	// 중요 일반
	int basic ;
	// 회원 코드
	int code ;
	// 글 삭제
	int delete ;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getKategorie() {
		return kategorie;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getOriginname() {
		return originname;
	}
	public void setOriginname(String originname) {
		this.originname = originname;
	}
	public String getStoredname() {
		return storedname;
	}
	public void setStoredname(String storedname) {
		this.storedname = storedname;
	}
	public int getBlocksee() {
		return blocksee;
	}
	public void setBlocksee(int blocksee) {
		this.blocksee = blocksee;
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getDelete() {
		return delete;
	}
	public void setDelete(int delete) {
		this.delete = delete;
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", kategorie=" + kategorie + ", title=" + title + ", name=" + name + ", id=" + id
				+ ", hit=" + hit + ", view=" + view + ", date=" + date + ", content=" + content + ", nick=" + nick
				+ ", file_no=" + file_no + ", originname=" + originname + ", storedname=" + storedname + ", blocksee="
				+ blocksee + ", basic=" + basic + ", code=" + code + ", delete=" + delete + "]";
	}
	
	
	
	
}
