package menta.app.model.skill;

import lombok.Getter;
import menta.app.model.skill.exception.SkillLevelMaxException;
import menta.app.model.skill.exception.SkillLevelMinException;
import menta.app.model.skill.exception.SkillYearMinException;
import menta.app.model.skill.valueObject.SkillId;
import menta.app.model.tag.valueObject.TagId;

@Getter
public class SkillModel {
	
	private SkillId skillId = null;
	private TagId referTagId = null;
	private Integer year = null;
	private Integer level = null;
	
	/**
	 * レベル：最小レベル
	 */
	private final static Integer LEVEL_MIN = 1;
	/**
	 * レベル：最大レベル
	 */
	private final static Integer LEVEL_MAX = 5;
	
	/**
	 *  コンストラクタ
	 *  @param skillId スキルID
	 *  @param referTagId 参照タグID
	 *  @param year 年数
	 *  @param level レベル
	 */
	public SkillModel(SkillId skillId,
			TagId referTagId,
			int year,
			int level
			) {
		
		//チェック
		checkYear(year);
		checkLevel(level);
		
		this.skillId = skillId;
		this.referTagId = referTagId;
		this.year = year;
		this.level = level;
		
	}
	
	/**
	 * 年数を設定する
	 * @param level
	 */
	public void changeYear(int year) {
		checkYear(year);
		this.year = year;
	}
	
	/**
	 * レベルを設定する
	 * @param level
	 */
	public void changeLevel(int level) {
		checkLevel(level);
		this.level = level;
	}
	
	private void checkYear(int year) {
		if(year < 0) {
			throw new SkillYearMinException(year);
		}
	}
	
	private void checkLevel(int level) {
		if(year < LEVEL_MIN) {
			throw new SkillLevelMinException(level);
		}
		if(year > LEVEL_MAX) {
			throw new SkillLevelMaxException(level);
		}
	}
	
}
