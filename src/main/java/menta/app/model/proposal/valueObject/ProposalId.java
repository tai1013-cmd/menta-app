package menta.app.model.proposal.valueObject;

import lombok.Getter;
import menta.app.model.valueObject.Id;

@Getter
public class ProposalId extends Id{
	
	/**
	 *  コンストラクタ
	 */
	public ProposalId() {
		super();
	}
	
	/**
	 *  コンストラクタ
	 *  @param Id ID
	 */
	public ProposalId(String id) {
		super(id);
	}
	
}
