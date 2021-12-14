package menta.app.model.career.exception;

public class CareerYearMaxException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public CareerYearMaxException(int year){
		
		super("西暦（FROM〜TO）が現在年度より大きい(" + year  + ")");
	}
}