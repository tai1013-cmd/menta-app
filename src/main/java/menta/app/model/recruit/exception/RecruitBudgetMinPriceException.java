package menta.app.model.recruit.exception;

public class RecruitBudgetMinPriceException extends RuntimeException {

	private static final long serialVersionUID = 1L; 
	
	public RecruitBudgetMinPriceException(int budget){
		super("予算（" + budget + "）が最小金額未満です。");
	}
	
}
