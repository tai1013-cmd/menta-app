package menta.app.model.recruit.exception;

public class RecruitTitleMaxLengthException extends RuntimeException {

	private static final long serialVersionUID = 1L; 
	
	public RecruitTitleMaxLengthException(String title){
		super("タイトル（" + title + "）が最大文字数を超えています。");
	}
	
}
