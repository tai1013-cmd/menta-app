package menta.app.model.category;
import lombok.Getter;
import menta.app.model.category.exception.CategoryNameNullException;
import menta.app.model.category.valueObject.CategoryId;

@Getter
public class CategoryModel {
	
	private CategoryId categoryId = null;
	private String categoryName = "";
	
	/**
	 *  コンストラクタ
	 *  @param categoryId タグID
	 *  @param categoryName タグ名
	 */
	public CategoryModel(CategoryId categoryId,
			String categoryName
			) {
		//チェック
		checkCategoryName(categoryName);
		
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		
	}
	
	private void checkCategoryName(String categoryName) {
		
		if(categoryName == null || categoryName.length() == 0) {
			throw new CategoryNameNullException();
		}
	}
	
}
