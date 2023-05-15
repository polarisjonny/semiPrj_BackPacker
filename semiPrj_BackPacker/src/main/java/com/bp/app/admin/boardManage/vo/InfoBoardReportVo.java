package com.bp.app.admin.boardManage.vo;

public class InfoBoardReportVo {
	
	private String reportNo;
	private String memberNo;
	private String infoBoardNo;
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
	public String getInfoBoardNo() {
		return infoBoardNo;
	}
	public void setInfoBoardNo(String infoBoardNo) {
		this.infoBoardNo = infoBoardNo;
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
		return "InfoBoardReportVo [reportNo=" + reportNo + ", memberNo=" + memberNo + ", infoBoardNo=" + infoBoardNo
				+ ", reportContent=" + reportContent + ", writerId=" + writerId + ", writerNick=" + writerNick
				+ ", writerName=" + writerName + "]";
	}
	public InfoBoardReportVo(String reportNo, String memberNo, String infoBoardNo, String reportContent,
			String writerId, String writerNick, String writerName) {
		super();
		this.reportNo = reportNo;
		this.memberNo = memberNo;
		this.infoBoardNo = infoBoardNo;
		this.reportContent = reportContent;
		this.writerId = writerId;
		this.writerNick = writerNick;
		this.writerName = writerName;
	}
	public InfoBoardReportVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
