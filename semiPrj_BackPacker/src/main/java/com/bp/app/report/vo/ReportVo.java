package com.bp.app.report.vo;

public class ReportVo {
	private String reportNo;
	private String memberNo;
	private String guideBoardNo;
	private String reportContent;
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
	@Override
	public String toString() {
		return "ReportVo [reportNo=" + reportNo + ", memberNo=" + memberNo + ", guideBoardNo=" + guideBoardNo
				+ ", reportContent=" + reportContent + "]";
	}
	public ReportVo(String reportNo, String memberNo, String guideBoardNo, String reportContent) {
		super();
		this.reportNo = reportNo;
		this.memberNo = memberNo;
		this.guideBoardNo = guideBoardNo;
		this.reportContent = reportContent;
	}
	public ReportVo() {
		super();
	}
	
	
}
