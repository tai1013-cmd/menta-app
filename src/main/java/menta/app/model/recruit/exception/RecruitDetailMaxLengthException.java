package menta.app.model.recruit.exception;

public class RecruitDetailMaxLengthException extends RuntimeException {

	private static final long serialVersionUID = 1L; 
	
	public RecruitDetailMaxLengthException(String detail){
		super("詳細（" + detail + "）が最大文字数を超えています。");
	}
	
}
