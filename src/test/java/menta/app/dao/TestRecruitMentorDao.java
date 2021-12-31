package menta.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import menta.app.dao.recruitMentor.RecruitMentorDao;
import menta.app.dao.recruitMentor.dataModel.RecruitMentorDataModel;
import menta.app.model.recruitmentor.valueObject.RecruitMentorId;
import menta.app.model.user.valueObject.UserId;
import menta.app.model.recruitmentor.RecruitMentorModel;
@SpringJUnitConfig(locations = "classpath:test-context.xml")
@SpringBootTest
@MapperScan("menta.app.dao")
@ExtendWith(SpringExtension.class)
public class TestRecruitMentorDao {

	@Autowired
	private RecruitMentorDao recruitMentorDao;
	
	@Test 
    public void test() {
		
		RecruitMentorDataModel insertRecruitMentorDataModel = setInsertData();
		
		// 実行（新規登録）
		recruitMentorDao.insert(insertRecruitMentorDataModel);
		
		// 実行（検索）
		RecruitMentorDataModel getRecruitMentorDataModelByRecruitMentorId = recruitMentorDao.selectOneByRecruitMentorId(insertRecruitMentorDataModel.getId());
		
		assertNotNull(getRecruitMentorDataModelByRecruitMentorId.getId());
		assertNotNull(getRecruitMentorDataModelByRecruitMentorId.getReferUserId());
		assertNotNull(getRecruitMentorDataModelByRecruitMentorId.getTitle());
		assertNotNull(getRecruitMentorDataModelByRecruitMentorId.getDetail());
		assertNotNull(getRecruitMentorDataModelByRecruitMentorId.getStatus());
		assertNotNull(getRecruitMentorDataModelByRecruitMentorId.getType());
		assertNotNull(getRecruitMentorDataModelByRecruitMentorId.getCreatedAt());
		assertNotNull(getRecruitMentorDataModelByRecruitMentorId.getUpdatedAt());
		
		assertEquals(insertRecruitMentorDataModel.getId(), getRecruitMentorDataModelByRecruitMentorId.getId());
		assertEquals(insertRecruitMentorDataModel.getReferUserId(), getRecruitMentorDataModelByRecruitMentorId.getReferUserId());
		assertEquals(insertRecruitMentorDataModel.getTitle(), getRecruitMentorDataModelByRecruitMentorId.getTitle());
		assertEquals(insertRecruitMentorDataModel.getDetail(), getRecruitMentorDataModelByRecruitMentorId.getDetail());
		assertEquals(insertRecruitMentorDataModel.getStatus(), getRecruitMentorDataModelByRecruitMentorId.getStatus());
		assertEquals(insertRecruitMentorDataModel.getType(), getRecruitMentorDataModelByRecruitMentorId.getType());
		assertEquals(insertRecruitMentorDataModel.getCreatedAt(), getRecruitMentorDataModelByRecruitMentorId.getCreatedAt());
		assertEquals(insertRecruitMentorDataModel.getUpdatedAt(), getRecruitMentorDataModelByRecruitMentorId.getUpdatedAt());
		
		// 実行（更新登録）
		RecruitMentorDataModel updateRecruitMentorDataModel = setUpdateData(getRecruitMentorDataModelByRecruitMentorId);
		recruitMentorDao.update(updateRecruitMentorDataModel);
		
		// 実行（検索）
		getRecruitMentorDataModelByRecruitMentorId = recruitMentorDao.selectOneByRecruitMentorId(insertRecruitMentorDataModel.getId());
				
		assertEquals(updateRecruitMentorDataModel.getId(), getRecruitMentorDataModelByRecruitMentorId.getId());
		assertEquals(updateRecruitMentorDataModel.getReferUserId(), getRecruitMentorDataModelByRecruitMentorId.getReferUserId());
		assertEquals(updateRecruitMentorDataModel.getTitle(), getRecruitMentorDataModelByRecruitMentorId.getTitle());
		assertEquals(updateRecruitMentorDataModel.getDetail(), getRecruitMentorDataModelByRecruitMentorId.getDetail());
		assertEquals(updateRecruitMentorDataModel.getStatus(), getRecruitMentorDataModelByRecruitMentorId.getStatus());
		assertEquals(updateRecruitMentorDataModel.getType(), getRecruitMentorDataModelByRecruitMentorId.getType());
		assertEquals(updateRecruitMentorDataModel.getCreatedAt(), getRecruitMentorDataModelByRecruitMentorId.getCreatedAt());
		assertEquals(updateRecruitMentorDataModel.getUpdatedAt(), getRecruitMentorDataModelByRecruitMentorId.getUpdatedAt());

		// 実行（一覧検索）
		List<RecruitMentorDataModel> getRecruitMentorDataModelListByUserId = recruitMentorDao.selectListByUserId(insertRecruitMentorDataModel.getReferUserId());
		assertNotNull(getRecruitMentorDataModelListByUserId);
		
		// 実行（一覧検索）
		List<RecruitMentorDataModel> getList = recruitMentorDao.selectList();
		assertNotNull(getList);
		
		// 実行（削除）
		recruitMentorDao.delete(insertRecruitMentorDataModel.getId());
		RecruitMentorDataModel delRecruitMentorDataModelById =  recruitMentorDao.selectOneByRecruitMentorId(insertRecruitMentorDataModel.getId());
		assertNull(delRecruitMentorDataModelById);
		
	}
	
	private RecruitMentorDataModel setInsertData() {
		
		RecruitMentorId recruitMentorId = new RecruitMentorId();
		UserId userId = new UserId();
		String title = "タイトル";
		String detail = "詳細";
		int budget = 3000;
		RecruitMentorModel.Status status = RecruitMentorModel.Status.DRAFT;
		RecruitMentorModel.Type type = RecruitMentorModel.Type.SINGLE;
		LocalDateTime createdAt = LocalDateTime.now();
		LocalDateTime updatedAt = LocalDateTime.now();	    
		
		RecruitMentorModel insertRecruitMentorModel = new RecruitMentorModel(recruitMentorId,
				title,
				detail,
				budget,
				type,
				status);
		
		RecruitMentorDataModel insertRecruitMentorDataModel = new RecruitMentorDataModel(insertRecruitMentorModel,
				userId,
				createdAt,
				updatedAt);
		
		return insertRecruitMentorDataModel;
	}
	
	private RecruitMentorDataModel setUpdateData(RecruitMentorDataModel recruitMentorDataModel) {
		
		RecruitMentorId recruitMentorId = new RecruitMentorId(recruitMentorDataModel.getId());
		UserId userId = new UserId(recruitMentorDataModel.getReferUserId());
		String title = "updタイトル";
		String detail = "upd詳細";
		int budget = 9999;
		RecruitMentorModel.Status status = RecruitMentorModel.Status.OPEN;
		RecruitMentorModel.Type type = RecruitMentorModel.Type.MONTH;
		LocalDateTime createdAt = recruitMentorDataModel.getCreatedAt();
		LocalDateTime updatedAt = LocalDateTime.now();
	    
		RecruitMentorModel insertRecruitMentorModel = new RecruitMentorModel(recruitMentorId,
				title,
				detail,
				budget,
				type,
				status);
		
		RecruitMentorDataModel insertRecruitMentorDataModel = new RecruitMentorDataModel(insertRecruitMentorModel,
				userId,
				createdAt,
				updatedAt);
		
		return insertRecruitMentorDataModel;
	}
	
}
