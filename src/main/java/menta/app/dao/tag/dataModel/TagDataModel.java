package menta.app.dao.tag.dataModel;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import menta.app.model.tag.TagModel;

/**
 * タグテーブルの情報を格納するクラス
 */
@Getter
public class TagDataModel implements java.io.Serializable {

	private static final long serialVersionUID = 968618309374618415L;

	/**
	 * タグID
	 */
	private String id;

	/**
	 * タグ名称
	 */
	private String name;
	
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
	 * @param tagModel タグモデル
	 */
	public TagDataModel(TagModel tagModel) {
		this.id = tagModel.getTagId().getId();
		this.name = tagModel.getTagName();
	}
	
}
