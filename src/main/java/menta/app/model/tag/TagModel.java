package menta.app.model.tag;
import lombok.Getter;
import menta.app.model.tag.exception.TagNameNullException;
import menta.app.model.tag.valueObject.TagId;

@Getter
public class TagModel {
	
	private TagId tagId = null;
	private String tagName = "";
	
	/**
	 *  コンストラクタ
	 *  @param tagId タグID
	 *  @param tagName タグ名
	 */
	public TagModel(TagId tagId,
			String tagName
			) {
		
		//チェック
		checkTagName(tagName);
		
		this.tagId = tagId;
		this.tagName = tagName;
		
	}
	
	private void checkTagName(String tagName) {
		
		if(tagName == null || tagName.length() == 0) {
			throw new TagNameNullException();
		}
	}
}
