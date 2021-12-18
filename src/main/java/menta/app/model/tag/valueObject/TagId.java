package menta.app.model.tag.valueObject;

import lombok.Getter;
import menta.app.model.valueObject.Id;

@Getter
public class TagId extends Id{
	
	/**
	 *  コンストラクタ
	 */
	public TagId() {
		super();
	}
	
	/**
	 *  コンストラクタ
	 *  @param Id ID
	 */
	public TagId(String id) {
		super(id);
	}
	
}
