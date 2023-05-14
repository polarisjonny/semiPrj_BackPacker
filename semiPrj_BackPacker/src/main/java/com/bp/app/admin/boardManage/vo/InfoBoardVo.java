package com.bp.app.admin.boardManage.vo;

public class InfoBoardVo {
	
	private String infoNo;
	private String writerNo;
	private String infoCategoryNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String hit;
	private String deleteYn;
	private String reportCnt;
	private String writerId;
	private String writerNick;
	private String categoryName;
	public String getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(String infoNo) {
		this.infoNo = infoNo;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getInfoCategoryNo() {
		return infoCategoryNo;
	}
	public void setInfoCategoryNo(String infoCategoryNo) {
		this.infoCategoryNo = infoCategoryNo;
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
	public String getReportCnt() {
		return reportCnt;
	}
	public void setReportCnt(String reportCnt) {
		this.reportCnt = reportCnt;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriterNick() {
		return writerNick;
	}
	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "InfoBoardVo [infoNo=" + infoNo + ", writerNo=" + writerNo + ", infoCategoryNo=" + infoCategoryNo
				+ ", title=" + title + ", content=" + content + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", hit=" + hit + ", deleteYn=" + deleteYn + ", reportCnt=" + reportCnt + ", writerId="
				+ writerId + ", writerNick=" + writerNick + ", categoryName=" + categoryName + "]";
	}
	public InfoBoardVo(String infoNo, String writerNo, String infoCategoryNo, String title, String content,
			String enrollDate, String modifyDate, String hit, String deleteYn, String reportCnt, String writerId,
			String writerNick, String categoryName) {
		super();
		this.infoNo = infoNo;
		this.writerNo = writerNo;
		this.infoCategoryNo = infoCategoryNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.deleteYn = deleteYn;
		this.reportCnt = reportCnt;
		this.writerId = writerId;
		this.writerNick = writerNick;
		this.categoryName = categoryName;
	}
	public InfoBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
