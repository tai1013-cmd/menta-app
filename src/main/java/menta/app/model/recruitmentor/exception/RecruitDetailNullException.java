package menta.app.model.recruitmentor.exception;

public class RecruitDetailNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public RecruitDetailNullException(){
		super("詳細が設定されていません。");
	}
	
}
