package kr.co.view;

@SuppressWarnings("serial")
public class ExceptionMy extends Exception{
	String message;
	public ExceptionMy(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	
}
