package com.test.app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookInfoDto {
	public String bookID = "";
	public String bookName = "";
	@DateTimeFormat(pattern="yyyyMMddHHmmss")
	@JsonFormat(pattern="yyyyMMddHHmmss")
	public Date publishDate = null;
	public List<String> bookType = new ArrayList<String>(10);
	public List<String> getBookType() {
		return bookType;
	}
	public void setBookType(List<String> bookType) {
		this.bookType = bookType;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
