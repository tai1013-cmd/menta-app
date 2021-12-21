package menta.app.dao.tag;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import menta.app.dao.tag.dataModel.TagDataModel;

/**
 * タグマスタのDAOクラス
 */
public interface TagDao {
	
	/**
	 * タグ一覧情報を取得する
	 * 
	 */
	List<TagDataModel> selectList();
	
	/**
	 * タグIDに紐付くタグ情報を取得する
	 * 
	 * @param tagId タグID
	 */
	TagDataModel selectOneByTagId(@Param("tagId") String tagId);
	
	/**
	 * タグテーブルに登録する
	 * 
	 * @param tagDataModel タグデータモデル
	 */
	void insert(TagDataModel tagDataModel);
	
	/**
	 * タグテーブルの更新する
	 * 
	 * @param tagDataModel タグデータモデル
	 */
	void update(TagDataModel tagDataModel);
	
	/**
	 * タグテーブルを論理削除する
	 * 
	 * @param tagId タグID
	 */
	void delete(@Param("tagId") String tagId);
	
}
