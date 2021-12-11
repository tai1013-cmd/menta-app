package menta.app.model.user.exception;

public class UserPropertyMinLengthException extends RuntimeException {
	private static final long serialVersionUID = 1L; 
	public UserPropertyMinLengthException(String key, String value){
		super(key + "(" + value +  ")" +"：最小文字数より少ない");
	}
}