package menta.app.model.user.exception;

public class UserPropertyNullException extends RuntimeException {
	private static final long serialVersionUID = 1L; 
	public UserPropertyNullException(String property){
		super(property + "：未設定");
	}
}