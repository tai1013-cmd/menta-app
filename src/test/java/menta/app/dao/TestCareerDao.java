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

import menta.app.dao.career.CareerDao;
import menta.app.dao.career.dataModel.CareerDataModel;
import menta.app.model.career.CareerModel;
import menta.app.model.career.valueObject.CareerId;
import menta.app.model.user.valueObject.UserId;
@SpringJUnitConfig(locations = "classpath:test-context.xml")
@SpringBootTest
@MapperScan("menta.app.dao")
@ExtendWith(SpringExtension.class)
public class TestCareerDao {

	@Autowired
	private CareerDao careerDao;
	
	@Test 
    public void test() {
		
		CareerDataModel insertCareerDataModel = setInsertData();
		
		// 実行（新規登録）
		careerDao.insert(insertCareerDataModel);
		
		// 実行（検索）
		CareerDataModel getCareerDataModelByCareerId = careerDao.selectOneByCareerId(insertCareerDataModel.getId());
		
		assertNotNull(getCareerDataModelByCareerId.getId());
		assertNotNull(getCareerDataModelByCareerId.getReferUserId());
		assertNotNull(getCareerDataModelByCareerId.getYearFrom());
		assertNotNull(getCareerDataModelByCareerId.getYearTo());
		assertNotNull(getCareerDataModelByCareerId.getDetail());
		assertNotNull(getCareerDataModelByCareerId.getCreatedAt());
		
		assertEquals(insertCareerDataModel.getId(), getCareerDataModelByCareerId.getId());
		assertEquals(insertCareerDataModel.getReferUserId(), getCareerDataModelByCareerId.getReferUserId());
		assertEquals(insertCareerDataModel.getYearFrom(), getCareerDataModelByCareerId.getYearFrom());
		assertEquals(insertCareerDataModel.getYearTo(), getCareerDataModelByCareerId.getYearTo());
		assertEquals(insertCareerDataModel.getDetail(), getCareerDataModelByCareerId.getDetail());
		assertEquals(insertCareerDataModel.getCreatedAt(), getCareerDataModelByCareerId.getCreatedAt());
		
		// 実行（一覧検索）
		List<CareerDataModel> getCareerDataModelList = careerDao.selectListByUserId(insertCareerDataModel.getReferUserId());
		assertNotNull(getCareerDataModelList);
		
		// 実行（削除）
		careerDao.delete(insertCareerDataModel.getId());
		CareerDataModel delCareerDataModelById =  careerDao.selectOneByCareerId(insertCareerDataModel.getId());
		assertNull(delCareerDataModelById);
		
	}
	
	private CareerDataModel setInsertData() {
		
		CareerId careerId = new CareerId();
		UserId userId = new UserId();
		String detail = "詳細";
		int yearFrom = 2000;
		int yearTo = 2010;
		LocalDateTime createdAt = LocalDateTime.now();
						
		CareerModel insertCareerModel = new CareerModel(careerId,
				detail,
				yearFrom,
				yearTo,
				userId);
		
		CareerDataModel insertCareerDataModel = new CareerDataModel(insertCareerModel,
				createdAt);
		
		return insertCareerDataModel;
	}
	
}
