package site.metacoding.firstapp.handler;

public class MyException extends RuntimeException {
	public MyException(String msg) {// Exception으로 옮김
		super(msg);
	}
}
