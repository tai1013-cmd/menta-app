package menta.app.model.valueObject;
import lombok.Getter;
import menta.app.model.user.exception.UserPropertyMaxLengthException;
import menta.app.model.user.exception.UserPropertyNullException;
import menta.app.model.valueObject.exception.IdNullException;

@Getter
public class Id {
	
	private String id = "";
	
	/**
	 *  コンストラクタ
	 *  @param id モデルID
	 */
	public Id(String id) {
		
		// チェック
		checkId(id);
		this.id = id;
	}
	

	/**
	 *  IDチェック
	 *  @param id モデルID
	 */
	private void checkId(String id) {
		// 必須チェック
		if(id == null || id.length() == 0) {
			throw new IdNullException();
		}
	}
    
}
