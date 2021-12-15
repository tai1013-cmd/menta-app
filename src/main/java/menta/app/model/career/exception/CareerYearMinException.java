package menta.app.model.career.exception;

public class CareerYearMinException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public CareerYearMinException(int year){
		
		super("西暦（FROM〜TO）が最小年度より小さい(" + year  + ")");
	}
}
