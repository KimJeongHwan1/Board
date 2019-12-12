package board.dto;

import java.util.Date;

public class Board {
	
	int no ;
	String kategorie ;
	String title ;
	String name ;
	String id ;
	int hit ;
	int view ;
	Date date ;
	String content ;
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
	@Override
	public String toString() {
		return "Board [no=" + no + ", kategorie=" + kategorie + ", title=" + title + ", name=" + name + ", id=" + id
				+ ", hit=" + hit + ", view=" + view + ", date=" + date + ", content=" + content + "]";
	}
	
	
	
	
}
