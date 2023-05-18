package com.bp.app.gboard.vo;

public class GuideReplyVo {
	private String guideReplyNo;
	private String writerNo;
	private String guideBoardNo;
	private String content;
	private String enrollDate;
	private String deleteYn;
	
	//예린추가 
	private String profile;
	private String nick;
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getGuideReplyNo() {
		return guideReplyNo;
	}
	public void setGuideReplyNo(String guideReplyNo) {
		this.guideReplyNo = guideReplyNo;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getGuideBoardNo() {
		return guideBoardNo;
	}
	public void setGuideBoardNo(String guideBoardNo) {
		this.guideBoardNo = guideBoardNo;
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
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	@Override
	public String toString() {
		return "GuideReplyVo [guideReplyNo=" + guideReplyNo + ", writerNo=" + writerNo + ", guideBoardNo="
				+ guideBoardNo + ", content=" + content + ", enrollDate=" + enrollDate + ", deleteYn=" + deleteYn
				+ ", profile=" + profile + ", nick=" + nick + "]";
	}
	public GuideReplyVo(String guideReplyNo, String writerNo, String guideBoardNo, String content, String enrollDate,
			String deleteYn, String profile, String nick) {
		super();
		this.guideReplyNo = guideReplyNo;
		this.writerNo = writerNo;
		this.guideBoardNo = guideBoardNo;
		this.content = content;
		this.enrollDate = enrollDate;
		this.deleteYn = deleteYn;
		this.profile = profile;
		this.nick = nick;
	}
	public GuideReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
