package com.github.xuexi.common;

public class UnknownPageException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UnknownPageException() {
		super();
	}

	public UnknownPageException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnknownPageException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownPageException(String message) {
		super(message);
	}

	public UnknownPageException(Throwable cause) {
		super(cause);
	}

}
