package menta.app.model.recruit;
import java.time.LocalDate;

import lombok.Getter;
import menta.app.model.recruit.exception.RecruitPropertyNullException;
import menta.app.model.recruit.exception.RecruitYearFromToRelationshipException;
import menta.app.model.recruit.exception.RecruitYearMaxException;
import menta.app.model.recruit.exception.RecruitYearMinException;
import menta.app.model.user.UserModel;

@Getter
public class RecruitModel {
	
	private String recruitId = "";
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
	 *  @param recruitId 経歴ID
	 *  @param detail 詳細
	 *  @param yearFrom　西暦FROM
	 *  @param yearTo 西暦TO
	 *  @param referUser　担当ユーザー
	 */
	public RecruitModel(String recruitId,
			String detail,
			int yearStart,
			int yearEnd,
			UserModel referUser
			) {
		
		// チェック
		checkRecruitId(recruitId);
		checkTerm(yearStart, yearEnd);
		checkUserModel(referUser);
		
		this.recruitId = recruitId;
		this.detail = detail;
		this.yearStart = yearStart;
		this.yearEnd = yearEnd;
		this.referUser = referUser;
	}
	
	/**
	 *  経歴IDチェック
	 *  @param recruitId 経歴ID
	 */
	private void checkRecruitId(String recruitId) {
		
		String errMsglabel = "経歴ID";
		// 必須チェック
		if(recruitId == null || recruitId.length() == 0) {
			throw new RecruitPropertyNullException(errMsglabel);
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
			throw new RecruitYearMinException(yearFrom);
		}
		if(yearTo < YEAR_FROM_MIN_VALUE) {
			throw new RecruitYearMinException(yearTo);
		}
		// 最大チェック
		LocalDate currentDate = LocalDate.now();
		if(yearFrom > currentDate.getYear()) {
			throw new RecruitYearMaxException(yearFrom);
		}
		if(yearTo > currentDate.getYear()) {
			throw new RecruitYearMaxException(yearTo);
		}
		// 大小チェック
		if(yearTo > yearFrom) {
			throw new RecruitYearFromToRelationshipException(yearFrom, yearTo);
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
			throw new RecruitPropertyNullException(errMsglabel);
		}
	}
}
