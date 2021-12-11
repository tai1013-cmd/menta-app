package menta.app.model.user.valueObject;
import lombok.Getter;
import menta.app.model.user.exception.UserMailAddressFormatException;
import menta.app.model.user.exception.UserPropertyMaxLengthException;
import menta.app.model.user.exception.UserPropertyNullException;

@Getter
public class MailAddress {
	
	private String mailadress = "";
	
	/**
	 * メールアドレス：最大文字数
	 */
	private final static Integer MAILADDRESS_MAX_LENGTH = 255;
	/**
	 * メールアドレス：メールアドレス正規表現
	 */
	private final static String MAILADDRESS_FORMAT = "^[\\w!#%&’/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+(\\.[\\w!#%&’/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+)*@[\\w!#%&’/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+(\\.[\\w!#%&’/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+)*$";

	/**
	 *  コンストラクタ
	 *  @param mailadress メールアドレス
	 */
	public MailAddress(String mailadress) {
		
		// チェック
		checkMailAddress(mailadress);
		this.mailadress = mailadress;
	}
	
	/**
	 *  メールアドレスチェック
	 *  @param mailAddress メールアドレス
	 */
	public void checkMailAddress(String mailAddress) {
		
		String errMsglabel = "メールアドレス";
		// 必須チェック
		if(mailAddress == null || mailAddress.length() == 0) {
			throw new UserPropertyNullException(errMsglabel);
		}
		// 桁数チェック
		if(mailAddress.length() > MAILADDRESS_MAX_LENGTH) {
			throw new UserPropertyMaxLengthException(errMsglabel, mailAddress);
		}
		// フォーマットチェック
		if(!mailAddress.matches(MAILADDRESS_FORMAT)) {
			throw new UserMailAddressFormatException(mailAddress);
		}
	}
    
}
