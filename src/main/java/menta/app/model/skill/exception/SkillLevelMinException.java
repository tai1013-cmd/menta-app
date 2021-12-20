package menta.app.model.skill.exception;

public class SkillLevelMinException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; 
	
	public SkillLevelMinException(int level){
		
		super("スキルレベル(" + level + ")が最小値より少ないです。");
	}
	
}
