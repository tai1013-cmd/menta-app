package menta.app.model.user;
import java.util.List;

import lombok.Getter;
import menta.app.model.skill.valueObject.SkillId;
import menta.app.model.user.exception.UserPropertyMaxLengthException;
import menta.app.model.user.valueObject.FullName;
import menta.app.model.user.valueObject.MailAddress;
import menta.app.model.user.valueObject.Password;
import menta.app.model.user.valueObject.UserId;

@Getter
public class UserModel {
	private UserId userId = null;
	private MailAddress mailadress = null;
	private Password password = null;
	private FullName fullName = null;
	private String selfIntro = "";
	private List<SkillId> skills = null;
	
	/**
	 * 自己紹介：最大文字数
	 */
	private final static Integer INTRODUCTION_MAX_LENGTH = 2000;
	/**
	 * メンター募集に提案可能なスキル数 
	 */
	private final static Integer PROPOSAL_FOR_MENTA_MIN_SKILL_NUM = 5;
	
	/**
	 *  コンストラクタ
	 *  @param userId ユーザーID
	 *  @param mailadress メールアドレス
	 *  @param password パスワード
	 *  @param fullName 氏名（姓・名）
	 *  @param selfIntro 自己紹介
	 *  @param skills 参照スキルID一覧
	 */
	public UserModel(UserId userId,
			MailAddress mailadress,
			Password password,
			FullName fullName,
			String selfIntro,
			List<SkillId> skills
			) {
		
		// チェック
		checkSelfIntro(selfIntro);
		
		this.userId = userId;
		this.mailadress = mailadress;
		this.password = password;
		this.fullName = fullName;
		this.selfIntro = selfIntro;
		this.skills = skills;
	}
	
	/**
	 *  メールアドレスを設定する
	 *  @param mailadress メールアドレス
	 */
	public void changeMailaddress(MailAddress mailadress) {
		
		this.mailadress = mailadress;
	}
	
	/**
	 *  パスワードを設定する
	 *  @param mailadress メールアドレス
	 */
	public void changePassword(Password password) {

		this.password = password;
	}
	
	/**
	 *  氏名を設定する
	 *  @param fullName 氏名
	 */
	public void changeNameFull(FullName fullName) {
		
		this.fullName = fullName;
	}
	
	/**
	 *  自己紹介を設定する
	 *  @param selfIntro 自己紹介
	 */
	public void changeSelfIntro(String selfIntro) {
		
		// チェック
		checkSelfIntro(selfIntro);
		this.selfIntro = selfIntro;
	}
	
	/**
	 *  スキルを設定する
	 *  @param skills 参照スキルId一覧
	 */
	public void changeSkills(List<SkillId> skills) {
		
		this.skills = skills;
	}
	
	/**
	 *  メンター募集に提案可能か
	 *  @return true:提案可能 
	 */
	public boolean isProposalForMenterRecruit() {
		if(skills != null && skills.size() >= PROPOSAL_FOR_MENTA_MIN_SKILL_NUM) {
			return true;
		}
		return false;
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
