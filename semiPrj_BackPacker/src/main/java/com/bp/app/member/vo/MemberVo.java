package com.bp.app.member.vo;

public class MemberVo {
   
   private String memberNo;
   private String isGuide;
   private String memberStatus;
   private String id;
   private String password;
   private String name;
   private String gender;
   private String age;
   private String address;
   private String email;
   private String phoneNumber;
   private String nick;
   private String profileImage;
   private String idCard;
   private String enrollDate;
   private String introMessage;
   private String memberScore;
   public String getMemberNo() {
      return memberNo;
   }
   public void setMemberNo(String memberNo) {
      this.memberNo = memberNo;
   }
   public String getIsGuide() {
      return isGuide;
   }
   public void setIsGuide(String isGuide) {
      this.isGuide = isGuide;
   }
   public String getMemberStatus() {
      return memberStatus;
   }
   public void setMemberStatus(String memberStatus) {
      this.memberStatus = memberStatus;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getGender() {
      return gender;
   }
   public void setGender(String gender) {
      this.gender = gender;
   }
   public String getAge() {
      return age;
   }
   public void setAge(String age) {
      this.age = age;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getPhoneNumber() {
      return phoneNumber;
   }
   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }
   public String getNick() {
      return nick;
   }
   public void setNick(String nick) {
      this.nick = nick;
   }
   public String getProfileImage() {
      return profileImage;
   }
   public void setProfileImage(String profileImage) {
      this.profileImage = profileImage;
   }
   public String getIdCard() {
      return idCard;
   }
   public void setIdCard(String idCard) {
      this.idCard = idCard;
   }
   public String getEnrollDate() {
      return enrollDate;
   }
   public void setEnrollDate(String enrollDate) {
      this.enrollDate = enrollDate;
   }
   public String getIntroMessage() {
      return introMessage;
   }
   public void setIntroMessage(String introMessage) {
      this.introMessage = introMessage;
   }
   public String getMemberScore() {
      return memberScore;
   }
   public void setMemberScore(String memberScore) {
      this.memberScore = memberScore;
   }
   @Override
   public String toString() {
      return "MemberVo [memberNo=" + memberNo + ", isGuide=" + isGuide + ", memberStatus=" + memberStatus + ", id="
            + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", age=" + age
            + ", address=" + address + ", email=" + email + ", phoneNumber=" + phoneNumber + ", nick=" + nick
            + ", profileImage=" + profileImage + ", idCard=" + idCard + ", enrollDate=" + enrollDate
            + ", introMessage=" + introMessage + ", memberScore=" + memberScore + "]";
   }
   public MemberVo(String memberNo, String isGuide, String memberStatus, String id, String password, String name,
         String gender, String age, String address, String email, String phoneNumber, String nick,
         String profileImage, String idCard, String enrollDate, String introMessage, String memberScore) {
      super();
      this.memberNo = memberNo;
      this.isGuide = isGuide;
      this.memberStatus = memberStatus;
      this.id = id;
      this.password = password;
      this.name = name;
      this.gender = gender;
      this.age = age;
      this.address = address;
      this.email = email;
      this.phoneNumber = phoneNumber;
      this.nick = nick;
      this.profileImage = profileImage;
      this.idCard = idCard;
      this.enrollDate = enrollDate;
      this.introMessage = introMessage;
      this.memberScore = memberScore;
   }
   public MemberVo() {
      super();
      // TODO Auto-generated constructor stub
   }
   
   
   
}