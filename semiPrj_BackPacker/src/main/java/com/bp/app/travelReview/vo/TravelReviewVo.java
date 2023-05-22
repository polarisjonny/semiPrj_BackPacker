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
	private String mainImg;
	
	private String changeName;
	
	private String profileImage;
	private String writerNick;
	private String writerId;
	private String reportCnt;
	private String categoryName;
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
	public String getMainImg() {
		return mainImg;
	}
	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getWriterNick() {
		return writerNick;
	}
	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getReportCnt() {
		return reportCnt;
	}
	public void setReportCnt(String reportCnt) {
		this.reportCnt = reportCnt;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "TravelReviewVo [infoNo=" + infoNo + ", infoCategoryNo=" + infoCategoryNo + ", writerNo=" + writerNo
				+ ", title=" + title + ", content=" + content + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", hit=" + hit + ", deleteYn=" + deleteYn + ", mainImg=" + mainImg + ", changeName="
				+ changeName + ", profileImage=" + profileImage + ", writerNick=" + writerNick + ", writerId="
				+ writerId + ", reportCnt=" + reportCnt + ", categoryName=" + categoryName + "]";
	}
	public TravelReviewVo(String infoNo, String infoCategoryNo, String writerNo, String title, String content,
			String enrollDate, String modifyDate, String hit, String deleteYn, String mainImg, String changeName,
			String profileImage, String writerNick, String writerId, String reportCnt, String categoryName) {
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
		this.mainImg = mainImg;
		this.changeName = changeName;
		this.profileImage = profileImage;
		this.writerNick = writerNick;
		this.writerId = writerId;
		this.reportCnt = reportCnt;
		this.categoryName = categoryName;
	}
	public TravelReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
