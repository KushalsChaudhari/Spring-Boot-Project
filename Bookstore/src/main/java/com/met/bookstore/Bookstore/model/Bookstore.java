package com.met.bookstore.Bookstore.model;

public class Bookstore {
	
	private int BookId;
	
	private String BookName;
	
	private String Author;
	
	private String Publisher;

	public int getBookId() {
		return BookId;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	@Override
	public String toString() {
		return "Bookstore [BookId=" + BookId + ", BookName=" + BookName + ", Author=" + Author + ", Publisher="
				+ Publisher + "]";
	}
	
	

}
