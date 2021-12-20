package menta.app.model.tag.exception;

public class TagNameNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public TagNameNullException(){
		super("タグ名が設定されていません。");
	}
	
}
