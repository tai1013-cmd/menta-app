package menta.app.dao.user;

import org.apache.ibatis.annotations.Param;

import menta.app.dao.user.dataModel.UserDataModel;

/**
 * ユーザマスタのDAOクラス
 */
public interface UserDao {
	/**
	 * ユーザテーブルからユーザIDに紐付くユーザ情報を取得する
	 * 
	 * @param userId ユーザID
	 */
	UserDataModel selectOneByUserId(@Param("userId") String userId);
	
	/**
	 * ユーザテーブルからメールアドレスに紐付くユーザ情報を取得する
	 * 
	 * @param mailaddress メールアドレス
	 */
	UserDataModel selectOneByMailAddress(@Param("mailaddress") String mailAddress);

	/**
	 * ユーザテーブルに登録する
	 * 
	 * @param UserDataModel ユーザデータモデル
	 */
	void insert(UserDataModel userEntity);

	/**
	 * ユーザテーブルの更新する
	 * 
	 * @param UserDataModel ユーザデータモデル
	 */
	void update(UserDataModel userEntity);

}
