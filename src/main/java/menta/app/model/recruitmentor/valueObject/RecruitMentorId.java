package menta.app.model.recruitmentor.valueObject;

import lombok.Getter;
import menta.app.model.valueObject.Id;

@Getter
public class RecruitMentorId extends Id{
	
	/**
	 *  コンストラクタ
	 */
	public RecruitMentorId() {
		super();
	}
	
	/**
	 *  コンストラクタ
	 *  @param Id ID
	 */
	public RecruitMentorId(String id) {
		super(id);
	}
	
}
