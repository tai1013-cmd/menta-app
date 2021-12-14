package menta.app.model.user.valueObject;
import lombok.Getter;
import menta.app.model.user.exception.UserPropertyMaxLengthException;
import menta.app.model.user.exception.UserPropertyNullException;

@Getter
public class FullName {
	
	private String sei = "";
	private String mei = "";
	
	/**
	 * 氏名：最大文字数
	 */
	private final static Integer FULL_NAME_MAX_LENGTH = 255;
	
	/**
	 *  コンストラクタ
	 *  @param sei 姓
	 *  @param mei 名
	 */
	public FullName(String sei, String mei) {
		
		// チェック
		checkNameFull(sei, mei);
		this.sei = sei;
		this.mei = mei;
	}
	
	/**
	 *  氏名チェック
	 *  @param sei 姓
	 *  @param mei 名
	 */
	private void checkNameFull(String sei, String mei) {
		
		String errMsglabel1 = "氏名（姓）";
		String errMsglabel2 = "氏名（名）";
		String errMsglabel3 = "氏名（姓・名）";
		// 必須チェック
		if(sei == null || sei.length() == 0) {
			throw new UserPropertyNullException(errMsglabel1);
		}
		if(mei == null || mei.length() == 0) {
			throw new UserPropertyNullException(errMsglabel2);
		}
		// 桁数チェック
		String fullName = sei + mei;
		if(fullName.length() > FULL_NAME_MAX_LENGTH) {
			throw new UserPropertyMaxLengthException(errMsglabel3, fullName);
		}
	}
    
}
