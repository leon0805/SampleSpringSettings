package com.test.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.dto.TestRespDto;

@RestController
@RequestMapping(path="rest-test")
public class TestRestController {

	@RequestMapping(path="{testID}")
	public TestRespDto test(@PathVariable String testID)
	{
		TestRespDto dto = new TestRespDto();
		dto.testId = testID;
		dto.testName = "테스트 1";
		return dto;
	}

}
