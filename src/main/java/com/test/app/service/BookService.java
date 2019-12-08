package com.test.app.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.test.app.dto.BookInfoDto;
import com.test.app.dto.ResultDto;

@Service
public class BookService {

	@Autowired
	@Qualifier("jdbcTemplate2")
	JdbcTemplate jdbcTemplate;
	
	@Async
	public CompletableFuture<BookInfoDto> asyncGetBook(String bookId)
	{
		BookInfoDto book = new BookInfoDto();
		String sql = "SELECT BookID, BookName, PublishDate FROM testdb.book"
				+ " WHERE BookID = ?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, bookId);
		for(Map<String, Object> map : list)
		{
			book.setBookID((String)map.get("BookID"));
			book.setBookName((String)map.get("BookName"));
			book.setPublishDate((Date)map.get("PublishDate"));
			break;
		}
		return CompletableFuture.completedFuture(book);
	}
	
	@Async
	public CompletableFuture<BookInfoDto> asyncGetBook1(String bookId)
	{
		String sql = "SELECT BookID, BookName, PublishDate FROM testdb.book"
				+ " WHERE BookID = ?";
		List<BookInfoDto> list = jdbcTemplate.query(sql
				, new RowMapper<BookInfoDto>() {

					public BookInfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						BookInfoDto book = new BookInfoDto();
						book.setBookID(rs.getString("BookID"));
						book.setBookName(rs.getString("BookName"));
						book.setPublishDate(rs.getDate("PublishDate"));
						return book;
					}}, bookId);
		
		return CompletableFuture.completedFuture(list.size() > 0? list.get(0): null);
	}
	
	@Async
	public CompletableFuture<BookInfoDto> asyncGetBook2(String bookID)
	{
		String sql = "SELECT BookID, BookName, PublishDate FROM testdb.book"
				+ " WHERE BookID = ?";
		List<BookInfoDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<BookInfoDto>(BookInfoDto.class), bookID);
		return CompletableFuture.completedFuture(list.size() > 0? list.get(0): null);
	}

	@Async
	public CompletableFuture<ResultDto> asyncCreateBook(BookInfoDto book)
	{
		String sql = "INSERT INTO testdb.book(BookName, PublishDate) " 
		+ " VALUES (?, ?)";
		int res = jdbcTemplate.update(sql, book.getBookName(), book.getPublishDate());
		ResultDto resdto = new ResultDto();
		if(res > 0)
		{
			resdto.setResultCode(100);
			resdto.setResultMsg("성공");
		}
		else
		{
			resdto.setResultCode(-1);
			resdto.setResultMsg("실패");
		}
		
		return CompletableFuture.completedFuture(resdto);
	}

}
