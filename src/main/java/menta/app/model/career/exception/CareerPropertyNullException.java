package menta.app.model.career.exception;

public class CareerPropertyNullException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public CareerPropertyNullException(String property){
	
		super(property + "：未設定");
	}
}
