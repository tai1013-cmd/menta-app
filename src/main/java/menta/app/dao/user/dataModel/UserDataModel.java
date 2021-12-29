package menta.app.dao.user.dataModel;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import menta.app.model.user.UserModel;

/**
 * ユーザーテーブルの情報を格納するクラス
 */
@Getter
public class UserDataModel implements java.io.Serializable {

	private static final long serialVersionUID = 5477469199667385053L;

	/**
	 * ユーザID
	 */
	private String id;

	/**
	 * メールアドレス
	 */
	private String mailaddress;
	
	/**
	 * 姓
	 */
	private String sei;
	
	/**
	 * 名
	 */
	private String mei;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 *　自己紹介
	 */
	private String selfIntro;
	
	
	/**
	 * レコード作成日時
	 */
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime createdAt;

	/**
	 * レコード更新日時
	 */
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime updatedAt;

	/**
	 * 削除フラグ
	 */
	private boolean isDeleted = false;

	/**
	 * コンストラクタ
	 */
	public UserDataModel() {
	}
	
	/**
	 * コンストラクタ
	 */
	public UserDataModel(UserModel userModel, LocalDateTime createdAt , LocalDateTime updatedAt) {
		this.id = userModel.getUserId().getId();
		this.password = userModel.getPassword().getPassword();
		this.mailaddress = userModel.getMailadress().getMailadress();
		this.sei = userModel.getFullName().getSei();
		this.mei = userModel.getFullName().getMei();
		this.selfIntro = userModel.getSelfIntro();
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

}
