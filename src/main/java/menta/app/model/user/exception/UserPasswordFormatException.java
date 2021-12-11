package menta.app.model.user.exception;

public class UserPasswordFormatException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public UserPasswordFormatException(String value){
		
		super("パスワードの形式チェックエラー" + "(" + value + ")");
	}
	
}