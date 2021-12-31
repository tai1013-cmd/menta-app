package menta.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import menta.app.dao.proposal.ProposalDao;
import menta.app.dao.proposal.dataModel.ProposalDataModel;
import menta.app.model.proposal.ProposalModel;
import menta.app.model.proposal.valueObject.ProposalId;
import menta.app.model.recruitmentor.valueObject.RecruitMentorId;
import menta.app.model.user.valueObject.UserId;
@SpringJUnitConfig(locations = "classpath:test-context.xml")
@SpringBootTest
@MapperScan("menta.app.dao")
@ExtendWith(SpringExtension.class)
public class TestProposalDao {

	@Autowired
	private ProposalDao proposalDao;
	
	@Test 
    public void test() {
		
		ProposalDataModel insertProposalDataModel = setInsertData();
		
		// 実行（新規登録）
		proposalDao.insert(insertProposalDataModel);
		
		// 実行（検索）
		ProposalDataModel getProposalDataModelByProposalId = proposalDao.selectOneByProposalId(insertProposalDataModel.getId());
		
		assertNotNull(getProposalDataModelByProposalId.getId());
		assertNotNull(getProposalDataModelByProposalId.getReferRecruitMentorId());
		assertNotNull(getProposalDataModelByProposalId.getReferUserId());
		assertNotNull(getProposalDataModelByProposalId.getDetail());
		assertNotNull(getProposalDataModelByProposalId.getCreatedAt());
		assertNotNull(getProposalDataModelByProposalId.getUpdatedAt());
		
		assertEquals(insertProposalDataModel.getId(), getProposalDataModelByProposalId.getId());
		assertEquals(insertProposalDataModel.getReferRecruitMentorId(), getProposalDataModelByProposalId.getReferRecruitMentorId());
		assertEquals(insertProposalDataModel.getReferUserId(), getProposalDataModelByProposalId.getReferUserId());
		assertEquals(insertProposalDataModel.getDetail(), getProposalDataModelByProposalId.getDetail());
		assertEquals(insertProposalDataModel.getCreatedAt(), getProposalDataModelByProposalId.getCreatedAt());
		assertEquals(insertProposalDataModel.getUpdatedAt(), getProposalDataModelByProposalId.getUpdatedAt());
		
		// 実行（更新登録）
		ProposalDataModel updateProposalDataModel = setUpdateData(getProposalDataModelByProposalId);
		proposalDao.update(updateProposalDataModel);
		
		// 実行（検索）
		ProposalDataModel getProposalDataModelByMentorId = proposalDao.selectOneByRecruitMentorId(insertProposalDataModel.getReferRecruitMentorId());
		
		assertEquals(updateProposalDataModel.getId(), getProposalDataModelByMentorId.getId());
		assertEquals(updateProposalDataModel.getReferRecruitMentorId(), getProposalDataModelByMentorId.getReferRecruitMentorId());
		assertEquals(updateProposalDataModel.getReferUserId(), getProposalDataModelByMentorId.getReferUserId());
		assertEquals(updateProposalDataModel.getDetail(), getProposalDataModelByMentorId.getDetail());
		assertEquals(updateProposalDataModel.getCreatedAt(), getProposalDataModelByMentorId.getCreatedAt());
		assertEquals(updateProposalDataModel.getUpdatedAt(), getProposalDataModelByMentorId.getUpdatedAt());
		
		// 実行（削除）
		proposalDao.delete(insertProposalDataModel.getId());
		ProposalDataModel delProposalDataModelById =  proposalDao.selectOneByProposalId(insertProposalDataModel.getId());
		assertNull(delProposalDataModelById);
		
	}
	
	private ProposalDataModel setInsertData() {
		
		ProposalId proposalId = new ProposalId();
		RecruitMentorId recruitMentorId = new RecruitMentorId();
		UserId userId = new UserId();
		String detail = "詳細";
		LocalDateTime createdAt = LocalDateTime.now();
		LocalDateTime updatedAt = LocalDateTime.now();
	    
		ProposalModel insertProposalModel = new ProposalModel(proposalId,
				recruitMentorId,
				detail);
		
		ProposalDataModel insertProposalDataModel = new ProposalDataModel(insertProposalModel,
				userId,
				createdAt,
				updatedAt);
		
		return insertProposalDataModel;
	}
	
	private ProposalDataModel setUpdateData(ProposalDataModel proposalDataModel) {
		
		ProposalId proposalId = new ProposalId(proposalDataModel.getId());
		RecruitMentorId recruitMentorId = new RecruitMentorId(proposalDataModel.getReferRecruitMentorId());
		UserId userId = new UserId(proposalDataModel.getReferUserId());
		String detail = "upd詳細";
		LocalDateTime createdAt = proposalDataModel.getCreatedAt();
		LocalDateTime updatedAt = LocalDateTime.now();
	    
		ProposalModel insertProposalModel = new ProposalModel(proposalId,
				recruitMentorId,
				detail);
		
		ProposalDataModel insertProposalDataModel = new ProposalDataModel(insertProposalModel,
				userId,
				createdAt,
				updatedAt);
		
		return insertProposalDataModel;
	}
	
}
