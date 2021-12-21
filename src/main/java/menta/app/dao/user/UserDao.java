package menta.app.dao.user;

import org.apache.ibatis.annotations.Param;

import menta.app.dao.user.dataModel.UserDataModel;

/**
 * ユーザマスタのDAOクラス
 */
public interface UserDao {
	/**
	 * ユーザIDに紐付くユーザ情報を取得する
	 * 
	 * @param userId ユーザID
	 */
	UserDataModel selectOneByUserId(@Param("userId") String userId);
	
	/**
	 * メールアドレスに紐付くユーザ情報を取得する
	 * 
	 * @param mailaddress メールアドレス
	 */
	UserDataModel selectOneByMailAddress(@Param("mailaddress") String mailAddress);

	/**
	 * ユーザテーブルに登録する
	 * 
	 * @param userDataModel ユーザデータモデル
	 */
	void insert(UserDataModel userDataModel);

	/**
	 * ユーザテーブルの更新する
	 * 
	 * @param userDataModel ユーザデータモデル
	 */
	void update(UserDataModel userDataModel);
	
	/**
	 * ユーザテーブルを削除する
	 * 
	 * @param userDataModel ユーザデータモデル
	 */
	void delete(UserDataModel userDataModel);

}
