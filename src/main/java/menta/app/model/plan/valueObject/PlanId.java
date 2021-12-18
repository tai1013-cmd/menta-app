package menta.app.model.plan.valueObject;

import lombok.Getter;
import menta.app.model.valueObject.Id;

@Getter
public class PlanId extends Id{
	
	/**
	 *  コンストラクタ
	 */
	public PlanId() {
		super();
	}
	
	/**
	 *  コンストラクタ
	 *  @param Id ID
	 */
	public PlanId(String id) {
		super(id);
	}
	
}
