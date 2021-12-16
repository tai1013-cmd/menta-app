package menta.app.model.plan.exception;

public class PlanApprovalNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public PlanApprovalNullException(){
		super("ステータスが設定されていません。");
	}
	
}
