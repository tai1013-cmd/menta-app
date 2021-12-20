package menta.app.model.career.valueObject;

import lombok.Getter;
import menta.app.model.valueObject.Id;

@Getter
public class CareerId extends Id{
	
	/**
	 *  コンストラクタ
	 */
	public CareerId() {
		super();
	}
	
	/**
	 *  コンストラクタ
	 *  @param Id ID
	 */
	public CareerId(String id) {
		super(id);
	}
	
}
