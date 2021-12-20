package menta.app.model.skill.exception;

public class SkillYearMinException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public SkillYearMinException(int year){
		
		super("スキル年数(" + year + ")にマイナスが設定されています。");
	}
	
}
