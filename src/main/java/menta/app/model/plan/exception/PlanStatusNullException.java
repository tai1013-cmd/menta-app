package menta.app.model.plan.exception;

public class PlanStatusNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public PlanStatusNullException(){
		super("ステータスが設定されていません。");
	}
	
}
