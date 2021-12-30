package menta.app.dao.skill.dataModel;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import menta.app.model.skill.SkillModel;
import menta.app.model.user.valueObject.UserId;

@Getter
public class SkillDataModel implements java.io.Serializable {

	private static final long serialVersionUID = 3955441296791044440L;

	/**
	 * スキルID
	 */
	private String id;
	
	/**
	 * 参照タグID
	 */
	private String referTagId;
	
	/**
	 * 経験年数
	 */
	private Integer year;
	
	/**
	 * レベル
	 */
	private Integer level;
	
	/**
	 * 参照ユーザーID
	 */
	private String referUserId;
	
	/**
	 * レコード作成日時
	 */
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime createdAt;
	
	public SkillDataModel() {
	}
	
	/**
	 * コンストラクタ
	 * @param skillModel スキルモデル
	 * @param referUserId 参照ユーザーID
	 */
	public SkillDataModel(SkillModel skillModel, UserId referUserId, LocalDateTime createdAt) {
		this.id = skillModel.getSkillId().getId();
		this.referTagId = skillModel.getReferTagId().getId();
		this.year = skillModel.getYear();
		this.level = skillModel.getLevel();
		this.referUserId = referUserId.getId();
		this.createdAt = createdAt;
	}
}
