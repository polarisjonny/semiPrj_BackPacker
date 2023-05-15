package com.bp.app.admin.boardManage.vo;

public class GuideReportVo {
	
	private String reportNo;
	private String memberNo;
	private String guideBoardNo;
	private String reportContent;
	private String writerId;
	private String writerNick;
	private String writerName;
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getGuideBoardNo() {
		return guideBoardNo;
	}
	public void setGuideBoardNo(String guideBoardNo) {
		this.guideBoardNo = guideBoardNo;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
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
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	@Override
	public String toString() {
		return "GuideReportVo [reportNo=" + reportNo + ", memberNo=" + memberNo + ", guideBoardNo=" + guideBoardNo
				+ ", reportContent=" + reportContent + ", writerId=" + writerId + ", writerNick=" + writerNick
				+ ", writerName=" + writerName + "]";
	}
	public GuideReportVo(String reportNo, String memberNo, String guideBoardNo, String reportContent, String writerId,
			String writerNick, String writerName) {
		super();
		this.reportNo = reportNo;
		this.memberNo = memberNo;
		this.guideBoardNo = guideBoardNo;
		this.reportContent = reportContent;
		this.writerId = writerId;
		this.writerNick = writerNick;
		this.writerName = writerName;
	}
	public GuideReportVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
