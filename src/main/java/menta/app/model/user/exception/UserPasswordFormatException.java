package menta.app.model.user.exception;

public class UserPasswordFormatException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public UserPasswordFormatException(String password){
		
		super("パスワードの形式チェックエラー" + "(" + password + ")");
	}
	
}
