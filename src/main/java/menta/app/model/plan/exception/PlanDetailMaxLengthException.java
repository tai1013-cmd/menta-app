package menta.app.model.plan.exception;

public class PlanDetailMaxLengthException extends RuntimeException {

	private static final long serialVersionUID = 1L; 
	
	public PlanDetailMaxLengthException(String title){
		super("内容（" + title + "）が最大文字数を超えています。");
	}
	
}
