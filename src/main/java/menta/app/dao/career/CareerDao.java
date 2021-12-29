package menta.app.dao.career;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import menta.app.dao.career.dataModel.CareerDataModel;

/**
 * 経歴テーブルのDAOクラス
 */
@Mapper
public interface CareerDao {
	
	/**
	 * 経歴テーブルからユーザIDに紐づく経歴情報一覧を取得する
	 * 
	 * @param referUserId 参照ユーザーID
	 * 
	 */
	List<CareerDataModel> selectListByUserId(@Param("referUserId") String referUserId);
	
	/**
	 * 経歴テーブルから経歴IDに紐付く経歴情報を取得する
	 * 
	 * @param careerId 経歴ID
	 */
	CareerDataModel selectOneByCareerId(@Param("careerId") String careerId);
	
	/**
	 * 経歴テーブルに登録する
	 * 
	 * @param careerDataModel 経歴データモデル
	 */
	void insert(CareerDataModel careerDataModel);

	/**
	 * 経歴テーブルを更新する
	 * 
	 * @param careerDataModel 経歴データモデル
	 */
	void update(CareerDataModel careerDataModel);
	
	/**
	 * 経歴テーブルを物理削除する
	 * 
	 * @param careerId 経歴ID
	 */
	void delete(@Param("careerId") String careerId);
	
}
