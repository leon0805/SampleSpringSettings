package com.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.test.app.dto.TestRespDto;
import com.test.app.service.TestService;

@RestController
@RequestMapping(path="rest-test")
public class TestRestController {

	@Autowired
	TestService testService; 

	@RequestMapping(path="{testID}")
	public TestRespDto test(@PathVariable String testID)
	{
		TestRespDto dto = new TestRespDto();
		dto.testId = testID;
		dto.testName = "테스트 1";
		return dto;
	}
	@RequestMapping(path="{testID}/say")
	public SseEmitter say()
	{
		SseEmitter emitter = new SseEmitter();
		testService.say(emitter);
		return emitter;
	}

}
