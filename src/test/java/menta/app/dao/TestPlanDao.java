package menta.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import menta.app.dao.plan.PlanDao;
import menta.app.dao.plan.dataModel.PlanDataModel;
import menta.app.model.category.valueObject.CategoryId;
import menta.app.model.plan.PlanModel;
import menta.app.model.plan.PlanModel.Approval;
import menta.app.model.plan.PlanModel.Status;
import menta.app.model.plan.valueObject.PlanId;
import menta.app.model.tag.valueObject.TagId;
import menta.app.model.user.valueObject.UserId;
@SpringJUnitConfig(locations = "classpath:test-context.xml")
@SpringBootTest
@MapperScan("menta.app.dao")
@ExtendWith(SpringExtension.class)
public class TestPlanDao {

	@Autowired
	private PlanDao planDao;
	
	@Test 
    public void test() {
		
		PlanDataModel insertPlanDataModel = setInsertData();
		
		// 実行（新規登録）
		planDao.insert(insertPlanDataModel);
		
		// 実行（検索）
		PlanDataModel getPlanDataModelByPlanId = planDao.selectOneByPlanId(insertPlanDataModel.getId());
		
		assertNotNull(getPlanDataModelByPlanId.getId());
		assertNotNull(getPlanDataModelByPlanId.getTitle());
		assertNotNull(getPlanDataModelByPlanId.getDetail());
		assertNotNull(getPlanDataModelByPlanId.getStatus());
		assertNotNull(getPlanDataModelByPlanId.getApproval());
		assertNotNull(getPlanDataModelByPlanId.getReferTagId());
		assertNotNull(getPlanDataModelByPlanId.getReferCategoryId());
		assertNotNull(getPlanDataModelByPlanId.getReferUserId());
		assertNotNull(getPlanDataModelByPlanId.getCreatedAt());
		
		assertEquals(insertPlanDataModel.getId(), getPlanDataModelByPlanId.getId());
		assertEquals(insertPlanDataModel.getTitle(), getPlanDataModelByPlanId.getTitle());
		assertEquals(insertPlanDataModel.getDetail(), getPlanDataModelByPlanId.getDetail());
		assertEquals(insertPlanDataModel.getStatus(), getPlanDataModelByPlanId.getStatus());
		assertEquals(insertPlanDataModel.getApproval(), getPlanDataModelByPlanId.getApproval());
		assertEquals(insertPlanDataModel.getReferTagId(), getPlanDataModelByPlanId.getReferTagId());
		assertEquals(insertPlanDataModel.getReferCategoryId(), getPlanDataModelByPlanId.getReferCategoryId());
		assertEquals(insertPlanDataModel.getReferUserId(), getPlanDataModelByPlanId.getReferUserId());
		assertEquals(insertPlanDataModel.getCreatedAt(), getPlanDataModelByPlanId.getCreatedAt());
		
		// 実行（一覧検索）
		List<PlanDataModel> getPlanDataModelListByUserId = planDao.selectListByUserId(insertPlanDataModel.getReferUserId());
		assertNotNull(getPlanDataModelListByUserId);
		
		// 実行（一覧検索）
		List<String> getUserIdList = planDao.selectUserIdListCreatedDesc();
		assertNotNull(getUserIdList);
		
		// 実行（IDで削除）
		planDao.delete(insertPlanDataModel.getId());
		PlanDataModel delPlanDataModelById =  planDao.selectOneByPlanId(insertPlanDataModel.getId());
		assertNull(delPlanDataModelById);
		
	}
	
	private PlanDataModel setInsertData() {
		
		PlanId planId = new PlanId();
		String title = "タイトル";
		String detail = "詳細";
		Status status = Status.BUSY;
		Approval approval = Approval.APPROVE;
		CategoryId categoryId = new CategoryId();
		UserId userId = new UserId();
		List<TagId> tagIdList = new ArrayList<>();
		tagIdList.add(new TagId());
		LocalDateTime createdAt = LocalDateTime.now();
						
		PlanModel insertPlanModel = new PlanModel(planId,
				title,
				detail,
				status,
				approval,
				categoryId,
				tagIdList
				);
		
		PlanDataModel insertPlanDataModel = new PlanDataModel(insertPlanModel,
				userId,
				createdAt);
		
		return insertPlanDataModel;
	}
	
}
