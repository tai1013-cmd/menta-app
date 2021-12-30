package menta.app.model.career;
import java.time.LocalDate;

import lombok.Getter;
import menta.app.model.career.exception.CareerDetailMaxLengthException;
import menta.app.model.career.exception.CareerDetailNullException;
import menta.app.model.career.exception.CareerYearFromToRelationshipException;
import menta.app.model.career.exception.CareerYearMaxException;
import menta.app.model.career.exception.CareerYearMinException;
import menta.app.model.career.valueObject.CareerId;
import menta.app.model.user.valueObject.UserId;

@Getter
public class CareerModel {
	
	private CareerId careerId = null;
	private String detail = "";
	private Integer yearFrom = null;
	private Integer yearTo = null;
	private UserId referUserId = null;

	/**
	 * 西暦FROM：最小年度
	 */
	private final static Integer YEAR_FROM_MIN_VALUE = 1970;
	/**
	 * 詳細：最大文字数
	 */
	private static final Integer DETAIL_MAX_LENGTH = 1000;
	
	/**
	 *  コンストラクタ
	 *  @param careerId 経歴ID
	 *  @param detail 詳細
	 *  @param yearFrom　西暦FROM
	 *  @param yearTo 西暦TO
	 *  @param referUserId　担当ユーザーID
	 */
	public CareerModel(CareerId careerId,
			String detail,
			int yearFrom,
			int yearTo,
			UserId referUserId
			) {
		
		// チェック
		checkTerm(yearFrom, yearTo);
		changeDetail(detail);
		
		this.careerId = careerId;
		this.detail = detail;
		this.yearFrom = yearFrom;
		this.yearTo = yearTo;
		this.referUserId = referUserId;
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
	 *  西暦を設定する
	 *  @param yearFrom　西暦FROM
	 *  @param yearTo 西暦TO
	 */
	public void changeDetail(int yearFrom, int yearTo) {
		checkTerm(yearFrom, yearTo);
		this.yearFrom = yearFrom;
		this.yearTo = yearTo;
	}
	
	private void checkTerm(int yearFrom, int yearTo) {
		// 最小チェック
		if(yearFrom < YEAR_FROM_MIN_VALUE) {
			throw new CareerYearMinException(yearFrom);
		}
		if(yearTo < YEAR_FROM_MIN_VALUE) {
			throw new CareerYearMinException(yearTo);
		}
		// 最大チェック
		LocalDate currentDate = LocalDate.now();
		if(yearFrom > currentDate.getYear()) {
			throw new CareerYearMaxException(yearFrom);
		}
		if(yearTo > currentDate.getYear()) {
			throw new CareerYearMaxException(yearTo);
		}
		// 大小チェック
		if(yearTo < yearFrom) {
			throw new CareerYearFromToRelationshipException(yearFrom, yearTo);
		}
	}
	
	private void checkDetail(String detail) {
		
		if(detail == null || detail.length() == 0) {
			throw new CareerDetailNullException();
		}
		if(detail.length() > DETAIL_MAX_LENGTH) {
			throw new CareerDetailMaxLengthException(detail);
		}
		
	}

}
