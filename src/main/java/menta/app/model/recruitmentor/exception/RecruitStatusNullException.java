package menta.app.model.recruitmentor.exception;

public class RecruitStatusNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public RecruitStatusNullException(){
		super("ステータスが設定されていません。");
	}
	
}
