package br.com.fiap.exceptions;

public class DBCommitException extends Exception {
	
	public DBCommitException(){
		super();
	}
	
	public DBCommitException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public DBCommitException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DBCommitException(String message) {
		super(message);
		
	}

	public DBCommitException(Throwable cause) {
		super(cause);
	
	}
}
