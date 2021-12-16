package menta.app.model.suggest.exception;

public class SuggestDetailMaxLengthException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public SuggestDetailMaxLengthException(String detail){
		super("詳細（" + detail + "）が最大文字数を超えています。");
	}
	
}
