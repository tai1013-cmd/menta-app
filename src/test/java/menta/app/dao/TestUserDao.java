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

import menta.app.dao.user.UserDao;
import menta.app.dao.user.dataModel.UserDataModel;
import menta.app.model.user.UserModel;
import menta.app.model.user.valueObject.FullName;
import menta.app.model.user.valueObject.MailAddress;
import menta.app.model.user.valueObject.Password;
import menta.app.model.user.valueObject.UserId;

@SpringJUnitConfig(locations = "classpath:test-context.xml")
@SpringBootTest
@MapperScan("menta.app.dao")
@ExtendWith(SpringExtension.class)
public class TestUserDao {

	@Autowired
	private UserDao userDao;
	
	@Test 
    public void test() {
		
		UserDataModel insertUserDataModel = setInsertData();
		
		// 実行（新規登録）
		userDao.insert(insertUserDataModel);
		
		// 実行（メールアドレスで検索）
		UserDataModel getUserDataModelByMail =  userDao.selectOneByMailAddress(insertUserDataModel.getMailaddress());
		
		assertNotNull(getUserDataModelByMail.getId());
		assertNotNull(getUserDataModelByMail.getSei());
		assertNotNull(getUserDataModelByMail.getMei());
		assertNotNull(getUserDataModelByMail.getMailaddress());
		assertNotNull(getUserDataModelByMail.getPassword());
		assertNotNull(getUserDataModelByMail.getSelfIntro());
		assertNotNull(getUserDataModelByMail.getCreatedAt());
		assertNotNull(getUserDataModelByMail.getUpdatedAt());
		
		assertEquals(insertUserDataModel.getId(), getUserDataModelByMail.getId());
		assertEquals(insertUserDataModel.getSei(), getUserDataModelByMail.getSei());
		assertEquals(insertUserDataModel.getMei(), getUserDataModelByMail.getMei());
		assertEquals(insertUserDataModel.getMailaddress(), getUserDataModelByMail.getMailaddress());
		assertEquals(insertUserDataModel.getPassword(), getUserDataModelByMail.getPassword());
		assertEquals(insertUserDataModel.getSelfIntro(), getUserDataModelByMail.getSelfIntro());
		assertEquals(insertUserDataModel.getCreatedAt(), getUserDataModelByMail.getCreatedAt());
		assertEquals(insertUserDataModel.getUpdatedAt(), getUserDataModelByMail.getUpdatedAt());
		
		// 実行（更新登録）
		UserDataModel updateUserDataModel = setUpdateData(getUserDataModelByMail);
		userDao.update(updateUserDataModel);
		
		// 実行（IDで検索）
		UserDataModel getUserDataModelById =  userDao.selectOneByUserId(insertUserDataModel.getId());
		
		assertEquals(updateUserDataModel.getId(), getUserDataModelById.getId());
		assertEquals(updateUserDataModel.getSei(), getUserDataModelById.getSei());
		assertEquals(updateUserDataModel.getMei(), getUserDataModelById.getMei());
		assertEquals(updateUserDataModel.getMailaddress(), getUserDataModelById.getMailaddress());
		assertEquals(updateUserDataModel.getPassword(), getUserDataModelById.getPassword());
		assertEquals(updateUserDataModel.getSelfIntro(), getUserDataModelById.getSelfIntro());
		assertEquals(updateUserDataModel.getCreatedAt(), getUserDataModelById.getCreatedAt());
		assertEquals(updateUserDataModel.getUpdatedAt(), getUserDataModelById.getUpdatedAt());

		// 実行（IDで削除）
		userDao.delete(insertUserDataModel.getId());
		UserDataModel delUserDataModelById =  userDao.selectOneByUserId(insertUserDataModel.getId());
		assertNull(delUserDataModelById);

	}
	
	private UserDataModel setInsertData() {
		
		UserId userId = new UserId();
		MailAddress mailAddress = new MailAddress("testAB1234@gmail.com");
		Password password = new Password("password1234567890");
		FullName fullName = new FullName("姓","名");
		String selfIntro = "自己紹介";
		LocalDateTime createdAt = LocalDateTime.now();
		LocalDateTime updatedAt = LocalDateTime.now();
		
		UserModel insertUserModel = new UserModel(userId,
				mailAddress,
				password,
				fullName,
				selfIntro,
				null);
		
		UserDataModel insertUserDataModel = new UserDataModel(insertUserModel,
				createdAt,
				updatedAt);
		
		return insertUserDataModel;
	}
	
	private UserDataModel setUpdateData(UserDataModel userDataModel) {
		
		MailAddress mailAddress = new MailAddress("updtestAB1234@gmail.com");
		Password password = new Password("updpassword1234567890");
		FullName fullName = new FullName("upd姓","upd名");
		String selfIntro = "upd自己紹介";
		LocalDateTime createdAt = userDataModel.getCreatedAt();
		LocalDateTime updatedAt = LocalDateTime.now();
		
		UserModel insertUserModel = new UserModel(new UserId(userDataModel.getId()),
				mailAddress,
				password,
				fullName,
				selfIntro,
				null);
		
		UserDataModel insertUserDataModel = new UserDataModel(insertUserModel,
				createdAt,
				updatedAt);
		
		return insertUserDataModel;
	}
	
	
}
