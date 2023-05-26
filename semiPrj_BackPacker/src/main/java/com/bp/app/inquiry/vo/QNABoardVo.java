package com.bp.app.inquiry.vo;

public class QNABoardVo {
	
	private String qnaNo;
	private String writerNo;
	private String qnaCategoryNo;
	private String title;
	private String content;
	private String answer;
	private String enrollDate;
	private String deleteYn;
	//카테고리
	private String qnaCategoryName;
	//멤버 NICK ,NAME, ID
	private String name;
	private String nick;
	private String id;
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
	public String getQnaCategoryName() {
		return qnaCategoryName;
	}
	public void setQnaCategoryName(String qnaCategoryName) {
		this.qnaCategoryName = qnaCategoryName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "QNABoardVo [qnaNo=" + qnaNo + ", writerNo=" + writerNo + ", qnaCategoryNo=" + qnaCategoryNo + ", title="
				+ title + ", content=" + content + ", answer=" + answer + ", enrollDate=" + enrollDate + ", deleteYn="
				+ deleteYn + ", qnaCategoryName=" + qnaCategoryName + ", name=" + name + ", nick=" + nick + ", id=" + id
				+ "]";
	}
	public QNABoardVo(String qnaNo, String writerNo, String qnaCategoryNo, String title, String content, String answer,
			String enrollDate, String deleteYn, String qnaCategoryName, String name, String nick, String id) {
		super();
		this.qnaNo = qnaNo;
		this.writerNo = writerNo;
		this.qnaCategoryNo = qnaCategoryNo;
		this.title = title;
		this.content = content;
		this.answer = answer;
		this.enrollDate = enrollDate;
		this.deleteYn = deleteYn;
		this.qnaCategoryName = qnaCategoryName;
		this.name = name;
		this.nick = nick;
		this.id = id;
	}
	public QNABoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
