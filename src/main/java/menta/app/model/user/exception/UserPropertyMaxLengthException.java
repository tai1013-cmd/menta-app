package menta.app.model.user.exception;

public class UserPropertyMaxLengthException extends RuntimeException {
	private static final long serialVersionUID = 1L; 
	public UserPropertyMaxLengthException(String property){
		super(property + "：最大文字数を超えている");
	}
}