package com.bp.app.travelReview.vo;

public class TravelReviewVo {

	private String infoNo;
	private String infoCategoryNo;
	private String writerNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String hit;
	private String deleteYn;
	public String getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(String infoNo) {
		this.infoNo = infoNo;
	}
	public String getInfoCategoryNo() {
		return infoCategoryNo;
	}
	public void setInfoCategoryNo(String infoCategoryNo) {
		this.infoCategoryNo = infoCategoryNo;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
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
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	@Override
	public String toString() {
		return "TravelReviewVo [infoNo=" + infoNo + ", infoCategoryNo=" + infoCategoryNo + ", writerNo=" + writerNo
				+ ", title=" + title + ", content=" + content + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", hit=" + hit + ", deleteYn=" + deleteYn + "]";
	}
	public TravelReviewVo(String infoNo, String infoCategoryNo, String writerNo, String title, String content,
			String enrollDate, String modifyDate, String hit, String deleteYn) {
		super();
		this.infoNo = infoNo;
		this.infoCategoryNo = infoCategoryNo;
		this.writerNo = writerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.deleteYn = deleteYn;
	}
	public TravelReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
