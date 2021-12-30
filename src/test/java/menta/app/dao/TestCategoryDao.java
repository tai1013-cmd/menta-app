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

import menta.app.dao.category.CategoryDao;
import menta.app.dao.category.dataModel.CategoryDataModel;
import menta.app.model.category.CategoryModel;
import menta.app.model.category.valueObject.CategoryId;
@SpringJUnitConfig(locations = "classpath:test-context.xml")
@SpringBootTest
@MapperScan("menta.app.dao")
@ExtendWith(SpringExtension.class)
public class TestCategoryDao {

	@Autowired
	private CategoryDao categoryDao;
	
	@Test 
    public void test() {
		
		CategoryDataModel insertCategoryDataModel = setInsertData();
		
		// 実行（新規登録）
		categoryDao.insert(insertCategoryDataModel);
		
		// 実行（検索）
		CategoryDataModel getCategoryDataModelByCategoryId = categoryDao.selectOneByCategoryId(insertCategoryDataModel.getId());
		
		assertNotNull(getCategoryDataModelByCategoryId.getId());
		assertNotNull(getCategoryDataModelByCategoryId.getName());
		assertNotNull(getCategoryDataModelByCategoryId.getCreatedAt());
		
		assertEquals(insertCategoryDataModel.getId(), getCategoryDataModelByCategoryId.getId());
		assertEquals(insertCategoryDataModel.getName(), getCategoryDataModelByCategoryId.getName());
		assertEquals(insertCategoryDataModel.getCreatedAt(), getCategoryDataModelByCategoryId.getCreatedAt());
		
		// 実行（一覧検索）
		List<CategoryDataModel> getCategoryDataModelList = categoryDao.selectList();
		assertNotNull(getCategoryDataModelList);
		
		// 実行（削除）
		categoryDao.delete(insertCategoryDataModel.getId());
		CategoryDataModel delCategoryDataModelById =  categoryDao.selectOneByCategoryId(insertCategoryDataModel.getId());
		assertNull(delCategoryDataModelById);
		
	}
	
	private CategoryDataModel setInsertData() {
		
		CategoryId categoryId = new CategoryId();
		String categoryName = "カテゴリー名";
		LocalDateTime createdAt = LocalDateTime.now();
		
		CategoryModel insertCategoryModel = new CategoryModel(categoryId,
				categoryName);
		
		CategoryDataModel insertCategoryDataModel = new CategoryDataModel(insertCategoryModel,
				createdAt);
		
		return insertCategoryDataModel;
	}
	
}
