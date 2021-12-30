package menta.app.dao.plan;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import menta.app.dao.plan.dataModel.PlanDataModel;

@Mapper
public interface PlanDao {

	/**
	 * プラン公開しているユーザーID一覧を取得する（新着順）
	 * 
	 */
	List<String> selectUserIdListCreatedDesc();
	
	/**
	 * プランIDに紐付くプラン情報を取得する
	 * 
	 * @param planId プランID
	 */
	PlanDataModel selectOneByPlanId(@Param("planId") String planId);
	
	/**
	 * ユーザーIDに紐付くプラン情報を取得する
	 * 
	 * @param userId ユーザーID
	 */
	List<PlanDataModel> selectListByUserId(@Param("referUserId") String referUserId);
	
	/**
	 * プランテーブルに登録する
	 * 
	 * @param planDataModel プランデータモデル
	 */
	void insert(PlanDataModel planDataModel);
	
	/**
	 * プランテーブルを論理削除する
	 * 
	 * @param planId プランID
	 */
	void delete(@Param("planId") String planId);
	
}
