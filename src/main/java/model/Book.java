package model;

public class Book {
	private String bookId;
	private String title; 
	public Book(String title,String bookId) {
		this.title = title;
		this.bookId = bookId;
	}
	public String getBookId() {
		return bookId;
	}
	
	
	public String getTitle() {
		return title;
	}
	
}
