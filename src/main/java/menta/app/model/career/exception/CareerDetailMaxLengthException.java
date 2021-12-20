package menta.app.model.career.exception;

public class CareerDetailMaxLengthException extends RuntimeException {

	private static final long serialVersionUID = 1L; 
	
	public CareerDetailMaxLengthException(String detail){
		super("詳細（" + detail + "）が最大文字数を超えています。");
	}
	
}
