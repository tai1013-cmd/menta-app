package menta.app.model.user.exception;

public class UserPropertyMinLengthException extends RuntimeException {
	private static final long serialVersionUID = 1L; 
	public UserPropertyMinLengthException(String property){
		super(property + "：最小文字数より少ない");
	}
}