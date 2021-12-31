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
	 * コンストラクタ
	 */
	public TagDataModel() {
	}
	
	/**
	 * コンストラクタ
	 * @param tagModel タグモデル
	 * @param createdAt 作成日時
	 */
	public TagDataModel(TagModel tagModel, LocalDateTime createdAt) {
		this.id = tagModel.getTagId().getId();
		this.name = tagModel.getTagName();
		this.createdAt = createdAt;
	}
	
}
