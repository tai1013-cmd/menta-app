package menta.app.dao.recruitMentor;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import menta.app.dao.recruitMentor.dataModel.RecruitMentorDataModel;

/**
 * メンター募集マスタのDAOクラス
 */
public interface RecruitMentorDao {
	
	/**
	 * ユーザIDに紐づくメンター募集情報一覧を取得する
	 * 
	 * @param referUserId 参照ユーザーID
	 * 
	 */
	List<RecruitMentorDataModel> selectListByUserId(@Param("referUserId") String referUserId);
	
	/**
	 * メンター募集IDに紐付くメンター募集情報を取得する
	 * 
	 * @param recruitMentorId メンター募集ID
	 */
	RecruitMentorDataModel selectOneByRecruitMentorId(@Param("recruitMentorId") String recruitMentorId);
	
	/**
	 * メンター募集テーブルに登録する
	 * 
	 * @param recruitMentorDataModel メンター募集データモデル
	 */
	void insert(RecruitMentorDataModel recruitMentorDataModel);
	
	/**
	 * メンター募集テーブルの更新する
	 * 
	 * @param recruitMentorDataModel メンター募集データモデル
	 */
	void update(RecruitMentorDataModel recruitMentorDataModel);
	
	/**
	 * メンター募集テーブルを論理削除する
	 * 
	 * @param recruitMentorId メンター募集ID
	 */
	void delete(@Param("recruitMentorId") String recruitMentorId);
	
}
