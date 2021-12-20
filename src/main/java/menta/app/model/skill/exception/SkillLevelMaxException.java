package menta.app.model.skill.exception;

public class SkillLevelMaxException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public SkillLevelMaxException(int level){
		
		super("スキルレベル(" + level + ")が最大値を超えています。");
	}
	
}
