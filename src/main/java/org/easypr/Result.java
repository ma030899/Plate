package org.easypr;
/**
 * 用于存放结果以及返回信息
 * @author mly
 *
 */
public class Result {
private int code = 0;
	
	private String message = "";
	
	private Object result = null;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
}
