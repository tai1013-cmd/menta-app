package menta.app.dao.category.dataModel;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import menta.app.model.category.CategoryModel;

@Getter
public class CategoryDataModel implements java.io.Serializable {

	private static final long serialVersionUID = 1926897340430443507L;

	/**
	 * カテゴリーID
	 */
	private String id;

	/**
	 * カテゴリー名称
	 */
	private String name;
	
	/**
	 * レコード作成日時
	 */
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime createdAt;
	
	public CategoryDataModel() {
		
	}

	/**
	 * コンストラクタ
	 * @param categoryModel カテゴリーモデル
	 */
	public CategoryDataModel(CategoryModel categoryModel, LocalDateTime createdAt) {
		this.id = categoryModel.getCategoryId().getId();
		this.name = categoryModel.getCategoryName();
		this.createdAt = createdAt;
	}
	
}
