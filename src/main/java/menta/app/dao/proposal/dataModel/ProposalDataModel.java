package menta.app.dao.proposal.dataModel;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import menta.app.model.proposal.ProposalModel;
import menta.app.model.user.valueObject.UserId;

@Getter
public class ProposalDataModel implements java.io.Serializable {

	private static final long serialVersionUID = 187210220628054591L;

	/**
	 * 提案ID
	 */
	private String id;

	/**
	 * 内容
	 */
	private String detail;
	
	/**
	 * 参照メンター募集ID
	 */
	private String referRecruitMentorId;
		
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
	
	public ProposalDataModel() {
		
	}
	
	/**
	 * コンストラクタ
	 * @param proposalModel 提案モデル
	 * @param referUserId 参照ユーザーID
	 */
	public ProposalDataModel(ProposalModel proposalModel, UserId referUserId, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = proposalModel.getProposalId().getId();
		this.detail = proposalModel.getDetail();
		this.referRecruitMentorId = proposalModel.getReferRecruitMentorId().getId();
		this.referUserId = referUserId.getId();
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
}
