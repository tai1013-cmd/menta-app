package menta.app.model.recruit;

import lombok.Getter;
import menta.app.model.recruit.exception.RecruitBudgetMinPriceException;
import menta.app.model.recruit.exception.RecruitDetailMaxLengthException;
import menta.app.model.recruit.exception.RecruitDetailNullException;
import menta.app.model.recruit.exception.RecruitStatusNullException;
import menta.app.model.recruit.exception.RecruitTitleMaxLengthException;
import menta.app.model.recruit.exception.RecruitTitleNullException;
import menta.app.model.recruit.exception.RecruitTypeNullException;

@Getter
public class RecruitModel {

	private String recruitId = "";
	private String title = "";
	private String detail = "";
	private Integer budget = null; 
	private Type type = null;
	private Status status = null;
	
	/**
	 *  タイプ（単発、月額）
	 */
	public enum Type {
		MONTH,
	    SINGLE
	};
	
	/**
	 *  ステータス（下書き、公開、募集終了）
	 */
	public enum Status {
		DRAFT,
	    OPEN,
	    END
	};
	
	/**
	 * タイトル：最大文字数
	 */
	private static final Integer TITLE_MAX_LENGTH = 255;
	
	/**
	 * 詳細：最大文字数
	 */
	private static final Integer DETAIL_MAX_LENGTH = 3000;
	
	/**
	 * 予算：最低金額
	 */
	private static final Integer BUDGET_MIN_PRICE = 1000;
	
	/**
	 *  コンストラクタ
	 *  @param recruitId 募集ID
	 *  @param title タイトル
	 *  @param detail 詳細
	 *  @param budget 予算
	 *  @param type　タイプ
	 *  @param status ステータス
	 */
	public RecruitModel(String recruitId,
			String title,
			String detail,
			int budget,
			Type type,
			Status status
			) {
		
		// チェック
		checkTitle(title);
		checkDetail(title);
		checkBudget(budget);
		checkType(type);
		checkStatus(status);
		
		this.recruitId = recruitId;
		this.title = title;
		this.detail = detail;
		this.budget = budget;
		this.type = type;
		this.status = status;
		
	}

	/**
	 * 詳細を設定する
	 * @param detail
	 */
	public void changeDetail(String detail) {
		checkDetail(detail);
		this.detail = detail;
	}
	
	/**
	 * 予算を設定する
	 * @param budget
	 */
	public void changeBudget(int budget) {
		checkBudget(budget);
		this.budget = budget;
	}
	
	/**
	 * ステータスを設定する
	 * @param status
	 */
	public void changeStatus(Status status) {
		checkStatus(status);
		this.status = status;
	}
	
	/**
	 * タイプを設定する
	 * @param type
	 */
	public void changeType(Type type) {
		checkType(type);
		this.type = type;
	}
	
	
	private void checkTitle(String title) {
		
		if(title == null || title.length() == 0) {
			throw new RecruitTitleNullException();
		}
		if(title.length() > TITLE_MAX_LENGTH) {
			throw new RecruitTitleMaxLengthException(title);
		}
		
	}
	
	private void checkDetail(String detail) {
		
		if(detail == null || detail.length() == 0) {
			throw new RecruitDetailNullException();
		}
		if(detail.length() > DETAIL_MAX_LENGTH) {
			throw new RecruitDetailMaxLengthException(detail);
		}
		
	}
	
	private void checkBudget(int budget) {
		
		if(budget < BUDGET_MIN_PRICE) {
			throw new RecruitBudgetMinPriceException(budget);
		}
		
	}
	
	private void checkType(Type type) {
		
		if(type == null) {
			throw new RecruitTypeNullException();
		}
		
	}

	private void checkStatus(Status status) {
		
		if(status == null) {
			throw new RecruitStatusNullException();
		}
		
	}

}
