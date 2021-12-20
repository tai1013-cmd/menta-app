package menta.app.model.recruitmentor.exception;

public class RecruitTitleNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public RecruitTitleNullException(){
		super("タイトルが設定されていません。");
	}
	
}
