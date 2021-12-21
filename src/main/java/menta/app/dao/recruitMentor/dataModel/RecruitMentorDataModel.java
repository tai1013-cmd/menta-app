package menta.app.dao.recruitMentor.dataModel;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import menta.app.model.recruitmentor.RecruitMentorModel;
import menta.app.model.user.valueObject.UserId;

@Getter
public class RecruitMentorDataModel implements java.io.Serializable {

	private static final long serialVersionUID = -2963886150863995924L;

	/**
	 * メンター募集ID
	 */
	private String id;

	/**
	 * タイトル
	 */
	private String title;
	
	/**
	 * 詳細
	 */
	private String detail;
	
	/**
	 * 予算
	 */
	private Integer budget;
	
	/**
	 * タイプ
	 */
	private String type;
	
	/**
	 * ステータス
	 */
	private String status;
	
	/**
	 * 参照ユーザーID
	 */
	private String referUserId;
	
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
	private int isDeleted = 0;
	
	/**
	 * コンストラクタ
	 * @param proposalModel メンター募集モデル
	 * @param referUserId 参照ユーザーID
	 */
	public RecruitMentorDataModel(RecruitMentorModel proposalModel, UserId referUserId) {
		this.id = proposalModel.getRecruitMentorId().getId();
		this.title = proposalModel.getTitle();
		this.detail = proposalModel.getDetail();
		this.budget = proposalModel.getBudget();
		this.type = proposalModel.getType().name();
		this.status = proposalModel.getStatus().name();
		this.referUserId = referUserId.getId().toString();
	}
	
}
