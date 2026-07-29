package model;

public class Book {
	
	private String bookId;
	private String title; 
	private String status;
	
	public Book(String title,String bookId, String status) {
		this.title = title;
		this.bookId = bookId;
		this.status = status;
	}
	public String getBookId() {return bookId;}
	public String getTitle() {return title;}
	public String getStatus() {return status;}
	
}
