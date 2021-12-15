package menta.app.model.user.exception;

public class UserMailAddressFormatException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public UserMailAddressFormatException(String value){
		
		super("メールアドレス形式チェックエラー" + "(" + value + ")");
	}
	
}
