package menta.app.model.category.exception;

public class CategoryNameNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public CategoryNameNullException(){
		super("カテゴリ名が設定されていません。");
	}
	
}
