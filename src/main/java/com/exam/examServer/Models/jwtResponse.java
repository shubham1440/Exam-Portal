package com.exam.examServer.Models;

public class jwtResponse {
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public jwtResponse(String token) {
		super();
		this.token = token;
	}

	public jwtResponse() {
	}

	private String token;
}
