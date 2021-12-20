package menta.app.model.plan.exception;

public class PlanDetailNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public PlanDetailNullException(){
		super("詳細が設定されていません。");
	}
	
}
