package menta.app.model.skill.valueObject;

import lombok.Getter;
import menta.app.model.valueObject.Id;

@Getter
public class SkillId extends Id{
	
	/**
	 *  コンストラクタ
	 */
	public SkillId() {
		super();
	}
	
	/**
	 *  コンストラクタ
	 *  @param Id ID
	 */
	public SkillId(String id) {
		super(id);
	}
	
}
