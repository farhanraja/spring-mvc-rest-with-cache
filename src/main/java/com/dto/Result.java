package com.dto;

/**
 * POJO to store and format API results.
 * 
 * @author Farhan
 *
 */
public class Result {
	String result;

	public Result(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
