package menta.app.model.category.valueObject;

import lombok.Getter;
import menta.app.model.valueObject.Id;

@Getter
public class CategoryId extends Id{
	
	/**
	 *  コンストラクタ
	 */
	public CategoryId() {
		super();
	}
	
	/**
	 *  コンストラクタ
	 *  @param Id ID
	 */
	public CategoryId(String id) {
		super(id);
	}
	
}
