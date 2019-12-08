package com.test.app.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.dto.BookInfoDto;
import com.test.app.dto.ResultDto;
import com.test.app.service.BookService;

@RestController
@RequestMapping("rest-books")
public class BookRestController {
	@Autowired
	BookService bookService;
	
	@RequestMapping(path="{bookID}", method=RequestMethod.GET)
	public CompletableFuture<BookInfoDto> getBook(@PathVariable String bookID)
	{
		return bookService.asyncGetBook2(bookID);
	}
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public CompletableFuture<ResultDto> createBook(@RequestBody BookInfoDto book)
	{
		book.setBookID("230111");
		System.out.println("=== createBook ===");
		System.out.println("id : " + book.getBookID());
		System.out.println("name : " + book.getBookName());
		System.out.println("publish date : " + book.getPublishDate());
		System.out.println("===================");
		return bookService.asyncCreateBook(book);
	}
	
	
	@RequestMapping(path="{bookID}", method=RequestMethod.PUT)
	public BookInfoDto updateBook(@RequestBody BookInfoDto book, @PathVariable String bookID)
	{
		System.out.println("=== updateBook ===");
		System.out.println("id : " + book.getBookID());
		System.out.println("name : " + book.getBookName());
		System.out.println("publish date : " + book.getPublishDate());
		System.out.println("===================");
		book.setBookID(bookID);
		return book;
	}
	
	@RequestMapping(path="{bookID}", method=RequestMethod.DELETE)
	public ResultDto deleteBook(@PathVariable String bookID)
	{
		ResultDto dto = new ResultDto();
		dto.setResultCode(100);
		return dto;
	}
	
	
	
	
	

}
