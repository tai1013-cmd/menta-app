package menta.app.dao.user;

import org.apache.ibatis.annotations.Param;

import menta.app.dao.user.entity.UserEntity;

/**
 * ユーザマスタのDAOクラス
 */
public interface UserDao {
	/**
	 * ユーザテーブルからユーザIDに紐付くユーザ情報を取得する
	 * 
	 * @param userId ユーザID
	 */
	UserEntity selectOneByUserId(@Param("userId") String userId);
	
	/**
	 * ユーザテーブルからメールアドレスに紐付くユーザ情報を取得する
	 * 
	 * @param mailaddress メールアドレス
	 */
	UserEntity selectOneByMailAddress(@Param("mailaddress") String mailAddress);

	/**
	 * ユーザテーブルに登録する
	 * 
	 * @param UserEntity ユーザエンティティ
	 */
	void insert(UserEntity userEntity);

	/**
	 * ユーザテーブルの更新する
	 * 
	 * @param UserEntity ユーザエンティティ
	 */
	void update(UserEntity userEntity);

}