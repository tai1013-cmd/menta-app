package menta.app.model.proposal;

import lombok.Getter;
import menta.app.model.proposal.exception.ProposalDetailMaxLengthException;
import menta.app.model.proposal.exception.ProposalDetailNullException;
import menta.app.model.proposal.valueObject.ProposalId;
import menta.app.model.recruitmentor.valueObject.RecruitMentorId;

@Getter
public class ProposalModel {
	
	private ProposalId proposalId = null;
	private RecruitMentorId referRecruitMentorId = null;
	private String detail = "";
	
	/**
	 * 内容：最大文字数
	 */
	private final static Integer DETAIL_MAX_LENGTH = 2000;
	
	/**
	 *  コンストラクタ
	 *  @param proposalId 提案ID
	 *  @param referRecruitMentorId 参照メンター募集ID
	 *  @param detail 内容
	 */
	public ProposalModel(ProposalId proposalId,
			RecruitMentorId referRecruitMentorId,
			String detail
			) {
		//チェック
		checkDetail(detail);
		
		this.proposalId = proposalId;
		this.referRecruitMentorId = referRecruitMentorId;
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
