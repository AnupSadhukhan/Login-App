package com.myApp.MyApp.Model;

import org.springframework.http.HttpStatus;

public class ResponseMessage {
	private String message;
	private HttpStatus statusCode;

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseMessage(String message,HttpStatus statusCode) {
		super();
		this.message = message;
		this.statusCode=statusCode;
	}
	

}
