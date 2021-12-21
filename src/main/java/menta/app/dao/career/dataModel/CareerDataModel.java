package menta.app.dao.career.dataModel;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import menta.app.model.career.CareerModel;

/**
 * 経歴テーブルの情報を格納するクラス
 */
@Getter
public class CareerDataModel implements java.io.Serializable {

	private static final long serialVersionUID = 7077371391430134074L;

	/**
	 * 経歴ID
	 */
	private String id;

	/**
	 * 詳細
	 */
	private String detail;
	
	/**
	 * 西暦FROM
	 */
	private Integer yearFrom;
	
	/**
	 * 西暦TO
	 */
	private Integer yearTo;
	
	/**
	 * 参照ユーザーID
	 */
	private String referUserId;
	
	/**
	 * レコード作成日時
	 */
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime createdAt;

	/**
	 * レコード更新日時
	 */
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime updatedAt;

	/**
	 * 削除フラグ
	 */
	private int isDeleted = 0;
	
	/**
	 * コンストラクタ
	 * @param careerModel 経歴モデル
	 */
	public CareerDataModel(CareerModel careerModel) {
		this.id = careerModel.getCareerId().getId();
		this.detail = careerModel.getDetail();
		this.yearFrom = careerModel.getYearFrom();
		this.yearTo = careerModel.getYearTo();
		this.referUserId = careerModel.getReferUserId().getId();
	}
	
}

