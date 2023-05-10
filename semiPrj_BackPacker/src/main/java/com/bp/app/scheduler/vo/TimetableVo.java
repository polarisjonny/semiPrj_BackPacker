package com.bp.app.scheduler.vo;

public class TimetableVo {
	
	private String timetableNo;
	private String placeNo;
	private String schedulerNo;
	private String timetableDate;
	private String bespokePlace;
	private String bespokeTime;
	private String timetableStartTime;
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
	@Override
	public String toString() {
		return "TimetableVo [timetableNo=" + timetableNo + ", placeNo=" + placeNo + ", schedulerNo=" + schedulerNo
				+ ", timetableDate=" + timetableDate + ", bespokePlace=" + bespokePlace + ", bespokeTime=" + bespokeTime
				+ ", timetableStartTime=" + timetableStartTime + "]";
	}
	public TimetableVo(String timetableNo, String placeNo, String schedulerNo, String timetableDate,
			String bespokePlace, String bespokeTime, String timetableStartTime) {
		super();
		this.timetableNo = timetableNo;
		this.placeNo = placeNo;
		this.schedulerNo = schedulerNo;
		this.timetableDate = timetableDate;
		this.bespokePlace = bespokePlace;
		this.bespokeTime = bespokeTime;
		this.timetableStartTime = timetableStartTime;
	}
	public TimetableVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
