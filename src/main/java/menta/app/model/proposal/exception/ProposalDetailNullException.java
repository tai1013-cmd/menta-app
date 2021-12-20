package menta.app.model.proposal.exception;

public class ProposalDetailNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public ProposalDetailNullException(){
		super("内容が設定されていません。");
	}
	
}
