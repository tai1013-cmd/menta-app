package menta.app.model.suggest;

import lombok.Getter;
import menta.app.model.suggest.exception.SuggestDetailMaxLengthException;
import menta.app.model.suggest.exception.SuggestDetailNullException;
import menta.app.model.valueObject.Id;

@Getter
public class SuggestModel {
	
	private Id suggestId = null;
	private Id referPlanId = null;
	private String detail = "";
	
	/**
	 * 内容：最大文字数
	 */
	private final static Integer DETAIL_MAX_LENGTH = 2000;
	
	/**
	 *  コンストラクタ
	 *  @param suggestId 提案ID
	 *  @param referPlanId 参照プランID
	 *  @param detail 内容
	 */
	public SuggestModel(Id suggestId,
			Id referPlanId,
			String detail
			) {
		//チェック
		checkDetail(detail);
		
		this.suggestId = suggestId;
		this.referPlanId = referPlanId;
		this.detail = detail;
	}
	
	/**
	 *  内容を設定する
	 *  @param detail 内容
	 */
	public void setDetail(String detail) {
		
		// チェック
		checkDetail(detail);
		this.detail = detail;
	}
	
	private void checkDetail(String detail) {
		
		if(detail == null || detail.length() == 0) {
			throw new SuggestDetailNullException();
		}
		if(detail.length() > DETAIL_MAX_LENGTH) {
			throw new SuggestDetailMaxLengthException(detail);
		}
		
	}
	
}
