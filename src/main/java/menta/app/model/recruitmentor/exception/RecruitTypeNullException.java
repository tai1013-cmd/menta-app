package menta.app.model.recruitmentor.exception;

public class RecruitTypeNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public RecruitTypeNullException(){
		super("タイプが設定されていません。");
	}
	
}
