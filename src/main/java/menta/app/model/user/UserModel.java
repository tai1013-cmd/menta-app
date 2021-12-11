package menta.app.model.user;
import lombok.Getter;
import lombok.Setter;
import menta.app.model.user.exception.UserPasswordFormatException;
import menta.app.model.user.exception.UserPropertyMaxLengthException;
import menta.app.model.user.exception.UserPropertyMinLengthException;
import menta.app.model.user.exception.UserPropertyNullException;

@Getter
public class UserModel {
	private String userId = "";
	private String mailadress = "";
	private String password = "";
	private String sei = "";
	private String mei = "";
	private String selfIntro = "";
	
	/**
	 * メールアドレス：最大文字数
	 */
	private final static Integer MAILADDRESS_MAX_LENGTH = 255;
	/**
	 * パスワード：最小文字数
	 */
	private final static Integer PASSWORD_MIN_LENGTH = 12;
	/**
	 * 氏名：最大文字数
	 */
	private final static Integer FULL_NAME_MAX_LENGTH = 255;
	/**
	 * 自己紹介：最大文字数
	 */
	private final static Integer INTRODUCTION_MAX_LENGTH = 2000;

	/**
	 * 自己紹介：フォーマット英数字それぞれ最低1文字以上
	 */
	private final static String INTRODUCTION_FORMAT = "^(?=.*[a-zA-Z])(?=.*[0-9]).*";
	/**
	 *  コンストラクタ
	 *  @param userId ユーザーID
	 *  @param mailadress メールアドレス
	 *  @param password パスワード
	 *  @param sei 氏名（姓）
	 *  @param mei 氏名（名）
	 *  @param selfIntro 自己紹介
	 */
	public UserModel(String userId,
			String mailadress,
			String password,
			String sei,
			String mei,
			String selfIntro
			) {
		
		// チェック
		checkMailAddress(mailadress);
		checkPassword(password);
		checkNameFull(sei, mei);
		checkSelfIntro(selfIntro);
		
		this.userId = userId;
		this.mailadress = mailadress;
		this.password = password;
		this.sei = sei;
		this.mei = mei;
		this.selfIntro = selfIntro;
	}
	
	/**
	 *  メールアドレスを設定する
	 *  @param mailadress メールアドレス
	 */
	public void setMailaddress(String mailadress) {
		
		// チェック
		checkMailAddress(mailadress);
		this.mailadress = mailadress;
	}
	
	/**
	 *  パスワードを設定する
	 *  @param mailadress メールアドレス
	 */
	public void setPassword(String password) {
		
		// チェック
		checkPassword(password);
		this.password = password;
	}
	
	/**
	 *  氏名を設定する
	 *  @param sei 姓
	 *  @param mei 名
	 */
	public void setNameFull(String sei, String mei) {
		
		// チェック
		checkNameFull(sei, mei);
		this.sei = sei;
		this.mei = mei;
	}
	
	/**
	 *  自己紹介を設定する
	 *  @param selfIntro 自己紹介
	 */
	public void setSelfIntro(String selfIntro) {
		
		// チェック
		checkSelfIntro(selfIntro);
		this.selfIntro = selfIntro;
	}
	
	/**
	 *  メールアドレスチェック
	 *  @param mailAddress メールアドレス
	 */
    private void checkMailAddress(String mailAddress) {
		
		String errMsglabel = "メールアドレス";
		// 必須チェック
		if(mailAddress == null || mailAddress.length() == 0) {
			throw new UserPropertyNullException(errMsglabel);
		}
		// 桁数チェック
		if(mailAddress.length() > MAILADDRESS_MAX_LENGTH) {
			throw new UserPropertyMaxLengthException(errMsglabel, mailAddress);
		}
	}
	
	/**
	 *  パスワードチェック
	 *  @param password パスワード
	 */
	private void checkPassword(String password) {
		
		String errMsglabel = "パスワード";
		// 必須チェック
		if(password == null || password.length() == 0) {
			throw new UserPropertyNullException(errMsglabel);
		}
		// 桁数チェック
		if(password.length() < PASSWORD_MIN_LENGTH) {
			throw new UserPropertyMinLengthException(errMsglabel, password);
		}
	}
	
	/**
	 *  氏名チェック
	 *  @param sei 姓
	 *  @param mei 名
	 */
	private void checkNameFull(String sei, String mei) {
		
		String errMsglabel1 = "氏名（姓）";
		String errMsglabel2 = "氏名（名）";
		String errMsglabel3 = "氏名（姓・名）";
		// 必須チェック
		if(sei == null || sei.length() == 0) {
			throw new UserPropertyNullException(errMsglabel1);
		}
		if(mei == null || mei.length() == 0) {
			throw new UserPropertyNullException(errMsglabel2);
		}
		// 桁数チェック
		String fullName = sei + mei;
		if(fullName.length() > FULL_NAME_MAX_LENGTH) {
			throw new UserPropertyMaxLengthException(errMsglabel3, fullName);
		}
	}
	
	/**
	 *  自己紹介文チェック
	 *  @param selfIntro 自己紹介文
	 */
	private void checkSelfIntro(String selfIntro) {
		
		String errMsglabel = "自己紹介文";
		// 必須チェック
		if(selfIntro == null || selfIntro.length() == 0) {
			return;
		}		
		// 桁数チェック
		if(selfIntro.length() > INTRODUCTION_MAX_LENGTH) {
			throw new UserPropertyMaxLengthException(errMsglabel, selfIntro);
		}
		// フォーマットチェック
		if(!selfIntro.matches(INTRODUCTION_FORMAT)) {
			throw new UserPasswordFormatException(selfIntro);
		}
	}
	
}
