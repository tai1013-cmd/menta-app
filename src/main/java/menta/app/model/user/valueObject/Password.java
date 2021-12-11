package menta.app.model.user.valueObject;
import lombok.Getter;
import menta.app.model.user.exception.UserPasswordFormatException;
import menta.app.model.user.exception.UserPropertyMinLengthException;
import menta.app.model.user.exception.UserPropertyNullException;

@Getter
public class Password {
	
	private String password = "";
	
	/**
	 * パスワード：最小文字数
	 */
	private final static Integer PASSWORD_MIN_LENGTH = 12;
	
	/**
	 * パスワード：英数字それぞれ最低1文字以上正規表現
	 */
	private final static String PASSWORD_FORMAT = "^(?=.*[a-zA-Z])(?=.*[0-9]).*";
	
	/**
	 *  コンストラクタ
	 *  @param password パスワード
	 */
	public Password(String password) {
		
		// チェック
		checkPassword(password);
		this.password = password;
	}

	/**
	 *  パスワードチェック
	 *  @param password パスワード
	 */
	public void checkPassword(String password) {
		
		String errMsglabel = "パスワード";
		// 必須チェック
		if(password == null || password.length() == 0) {
			throw new UserPropertyNullException(errMsglabel);
		}
		// 桁数チェック
		if(password.length() < PASSWORD_MIN_LENGTH) {
			throw new UserPropertyMinLengthException(errMsglabel, password);
		}
		// フォーマットチェック
		if(!password.matches(PASSWORD_FORMAT)) {
			throw new UserPasswordFormatException(password);
		}
	}
	
}
