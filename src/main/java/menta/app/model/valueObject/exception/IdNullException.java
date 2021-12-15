package menta.app.model.valueObject.exception;

public class IdNullException extends RuntimeException {

private static final long serialVersionUID = 1L; 
	
	public IdNullException(){
		super("ID：未設定");
	}
	
}
