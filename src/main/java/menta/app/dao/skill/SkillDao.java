package menta.app.dao.skill;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import menta.app.dao.career.dataModel.CareerDataModel;
import menta.app.dao.skill.dataModel.SkillDataModel;

@Mapper
public interface SkillDao {

	/**
	 * ユーザIDに紐づくスキル情報一覧を取得する
	 * 
	 * @param referUserId　参照ユーザーID
	 * 
	 */
	List<SkillDataModel> selectListByUserId(@Param("referUserId") String referUserId);
	
	/**
	 * スキルIDに紐づくスキル情報を取得する
	 * 
	 * @param skillId　スキルID
	 */
	SkillDataModel selectOneBySkillId(@Param("skillId") String skillId);
	
	/**
	 * スキルテーブルに登録する
	 * 
	 * @param careerDataModel スキルデータモデル
	 */
	void insert(SkillDataModel skillDataModel);

	/**
	 * スキルテーブルを更新する
	 * 
	 * @param careerDataModel スキルデータモデル
	 */
	void update(SkillDataModel skillDataModel);
	
	/**
	 * スキルテーブルを論理削除する
	 * 
	 * @param skillId スキルID
	 */
	void delete(@Param("skillId") String skillId);
	
}
