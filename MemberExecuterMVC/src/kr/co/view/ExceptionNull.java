package kr.co.view;

@SuppressWarnings("serial")
public class ExceptionNull extends Exception{
	String message;
	@Override
	public String getMessage() {
		return "아무것도 안적으면 에러";
	}
	
}
