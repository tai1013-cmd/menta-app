package menta.app.model.proposal;

import lombok.Getter;
import menta.app.model.plan.valueObject.PlanId;
import menta.app.model.proposal.exception.ProposalDetailMaxLengthException;
import menta.app.model.proposal.exception.ProposalDetailNullException;
import menta.app.model.proposal.valueObject.ProposalId;

@Getter
public class ProposalModel {
	
	private ProposalId proposalId = null;
	private PlanId referPlanId = null;
	private String detail = "";
	
	/**
	 * 内容：最大文字数
	 */
	private final static Integer DETAIL_MAX_LENGTH = 2000;
	
	/**
	 *  コンストラクタ
	 *  @param proposalId 提案ID
	 *  @param referPlanId 参照プランID
	 *  @param detail 内容
	 */
	public ProposalModel(ProposalId proposalId,
			PlanId referPlanId,
			String detail
			) {
		//チェック
		checkDetail(detail);
		
		this.proposalId = proposalId;
		this.referPlanId = referPlanId;
		this.detail = detail;
	}
	
	/**
	 *  内容を設定する
	 *  @param detail 内容
	 */
	public void changeDetail(String detail) {
		
		// チェック
		checkDetail(detail);
		this.detail = detail;
	}
	
	private void checkDetail(String detail) {
		
		if(detail == null || detail.length() == 0) {
			throw new ProposalDetailNullException();
		}
		if(detail.length() > DETAIL_MAX_LENGTH) {
			throw new ProposalDetailMaxLengthException(detail);
		}
		
	}
	
}
