package menta.app.model.user.exception;

public class UserPropertyMaxLengthException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public UserPropertyMaxLengthException(String key, String value){
		
		super(key + "(" + value +  ")が最大文字数を超えています。");
	}
	
}
