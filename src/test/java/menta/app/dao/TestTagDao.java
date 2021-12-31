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

import menta.app.dao.tag.TagDao;
import menta.app.dao.tag.dataModel.TagDataModel;
import menta.app.model.tag.TagModel;
import menta.app.model.tag.valueObject.TagId;
@SpringJUnitConfig(locations = "classpath:test-context.xml")
@SpringBootTest
@MapperScan("menta.app.dao")
@ExtendWith(SpringExtension.class)
public class TestTagDao {

	@Autowired
	private TagDao tagDao;
	
	@Test 
    public void test() {
		
		TagDataModel insertTagDataModel = setInsertData();
		
		// 実行（新規登録）
		tagDao.insert(insertTagDataModel);
		
		// 実行（検索）
		TagDataModel getTagDataModelByTagId = tagDao.selectOneByTagId(insertTagDataModel.getId());
		
		assertNotNull(getTagDataModelByTagId.getId());
		assertNotNull(getTagDataModelByTagId.getName());
		assertNotNull(getTagDataModelByTagId.getCreatedAt());
		
		assertEquals(insertTagDataModel.getId(), getTagDataModelByTagId.getId());
		assertEquals(insertTagDataModel.getName(), getTagDataModelByTagId.getName());
		assertEquals(insertTagDataModel.getCreatedAt(), getTagDataModelByTagId.getCreatedAt());
		
		// 実行（一覧検索）
		List<TagDataModel> getTagDataModelList = tagDao.selectList();
		assertNotNull(getTagDataModelList);
		
		// 実行（削除）
		tagDao.delete(insertTagDataModel.getId());
		TagDataModel delTagDataModelById =  tagDao.selectOneByTagId(insertTagDataModel.getId());
		assertNull(delTagDataModelById);
		
	}
	
	private TagDataModel setInsertData() {
		
		TagId tagId = new TagId();
		String tagName = "タグ名";
		LocalDateTime createdAt = LocalDateTime.now();
		
		TagModel insertTagModel = new TagModel(tagId,
				tagName);
		
		TagDataModel insertTagDataModel = new TagDataModel(insertTagModel,
				createdAt);
		
		return insertTagDataModel;
	}
	
}
