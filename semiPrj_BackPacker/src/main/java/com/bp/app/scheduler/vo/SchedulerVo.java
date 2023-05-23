package com.bp.app.scheduler.vo;

public class SchedulerVo {

	private String schedulerNo;
	private String memberNo;
	private String tourTypeNo;
	private String startDate;
	private String endDate;
	private String totalExpense;
	
	//여행날수
	private String totalDay;
	
	private String countryName;
	private String placeImage;

	
	
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPlaceImage() {
		return placeImage;
	}

	public void setPlaceImage(String placeImage) {
		this.placeImage = placeImage;
	}

	public String getSchedulerNo() {
		return schedulerNo;
	}

	public void setSchedulerNo(String schedulerNo) {
		this.schedulerNo = schedulerNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getTourTypeNo() {
		return tourTypeNo;
	}

	public void setTourTypeNo(String tourTypeNo) {
		this.tourTypeNo = tourTypeNo;
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

	public String getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(String totalExpense) {
		this.totalExpense = totalExpense;
	}

	public String getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(String totalDay) {
		this.totalDay = totalDay;
	}

	@Override
	public String toString() {
		return "SchedulerVo [schedulerNo=" + schedulerNo + ", memberNo=" + memberNo + ", tourTypeNo=" + tourTypeNo
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", totalExpense=" + totalExpense + ", totalDay="
				+ totalDay + "]";
	}

	public SchedulerVo(String schedulerNo, String memberNo, String tourTypeNo, String startDate, String endDate,
			String totalExpense, String totalDay) {
		super();
		this.schedulerNo = schedulerNo;
		this.memberNo = memberNo;
		this.tourTypeNo = tourTypeNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalExpense = totalExpense;
		this.totalDay = totalDay;
	}

	public SchedulerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
