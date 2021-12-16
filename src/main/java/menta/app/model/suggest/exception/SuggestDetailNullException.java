package menta.app.model.suggest.exception;

public class SuggestDetailNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public SuggestDetailNullException(){
		super("内容が設定されていません。");
	}
	
}
