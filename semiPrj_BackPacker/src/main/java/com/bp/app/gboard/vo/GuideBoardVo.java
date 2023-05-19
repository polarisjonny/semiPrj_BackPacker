package com.bp.app.gboard.vo;

public class GuideBoardVo {
	
	private String guideBoardNo;
	private String writerNo;
	private String guideBoardCategoryNo;
	private String schedulerNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String hit;
	private String matchingState;
	private String travelExpense;
	private String deleteYn;
	private String reportCnt;
	
	//민규가 추가
	private String writerId;
	private String writerNick;
	private String categoryName;

	//멤버
	private String id;
	private String nick;
	private String age;
	private String profileImage;
	private String gender;
	
	//썸네일 이미지
	private String mainImg;
	
	//일정
	private String startDate;
	private String endDate;
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
	public String getSchedulerNo() {
		return schedulerNo;
	}
	public void setSchedulerNo(String schedulerNo) {
		this.schedulerNo = schedulerNo;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMainImg() {
		return mainImg;
	}
	public void setMainImg(String changeName) {
		this.mainImg = changeName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "GuideBoardVo [guideBoardNo=" + guideBoardNo + ", writerNo=" + writerNo + ", guideBoardCategoryNo="
				+ guideBoardCategoryNo + ", schedulerNo=" + schedulerNo + ", title=" + title + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", hit=" + hit + ", matchingState="
				+ matchingState + ", travelExpense=" + travelExpense + ", deleteYn=" + deleteYn + ", reportCnt="
				+ reportCnt + ", writerId=" + writerId + ", writerNick=" + writerNick + ", categoryName=" + categoryName
				+ ", id=" + id + ", nick=" + nick + ", age=" + age + ", profileImage=" + profileImage + ", gender="
				+ gender + ", mainImg=" + mainImg + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public GuideBoardVo(String guideBoardNo, String writerNo, String guideBoardCategoryNo, String schedulerNo,
			String title, String content, String enrollDate, String modifyDate, String hit, String matchingState,
			String travelExpense, String deleteYn, String reportCnt, String writerId, String writerNick,
			String categoryName, String id, String nick, String age, String profileImage, String gender,
			String changeName, String startDate, String endDate) {
		super();
		this.guideBoardNo = guideBoardNo;
		this.writerNo = writerNo;
		this.guideBoardCategoryNo = guideBoardCategoryNo;
		this.schedulerNo = schedulerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.matchingState = matchingState;
		this.travelExpense = travelExpense;
		this.deleteYn = deleteYn;
		this.reportCnt = reportCnt;
		this.writerId = writerId;
		this.writerNick = writerNick;
		this.categoryName = categoryName;
		this.id = id;
		this.nick = nick;
		this.age = age;
		this.profileImage = profileImage;
		this.gender = gender;
		this.mainImg = mainImg;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public GuideBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
