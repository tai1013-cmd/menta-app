package menta.app.model.career;
import java.time.LocalDate;

import lombok.Getter;
import menta.app.model.career.exception.CareerPropertyNullException;
import menta.app.model.career.exception.CareerYearFromToRelationshipException;
import menta.app.model.career.exception.CareerYearMaxException;
import menta.app.model.career.exception.CareerYearMinException;
import menta.app.model.user.UserModel;

@Getter
public class CareerModel {
	
	private String careerId = "";
	private String detail = "";
	private Integer yearStart = null;
	private Integer yearEnd = null;
	private UserModel referUser = null;

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
	 *  @param referUser　担当ユーザー
	 */
	public CareerModel(String careerId,
			String detail,
			int yearStart,
			int yearEnd,
			UserModel referUser
			) {
		
		// チェック
		checkCareerId(careerId);
		checkTerm(yearStart, yearEnd);
		checkUserModel(referUser);
		
		this.careerId = careerId;
		this.detail = detail;
		this.yearStart = yearStart;
		this.yearEnd = yearEnd;
		this.referUser = referUser;
	}
	
	/**
	 *  経歴IDチェック
	 *  @param recruitId 経歴ID
	 */
	private void checkCareerId(String recruitId) {
		
		String errMsglabel = "経歴ID";
		// 必須チェック
		if(recruitId == null || recruitId.length() == 0) {
			throw new CareerPropertyNullException(errMsglabel);
		}
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
	
	/**
	 *  担当ユーザーチェック
	 *  @param userModel 担当ユーザー
	 */
	private void checkUserModel(UserModel referUser) {
		
		String errMsglabel = "担当ユーザー";
		// 必須チェック
		if(referUser == null) {
			throw new CareerPropertyNullException(errMsglabel);
		}
	}
}
