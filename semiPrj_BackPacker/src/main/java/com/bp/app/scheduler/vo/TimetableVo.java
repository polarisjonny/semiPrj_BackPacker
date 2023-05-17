package com.bp.app.scheduler.vo;

public class TimetableVo {
	
	private String timetableNo;
	private String placeNo;
	private String schedulerNo;
	private String timetableDate;
	private String bespokePlace;
	private String bespokeTime;
	private String timetableStartTime;
	
	//시작날짜 끝날짜 여행지 이름
	private String placeName;
	private String placeImage;
	private String placeTime;
	private String startDate;
	private String endDate;
	public String getTimetableNo() {
		return timetableNo;
	}
	public void setTimetableNo(String timetableNo) {
		this.timetableNo = timetableNo;
	}
	public String getPlaceNo() {
		return placeNo;
	}
	public void setPlaceNo(String placeNo) {
		this.placeNo = placeNo;
	}
	public String getSchedulerNo() {
		return schedulerNo;
	}
	public void setSchedulerNo(String schedulerNo) {
		this.schedulerNo = schedulerNo;
	}
	public String getTimetableDate() {
		return timetableDate;
	}
	public void setTimetableDate(String timetableDate) {
		this.timetableDate = timetableDate;
	}
	public String getBespokePlace() {
		return bespokePlace;
	}
	public void setBespokePlace(String bespokePlace) {
		this.bespokePlace = bespokePlace;
	}
	public String getBespokeTime() {
		return bespokeTime;
	}
	public void setBespokeTime(String bespokeTime) {
		this.bespokeTime = bespokeTime;
	}
	public String getTimetableStartTime() {
		return timetableStartTime;
	}
	public void setTimetableStartTime(String timetableStartTime) {
		this.timetableStartTime = timetableStartTime;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceImage() {
		return placeImage;
	}
	public void setPlaceImage(String placeImage) {
		this.placeImage = placeImage;
	}
	public String getPlaceTime() {
		return placeTime;
	}
	public void setPlaceTime(String placeTime) {
		this.placeTime = placeTime;
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
		return "TimetableVo [timetableNo=" + timetableNo + ", placeNo=" + placeNo + ", schedulerNo=" + schedulerNo
				+ ", timetableDate=" + timetableDate + ", bespokePlace=" + bespokePlace + ", bespokeTime=" + bespokeTime
				+ ", timetableStartTime=" + timetableStartTime + ", placeName=" + placeName + ", placeImage="
				+ placeImage + ", placeTime=" + placeTime + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public TimetableVo(String timetableNo, String placeNo, String schedulerNo, String timetableDate,
			String bespokePlace, String bespokeTime, String timetableStartTime, String placeName, String placeImage,
			String placeTime, String startDate, String endDate) {
		super();
		this.timetableNo = timetableNo;
		this.placeNo = placeNo;
		this.schedulerNo = schedulerNo;
		this.timetableDate = timetableDate;
		this.bespokePlace = bespokePlace;
		this.bespokeTime = bespokeTime;
		this.timetableStartTime = timetableStartTime;
		this.placeName = placeName;
		this.placeImage = placeImage;
		this.placeTime = placeTime;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public TimetableVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
