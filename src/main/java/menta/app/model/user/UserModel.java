package menta.app.model.user;
import lombok.Getter;
import lombok.Setter;
import menta.app.model.user.exception.UserPasswordFormatException;
import menta.app.model.user.exception.UserPropertyMaxLengthException;
import menta.app.model.user.exception.UserPropertyMinLengthException;
import menta.app.model.user.exception.UserPropertyNullException;

@Getter
public class UserModel {
	
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
	 *  @param mailadress メールアドレス
	 *  @param password パスワード
	 *  @param sei 氏名（姓）
	 *  @param mei 氏名（名）
	 *  @param selfIntro 自己紹介
	 */
	public UserModel(String mailadress,
			String password,
			String sei,
			String mei,
			String selfIntro
			) {
		
		// チェック
		checkNameFull(sei, mei);
		checkMailAddress(mailadress);
		checkPassword(password);
		checkSelfIntro(selfIntro);
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
		
		String label = "メールアドレス";
		// 必須チェック
		if(mailAddress == null) {
			throw new UserPropertyNullException(label);
		}
		// 桁数チェック
		if(mailAddress.length() > MAILADDRESS_MAX_LENGTH) {
			throw new UserPropertyMaxLengthException(label);
		}
	}
	
	/**
	 *  パスワードチェック
	 *  @param password パスワード
	 */
	private void checkPassword(String password) {
		
		String labelPassword = "パスワード";
		// 必須チェック
		if(password == null) {
			throw new UserPropertyNullException(labelPassword);
		}
		// 桁数チェック
		if(password.length() < PASSWORD_MIN_LENGTH) {
			throw new UserPropertyMinLengthException(labelPassword);
		}
	}
	
	/**
	 *  氏名チェック
	 *  @param sei 姓
	 *  @param mei 名
	 */
	private void checkNameFull(String sei, String mei) {
		
		String labelSei = "氏名（姓）";
		String labelMei = "氏名（名）";
		String labelFull = "氏名（姓・名）";
		// 必須チェック
		if(sei == null) {
			throw new UserPropertyNullException(labelSei);
		}
		if(mei == null) {
			throw new UserPropertyNullException(labelMei);
		}
		// 桁数チェック
		String fullName = sei + mei;
		if(fullName.length() > FULL_NAME_MAX_LENGTH) {
			throw new UserPropertyMaxLengthException(labelFull);
		}
	}
	
	/**
	 *  自己紹介文チェック
	 *  @param selfIntro 自己紹介文
	 */
	private void checkSelfIntro(String selfIntro) {
		
		String labelSelfIntro = "自己紹介文";
		// 必須チェック
		if(selfIntro == null) {
			throw new UserPropertyNullException(selfIntro);
		}		
		// 桁数チェック
		if(selfIntro.length() > INTRODUCTION_MAX_LENGTH) {
			throw new UserPropertyMaxLengthException(selfIntro);
		}
		// フォーマットチェック
		if(!selfIntro.matches(INTRODUCTION_FORMAT)) {
			throw new UserPasswordFormatException();
		}
	}
	
}
