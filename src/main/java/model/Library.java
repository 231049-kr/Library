package model;

import java.io.Serializable;

public class Library implements Serializable{

	private String bookId;
	private String title;
	private String status;
	
	public Library() {}
	public Library(String bookId, String title, String status) {
		this.bookId = bookId;
		this.title = title;
		this.status = status;
	}
	
	public String getBookId() {return bookId;}
	public String getTitle() {return title;}
	public String getStatus() {return status;}
	
}
