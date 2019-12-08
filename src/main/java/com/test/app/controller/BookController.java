package com.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.app.dto.BookInfoDto;

@Controller
@RequestMapping("books")
public class BookController {
	@RequestMapping(path="form", method=RequestMethod.GET)
	public String getInputForm(Model model)
	{
		BookInfoDto dto = new BookInfoDto();
		model.addAttribute(dto);
		return "bookInput";
	}

	@RequestMapping(path="form", method=RequestMethod.POST)
	public String inputResult(BookInfoDto bookinfo)
	{
		bookinfo.bookID = "253";
		return "bookInputResult";
	}


}
