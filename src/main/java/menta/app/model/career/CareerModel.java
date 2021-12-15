package menta.app.model.career;
import java.time.LocalDate;

import lombok.Getter;
import menta.app.model.career.exception.CareerYearFromToRelationshipException;
import menta.app.model.career.exception.CareerYearMaxException;
import menta.app.model.career.exception.CareerYearMinException;
import menta.app.model.valueObject.Id;

@Getter
public class CareerModel {
	
	private Id careerId = null;
	private String detail = "";
	private Integer yearStart = null;
	private Integer yearEnd = null;
	private Id referUserId = null;

	/**
	 * 西暦FROM：最小年度
	 */
	private final static Integer YEAR_FROM_MIN_VALUE = 1970;
	
	/**
	 *  コンストラクタ
	 *  @param careerId 経歴ID
	 *  @param detail 詳細
	 *  @param yearFrom　西暦FROM
	 *  @param yearTo 西暦TO
	 *  @param referUserId　担当ユーザーID
	 */
	public CareerModel(Id careerId,
			String detail,
			int yearStart,
			int yearEnd,
			Id referUserId
			) {
		
		// チェック
		checkTerm(yearStart, yearEnd);
		
		this.careerId = careerId;
		this.detail = detail;
		this.yearStart = yearStart;
		this.yearEnd = yearEnd;
		this.referUserId = referUserId;
	}
	
	/**
	 *  西暦チェック
	 *  @param yearFrom　西暦FROM
	 *  @param yearTo 西暦TO
	 */
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
		if(yearTo > yearFrom) {
			throw new CareerYearFromToRelationshipException(yearFrom, yearTo);
		}
	}

}
