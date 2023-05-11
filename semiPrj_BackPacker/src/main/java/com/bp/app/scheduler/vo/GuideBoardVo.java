package com.bp.app.scheduler.vo;

public class GuideBoardVo {
	
	private String guideBoardNo;
	private String writerNo;
	private String guideBoardCategoryNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String hit;
	private String matchingState;
	private String travelExpense;
	private String deleteYn;
	public String getGuideBoardNo() {
		return guideBoardNo;
	}
	public void setGuideBoardNo(String guideBoardNo) {
		this.guideBoardNo = guideBoardNo;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getGuideBoardCategoryNo() {
		return guideBoardCategoryNo;
	}
	public void setGuideBoardCategoryNo(String guideBoardCategoryNo) {
		this.guideBoardCategoryNo = guideBoardCategoryNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getMatchingState() {
		return matchingState;
	}
	public void setMatchingState(String matchingState) {
		this.matchingState = matchingState;
	}
	public String getTravelExpense() {
		return travelExpense;
	}
	public void setTravelExpense(String travelExpense) {
		this.travelExpense = travelExpense;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	@Override
	public String toString() {
		return "GuideBoardVo [guideBoardNo=" + guideBoardNo + ", writerNo=" + writerNo + ", guideBoardCategoryNo="
				+ guideBoardCategoryNo + ", title=" + title + ", content=" + content + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", hit=" + hit + ", matchingState=" + matchingState
				+ ", travelExpense=" + travelExpense + ", deleteYn=" + deleteYn + "]";
	}
	public GuideBoardVo(String guideBoardNo, String writerNo, String guideBoardCategoryNo, String title, String content,
			String enrollDate, String modifyDate, String hit, String matchingState, String travelExpense,
			String deleteYn) {
		super();
		this.guideBoardNo = guideBoardNo;
		this.writerNo = writerNo;
		this.guideBoardCategoryNo = guideBoardCategoryNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.matchingState = matchingState;
		this.travelExpense = travelExpense;
		this.deleteYn = deleteYn;
	}
	public GuideBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
