package menta.app.model.career.exception;

public class CareerDetailNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public CareerDetailNullException(){
		super("詳細が設定されていません。");
	}
	
}
