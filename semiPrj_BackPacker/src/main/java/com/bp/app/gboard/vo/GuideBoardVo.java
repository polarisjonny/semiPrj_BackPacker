package com.bp.app.gboard.vo;

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
	private String startDate;
	private String endDate;
	//이미지 파일 관련
	
	private String changeName;
	
	//작성자 관련
	private String nickName;
	

	private String id;
	private String age;
	private String profile;
	private String gender;
	
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "GuideBoardVo [guideBoardNo=" + guideBoardNo + ", writerNo=" + writerNo + ", guideBoardCategoryNo="
				+ guideBoardCategoryNo + ", title=" + title + ", content=" + content + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", hit=" + hit + ", matchingState=" + matchingState
				+ ", travelExpense=" + travelExpense + ", deleteYn=" + deleteYn + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", changeName=" + changeName + ", nickName=" + nickName + ", id=" + id
				+ ", age=" + age + ", profile=" + profile + ", gender=" + gender + "]";
	}
	
	public GuideBoardVo(String guideBoardNo, String writerNo, String guideBoardCategoryNo, String title, String content,
			String enrollDate, String modifyDate, String hit, String matchingState, String travelExpense,
			String deleteYn, String startDate, String endDate, String changeName, String nickName, String id,
			String age, String profile, String gender) {
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
		this.startDate = startDate;
		this.endDate = endDate;
		this.changeName = changeName;
		this.nickName = nickName;
		this.id = id;
		
		this.age = age;
		this.profile = profile;
		this.gender = gender;
	}
	public GuideBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
