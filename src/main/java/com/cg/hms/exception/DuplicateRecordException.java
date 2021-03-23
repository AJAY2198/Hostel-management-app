package com.cg.hms.exception;


public class DuplicateRecordException  extends Exception
{
	public DuplicateRecordException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "DuplicateRecordException" + super.getMessage();
	}
}
