package com.bp.app.chat.room.vo;

public class ChattingRoomVo {
   
   private String chattingRoomNo;
   private String chattingUserNo;
   private String chattingUser2No;
   private String guideBoardNo;
   private String matchingCheck;
   private String matchingCheck2;
   private String chattingStatus;
   private String chattingUserNick;
   private String chattingUser2Nick;
   private String chattingUserProfile;
   private String chattingUser2Profile;
   private String chattingUserId;
   private String chattingUser2Id;
   private String boardTitle;
   private String boardCategoryName;
   private String guideBoardTitle;
public String getChattingRoomNo() {
	return chattingRoomNo;
}
public void setChattingRoomNo(String chattingRoomNo) {
	this.chattingRoomNo = chattingRoomNo;
}
public String getChattingUserNo() {
	return chattingUserNo;
}
public void setChattingUserNo(String chattingUserNo) {
	this.chattingUserNo = chattingUserNo;
}
public String getChattingUser2No() {
	return chattingUser2No;
}
public void setChattingUser2No(String chattingUser2No) {
	this.chattingUser2No = chattingUser2No;
}
public String getGuideBoardNo() {
	return guideBoardNo;
}
public void setGuideBoardNo(String guideBoardNo) {
	this.guideBoardNo = guideBoardNo;
}
public String getMatchingCheck() {
	return matchingCheck;
}
public void setMatchingCheck(String matchingCheck) {
	this.matchingCheck = matchingCheck;
}
public String getMatchingCheck2() {
	return matchingCheck2;
}
public void setMatchingCheck2(String matchingCheck2) {
	this.matchingCheck2 = matchingCheck2;
}
public String getChattingStatus() {
	return chattingStatus;
}
public void setChattingStatus(String chattingStatus) {
	this.chattingStatus = chattingStatus;
}
public String getChattingUserNick() {
	return chattingUserNick;
}
public void setChattingUserNick(String chattingUserNick) {
	this.chattingUserNick = chattingUserNick;
}
public String getChattingUser2Nick() {
	return chattingUser2Nick;
}
public void setChattingUser2Nick(String chattingUser2Nick) {
	this.chattingUser2Nick = chattingUser2Nick;
}
public String getChattingUserProfile() {
	return chattingUserProfile;
}
public void setChattingUserProfile(String chattingUserProfile) {
	this.chattingUserProfile = chattingUserProfile;
}
public String getChattingUser2Profile() {
	return chattingUser2Profile;
}
public void setChattingUser2Profile(String chattingUser2Profile) {
	this.chattingUser2Profile = chattingUser2Profile;
}
public String getChattingUserId() {
	return chattingUserId;
}
public void setChattingUserId(String chattingUserId) {
	this.chattingUserId = chattingUserId;
}
public String getChattingUser2Id() {
	return chattingUser2Id;
}
public void setChattingUser2Id(String chattingUser2Id) {
	this.chattingUser2Id = chattingUser2Id;
}
public String getBoardTitle() {
	return boardTitle;
}
public void setBoardTitle(String boardTitle) {
	this.boardTitle = boardTitle;
}
public String getBoardCategoryName() {
	return boardCategoryName;
}
public void setBoardCategoryName(String boardCategoryName) {
	this.boardCategoryName = boardCategoryName;
}
public String getGuideBoardTitle() {
	return guideBoardTitle;
}
public void setGuideBoardTitle(String guideBoardTitle) {
	this.guideBoardTitle = guideBoardTitle;
}
@Override
public String toString() {
	return "ChattingRoomVo [chattingRoomNo=" + chattingRoomNo + ", chattingUserNo=" + chattingUserNo
			+ ", chattingUser2No=" + chattingUser2No + ", guideBoardNo=" + guideBoardNo + ", matchingCheck="
			+ matchingCheck + ", matchingCheck2=" + matchingCheck2 + ", chattingStatus=" + chattingStatus
			+ ", chattingUserNick=" + chattingUserNick + ", chattingUser2Nick=" + chattingUser2Nick
			+ ", chattingUserProfile=" + chattingUserProfile + ", chattingUser2Profile=" + chattingUser2Profile
			+ ", chattingUserId=" + chattingUserId + ", chattingUser2Id=" + chattingUser2Id + ", boardTitle="
			+ boardTitle + ", boardCategoryName=" + boardCategoryName + ", guideBoardTitle=" + guideBoardTitle + "]";
}
public ChattingRoomVo(String chattingRoomNo, String chattingUserNo, String chattingUser2No, String guideBoardNo,
		String matchingCheck, String matchingCheck2, String chattingStatus, String chattingUserNick,
		String chattingUser2Nick, String chattingUserProfile, String chattingUser2Profile, String chattingUserId,
		String chattingUser2Id, String boardTitle, String boardCategoryName, String guideBoardTitle) {
	super();
	this.chattingRoomNo = chattingRoomNo;
	this.chattingUserNo = chattingUserNo;
	this.chattingUser2No = chattingUser2No;
	this.guideBoardNo = guideBoardNo;
	this.matchingCheck = matchingCheck;
	this.matchingCheck2 = matchingCheck2;
	this.chattingStatus = chattingStatus;
	this.chattingUserNick = chattingUserNick;
	this.chattingUser2Nick = chattingUser2Nick;
	this.chattingUserProfile = chattingUserProfile;
	this.chattingUser2Profile = chattingUser2Profile;
	this.chattingUserId = chattingUserId;
	this.chattingUser2Id = chattingUser2Id;
	this.boardTitle = boardTitle;
	this.boardCategoryName = boardCategoryName;
	this.guideBoardTitle = guideBoardTitle;
}
public ChattingRoomVo() {
	super();
	// TODO Auto-generated constructor stub
}
   
   

}