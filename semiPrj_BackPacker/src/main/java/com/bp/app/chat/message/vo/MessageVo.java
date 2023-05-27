package com.bp.app.chat.message.vo;

public class MessageVo {
	
	private String messageNo;
	private String senderNo;
	private String receiverNo;
	private String chattingRoomNo;
	private String content;
	private String enrollDate;
	private String checkYn;
	private String senderNick;
	private String senderProfileImage;
	public String getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(String messageNo) {
		this.messageNo = messageNo;
	}
	public String getSenderNo() {
		return senderNo;
	}
	public void setSenderNo(String senderNo) {
		this.senderNo = senderNo;
	}
	public String getReceiverNo() {
		return receiverNo;
	}
	public void setReceiverNo(String receiverrNo) {
		this.receiverNo = receiverrNo;
	}
	public String getChattingRoomNo() {
		return chattingRoomNo;
	}
	public void setChattingRoomNo(String chattingRoomNo) {
		this.chattingRoomNo = chattingRoomNo;
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
	public String getCheckYn() {
		return checkYn;
	}
	public void setCheckYn(String checkYn) {
		this.checkYn = checkYn;
	}
	public String getSenderNick() {
		return senderNick;
	}
	public void setSenderNick(String senderNick) {
		this.senderNick = senderNick;
	}
	public String getSenderProfileImage() {
		return senderProfileImage;
	}
	public void setSenderProfileImage(String senderProfileImage) {
		this.senderProfileImage = senderProfileImage;
	}
	@Override
	public String toString() {
		return "MessageVo [messageNo=" + messageNo + ", senderNo=" + senderNo + ", receiverrNo=" + receiverNo
				+ ", chattingRoomNo=" + chattingRoomNo + ", content=" + content + ", enrollDate=" + enrollDate
				+ ", checkYn=" + checkYn + ", senderNick=" + senderNick + ", senderProfileImage=" + senderProfileImage
				+ "]";
	}
	public MessageVo(String messageNo, String senderNo, String receiverrNo, String chattingRoomNo, String content,
			String enrollDate, String checkYn, String senderNick, String senderProfileImage) {
		super();
		this.messageNo = messageNo;
		this.senderNo = senderNo;
		this.receiverNo = receiverrNo;
		this.chattingRoomNo = chattingRoomNo;
		this.content = content;
		this.enrollDate = enrollDate;
		this.checkYn = checkYn;
		this.senderNick = senderNick;
		this.senderProfileImage = senderProfileImage;
	}
	public MessageVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
