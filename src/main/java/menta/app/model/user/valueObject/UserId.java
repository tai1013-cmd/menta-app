package menta.app.model.user.valueObject;

import lombok.Getter;
import menta.app.model.valueObject.Id;

@Getter
public class UserId extends Id{
	
	/**
	 *  コンストラクタ
	 */
	public UserId() {
		super();
	}
	
	/**
	 *  コンストラクタ
	 *  @param Id ID
	 */
	public UserId(String id) {
		super(id);
	}
	
}
