package model;

public class Book {
	private int bookId;
	private String title; 
	public Book(String title,int bookId) {
		this.title = title;
		this.bookId = bookId;
	}
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
