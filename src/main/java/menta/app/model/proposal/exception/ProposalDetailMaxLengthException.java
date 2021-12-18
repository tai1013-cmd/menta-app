package menta.app.model.proposal.exception;

public class ProposalDetailMaxLengthException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public ProposalDetailMaxLengthException(String detail){
		super("詳細（" + detail + "）が最大文字数を超えています。");
	}
	
}
