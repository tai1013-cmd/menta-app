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

import menta.app.dao.skill.SkillDao;
import menta.app.dao.skill.dataModel.SkillDataModel;
import menta.app.model.skill.SkillModel;
import menta.app.model.skill.valueObject.SkillId;
import menta.app.model.tag.valueObject.TagId;
import menta.app.model.user.valueObject.UserId;
@SpringJUnitConfig(locations = "classpath:test-context.xml")
@SpringBootTest
@MapperScan("menta.app.dao")
@ExtendWith(SpringExtension.class)
public class TestSkillDao {

	@Autowired
	private SkillDao skillDao;
	
	@Test 
    public void test() {
		
		SkillDataModel insertSkillDataModel = setInsertData();
		
		// 実行（新規登録）
		skillDao.insert(insertSkillDataModel);
		
		// 実行（検索）
		SkillDataModel getSkillDataModelBySkillId = skillDao.selectOneBySkillId(insertSkillDataModel.getId());
		
		assertNotNull(getSkillDataModelBySkillId.getId());
		assertNotNull(getSkillDataModelBySkillId.getReferTagId());
		assertNotNull(getSkillDataModelBySkillId.getReferUserId());
		assertNotNull(getSkillDataModelBySkillId.getLevel());
		assertNotNull(getSkillDataModelBySkillId.getYear());
		assertNotNull(getSkillDataModelBySkillId.getCreatedAt());
		
		assertEquals(insertSkillDataModel.getId(), getSkillDataModelBySkillId.getId());
		assertEquals(insertSkillDataModel.getReferTagId(), getSkillDataModelBySkillId.getReferTagId());
		assertEquals(insertSkillDataModel.getReferUserId(), getSkillDataModelBySkillId.getReferUserId());
		assertEquals(insertSkillDataModel.getLevel(), getSkillDataModelBySkillId.getLevel());
		assertEquals(insertSkillDataModel.getYear(), getSkillDataModelBySkillId.getYear());
		assertEquals(insertSkillDataModel.getCreatedAt(), getSkillDataModelBySkillId.getCreatedAt());
		
		// 実行（一覧検索）
		List<SkillDataModel> getSkillDataModelList = skillDao.selectListByUserId(insertSkillDataModel.getReferUserId());
		assertNotNull(getSkillDataModelList);
		
		// 実行（削除）
		skillDao.delete(insertSkillDataModel.getId());
		SkillDataModel delSkillDataModelById =  skillDao.selectOneBySkillId(insertSkillDataModel.getId());
		assertNull(delSkillDataModelById);
		
	}
	
	private SkillDataModel setInsertData() {
		
		SkillId skillId = new SkillId();
		TagId tagId = new TagId();
		UserId userId = new UserId();
		int year = 2;
		int level = 2;
		LocalDateTime createdAt = LocalDateTime.now();
		
		SkillModel insertSkillModel = new SkillModel(skillId,
				tagId,
				year,
				level);
		
		SkillDataModel insertSkillDataModel = new SkillDataModel(insertSkillModel,
				userId,
				createdAt);
		
		return insertSkillDataModel;
	}
	
}
