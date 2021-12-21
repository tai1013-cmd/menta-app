package menta.app.dao.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import menta.app.dao.category.dataModel.CategoryDataModel;

/**
 * カテゴリーマスタのDAOクラス
 */
public interface CatagoryDao {

	/**
	 * カテゴリー一覧情報を取得する
	 * 
	 */
	List<CategoryDataModel> selectList();
	
	/**
	 * カテゴリーIDに紐付くカテゴリー情報を取得する
	 * 
	 * @param categoryId カテゴリーID
	 */
	CategoryDataModel selectOneByCategoryId(@Param("categoryId") String categoryId);
	
	/**
	 * カテゴリーテーブルに登録する
	 * 
	 * @param categoryDataModel カテゴリーデータモデル
	 */
	void insert(CategoryDataModel categoryDataModel);
	
	/**
	 * カテゴリーテーブルの更新する
	 * 
	 * @param categoryDataModel カテゴリーデータモデル
	 */
	void update(CategoryDataModel categoryDataModel);
	
	/**
	 * カテゴリーテーブルの物理削除する
	 * 
	 * @param categoryId カテゴリーID
	 */
	void delete(@Param("categoryId") String categoryId);
	
}
