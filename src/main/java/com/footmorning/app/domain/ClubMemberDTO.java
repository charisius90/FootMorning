package com.footmorning.app.domain;

public class ClubMemberDTO {
	private String club_mem_no;
	private String club_no;
	private String mem_no;
	private String mem_gender;
	private String mem_email;
	private String mem_phone;
	private String mem_name;
	private String mem_birth;
	private String club_mem_regdate;
	private String club_mem_flag;
	
	public String getClub_mem_no() {
		return club_mem_no;
	}
	public void setClub_mem_no(String club_mem_no) {
		this.club_mem_no = club_mem_no;
	}
	public String getClub_no() {
		return club_no;
	}
	public void setClub_no(String club_no) {
		this.club_no = club_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}
	public String getClub_mem_regdate() {
		return club_mem_regdate;
	}
	public void setClub_mem_regdate(String club_mem_regdate) {
		this.club_mem_regdate = club_mem_regdate;
	}
	public String getClub_mem_flag() {
		return club_mem_flag;
	}
	public void setClub_mem_flag(String club_mem_flag) {
		this.club_mem_flag = club_mem_flag;
	}
	
	@Override
	public String toString() {
		return "ClubMemberDTO [club_mem_no=" + club_mem_no + ", club_no=" + club_no + ", mem_no=" + mem_no
				+ ", mem_gender=" + mem_gender + ", mem_email=" + mem_email + ", mem_phone=" + mem_phone + ", mem_name="
				+ mem_name + ", mem_birth=" + mem_birth + ", club_mem_regdate=" + club_mem_regdate + ", club_mem_flag="
				+ club_mem_flag + "]";
	}
	
}
