package menta.app.model.plan;

import java.util.List;

import lombok.Getter;
import menta.app.model.category.valueObject.CategoryId;
import menta.app.model.plan.exception.PlanApprovalNullException;
import menta.app.model.plan.exception.PlanDetailMaxLengthException;
import menta.app.model.plan.exception.PlanDetailNullException;
import menta.app.model.plan.exception.PlanStatusNullException;
import menta.app.model.plan.valueObject.PlanId;
import menta.app.model.tag.valueObject.TagId;

@Getter
public class PlanModel {

	private PlanId planId = null;
	private String title = "";
	private String detail = "";
	private Status status = null;
	private Approval approval = null;
	private CategoryId referCategoryId = null;
	private List<TagId> referTagIdList = null;

	/**
	 *  ステータス（相談可能、忙しい、表示しない）
	 */
	public enum Status {
		POSSIBLE,
		BUSY,
		NOT_OPEN
	};

	/**
	 *  契約承認（承認する、承認しない）
	 */
	public enum Approval {
		APPROVE,
		NOT_APPROVE
	};
	
	/**
	 * 詳細：最大文字数
	 */
	private static final Integer DETAIL_MAX_LENGTH = 2000;
	
	/**
	 *  コンストラクタ
	 *  @param planId プランID
	 *  @param title タイトル
	 *  @param detail 内容
	 *  @param status ステータス（相談可能、忙しい、表示しない）
	 *  @param approval 契約承認（承認する、承認しない）
	 *  @param contactStatus 契約ステータス
	 *  @param referCategoryId 参照カテゴリーID
	 *  @param referTagIdList 参照タグID
	 */
	public PlanModel(PlanId planId,
			String title,
			String detail,
			Status status,
			Approval approval,
			CategoryId referCategoryId,
			List<TagId> referTagIdList
			) {
		//チェック
		checkDetail(detail);
		
		this.planId = planId;
		this.title = title;
		this.detail = detail;
		this.status = status;
		this.approval = approval;
		this.referCategoryId = referCategoryId;
		this.referTagIdList = referTagIdList;
		
	}
	
	/**
	 * 詳細を設定する
	 * @param detail
	 */
	public void changeDetail(String detail) {
		checkDetail(detail);
		this.detail = detail;
	}
	
	/**
	 * ステータスを設定する
	 * @param status
	 */
	public void changeStatus(Status status) {
		checkStatus(status);
		this.status = status;
	}
	
	/**
	 * 契約承認を設定する
	 * @param approval
	 */
	public void changeApproval(Approval approval) {
		checkApproval(approval);
		this.approval = approval;
	}
	
	private void checkDetail(String detail) {
		
		if(detail == null || detail.length() == 0) {
			throw new PlanDetailNullException();
		}
		if(detail.length() > DETAIL_MAX_LENGTH) {
			throw new PlanDetailMaxLengthException(detail);
		}
		
	}

	private void checkStatus(Status status) {
		
		if(status == null) {
			throw new PlanStatusNullException();
		}
		
	}

	private void checkApproval(Approval approval) {
		
		if(approval == null) {
			throw new PlanApprovalNullException();
		}
		
	}
	
}
