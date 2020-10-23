package com.mani.project.readmeapi.exception;

public enum ErrorCode {
	INVALID_INPUT("100"),
	NOT_FOUND("101"),
	UNKNOWN_EXCEPTION("200");
	
	String code;
	
	ErrorCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
