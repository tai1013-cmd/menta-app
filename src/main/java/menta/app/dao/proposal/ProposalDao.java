package menta.app.dao.proposal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import menta.app.dao.proposal.dataModel.ProposalDataModel;

/**
 * メンター提案マスタのDAOクラス
 */
@Mapper
public interface ProposalDao {

	/**
	 * メンター募集IDに紐付くメンター提案情報を取得する
	 * 
	 * @param referRecruitMentorId 参照メンター募集ID
	 */
	ProposalDataModel selectOneByRecruitMentorId(@Param("referRecruitMentorId") String referRecruitMentorId);	
	/**
	 * 提案IDに紐付く提案情報を取得する
	 * 
	 * @param proposalId 提案ID
	 */
	ProposalDataModel selectOneByProposalId(@Param("proposalId") String proposalId);
	
	/**
	 * メンター提案テーブルに登録する
	 * 
	 * @param proposalDataModel 提案データモデル
	 */
	void insert(ProposalDataModel proposalDataModel);
	
	/**
	 * メンター提案テーブルの更新する
	 * 
	 * @param proposalDataModel 提案データモデル
	 */
	void update(ProposalDataModel proposalDataModel);
	
	/**
	 * メンター提案テーブルを論理削除する
	 * 
	 * @param proposalId 提案ID
	 */
	void delete(@Param("proposalId") String proposalId);
	
}
