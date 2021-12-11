package menta.app.model.user;
import lombok.Getter;
import menta.app.model.user.exception.UserPropertyMaxLengthException;
import menta.app.model.user.exception.UserPropertyNullException;
import menta.app.model.user.valueObject.FullName;
import menta.app.model.user.valueObject.MailAddress;
import menta.app.model.user.valueObject.Password;

@Getter
public class UserModel {
	private String userId = "";
	private MailAddress mailadress = null;
	private Password password = null;
	private FullName fullName = null;
	private String selfIntro = "";
	
	/**
	 * 自己紹介：最大文字数
	 */
	private final static Integer INTRODUCTION_MAX_LENGTH = 2000;

	/**
	 *  コンストラクタ
	 *  @param userId ユーザーID
	 *  @param mailadress メールアドレス
	 *  @param password パスワード
	 *  @param fullName 氏名（姓・名）
	 *  @param selfIntro 自己紹介
	 */
	public UserModel(String userId,
			MailAddress mailadress,
			Password password,
			FullName fullName,
			String selfIntro
			) {
		
		// チェック
		checkUserId(userId);
		checkSelfIntro(selfIntro);
		
		this.userId = userId;
		this.mailadress = mailadress;
		this.password = password;
		this.fullName = fullName;
		this.selfIntro = selfIntro;
	}
	
	/**
	 *  メールアドレスを設定する
	 *  @param mailadress メールアドレス
	 */
	public void setMailaddress(MailAddress mailadress) {
		
		this.mailadress = mailadress;
	}
	
	/**
	 *  パスワードを設定する
	 *  @param mailadress メールアドレス
	 */
	public void setPassword(Password password) {

		this.password = password;
	}
	
	/**
	 *  氏名を設定する
	 *  @param fullName 氏名
	 */
	public void setNameFull(FullName fullName) {
		
		this.fullName = fullName;
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
	 *  ユーザーIDチェック
	 *  @param userId ユーザーID
	 */
	private void checkUserId(String userId) {
		
		String errMsglabel = "ユーザーID";
		// 必須チェック
		if(userId == null || userId.length() == 0) {
			throw new UserPropertyNullException(errMsglabel);
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
	}
	
}
