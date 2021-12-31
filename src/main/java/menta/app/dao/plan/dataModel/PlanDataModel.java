package menta.app.dao.plan.dataModel;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import menta.app.model.plan.PlanModel;
import menta.app.model.user.valueObject.UserId;

@Getter
public class PlanDataModel implements java.io.Serializable {

	private static final long serialVersionUID = -5230730347594981775L;

	/**
	 * 提案ID
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
	 * ステータス
	 */
	private String status;
	
	/**
	 * 契約承認
	 */
	private String approval;
	
	/**
	 * 参照カテゴリID
	 */
	private String referCategoryId;
	
	/**
	 * 参照タグID
	 */
	private String referTagId;
	
	/**
	 * 参照ユーザーID
	 */
	private String referUserId;
	
	/**
	 * レコード作成日時
	 */
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime createdAt;
	
	public PlanDataModel() {
		
	}
	
	/**
	 * コンストラクタ
	 * @param planModel プランモデル
	 * @param referUserId 参照ユーザーID
	 */
	public PlanDataModel(PlanModel planModel, UserId referUserId, LocalDateTime createdAt) {
		this.id = planModel.getPlanId().getId();
		this.title = planModel.getTitle();
		this.detail = planModel.getDetail();
		this.status = planModel.getStatus().name();
		this.approval = planModel.getApproval().name();
		this.referTagId = planModel.getReferTagIdList().get(0).getId();
		this.referCategoryId = planModel.getReferCategoryId().getId();
		this.referUserId = referUserId.getId();
		this.createdAt = createdAt;
	}
}
