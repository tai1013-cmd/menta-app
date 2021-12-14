package menta.app.model.career.exception;

public class CareerYearFromToRelationshipException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public CareerYearFromToRelationshipException(int yearFrom, int yearTo){
		
		super("西暦（FROM〜TO）の大小チェックエラー" + "(" + yearFrom + "," + yearTo + ")");
	}
}