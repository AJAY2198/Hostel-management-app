package com.cg.hms.exception;
/**
 * This class is used to handle exception
 * @author kethu_greeshma
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HMAException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HMAException() {
		super();
	}
	
	public HMAException(String errMsg) {
		super(errMsg);
	}
}
