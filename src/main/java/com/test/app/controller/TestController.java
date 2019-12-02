package com.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.app.dto.TestRespDto;

@Controller
@RequestMapping(path = "test")
public class TestController {

	@RequestMapping(path = "", method = RequestMethod.GET)
	public String showWelcome()
	{
		return "index";
	}

	@RequestMapping(path="{testId}")
	public @ResponseBody TestRespDto test(@PathVariable String testId)
	{
		TestRespDto dto = new TestRespDto();
		dto.testId = testId;
		return dto;
	}

}
