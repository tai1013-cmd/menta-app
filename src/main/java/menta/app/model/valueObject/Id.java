package menta.app.model.valueObject;
import java.util.UUID;

import lombok.Getter;
import menta.app.model.valueObject.exception.IdNullException;

@Getter
public class Id {
	
	private String id = "";
	
	/**
	 *  コンストラクタ
	 */
	public Id() {
		
		// UUID生成
		UUID uuid = UUID.randomUUID();
		this.id = uuid.toString();
	}
	
	/**
	 *  コンストラクタ
	 *  @param ID
	 */
	public Id(String id) {
		
		//チェック
		checkId(id);
		this.id = id;
	}
	
	private void checkId(String id) {
		// 必須チェック
		if(id == null || id.length() == 0) {
			throw new IdNullException();
		}
	}
    
}
