package com.test.app.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.test.app.dto.ErrorDto;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorDto processException(Exception e)
	{
		ErrorDto dto = new ErrorDto();
		if(e instanceof NullPointerException)
		{
			dto.setErrorCode(5001);
		}
		else
		{
			dto.setErrorCode(5000);
		}
		dto.setErrorMsg(e.getMessage());
		return dto;
	}
	/*
	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String processException(Exception e)
	{
		return "error/systemerror";
	}
	*/
}
