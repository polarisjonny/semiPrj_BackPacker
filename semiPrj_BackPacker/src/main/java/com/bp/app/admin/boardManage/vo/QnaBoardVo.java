package com.bp.app.admin.boardManage.vo;

public class QnaBoardVo {
	
	private String qnaNo;
	private String writerNo;
	private String qnaCategoryNo;
	private String title;
	private String content;
	private String answer;
	private String enrollDate;
	private String deleteYn;
	public String getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(String qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getQnaCategoryNo() {
		return qnaCategoryNo;
	}
	public void setQnaCategoryNo(String qnaCategoryNo) {
		this.qnaCategoryNo = qnaCategoryNo;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
		return "QnaBoardVo [qnaNo=" + qnaNo + ", writerNo=" + writerNo + ", qnaCategoryNo=" + qnaCategoryNo + ", title="
				+ title + ", content=" + content + ", answer=" + answer + ", enrollDate=" + enrollDate + ", deleteYn="
				+ deleteYn + "]";
	}
	public QnaBoardVo(String qnaNo, String writerNo, String qnaCategoryNo, String title, String content, String answer,
			String enrollDate, String deleteYn) {
		super();
		this.qnaNo = qnaNo;
		this.writerNo = writerNo;
		this.qnaCategoryNo = qnaCategoryNo;
		this.title = title;
		this.content = content;
		this.answer = answer;
		this.enrollDate = enrollDate;
		this.deleteYn = deleteYn;
	}
	public QnaBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
