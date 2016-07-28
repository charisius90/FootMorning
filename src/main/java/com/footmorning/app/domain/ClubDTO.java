package com.footmorning.app.domain;

public class ClubDTO {
	private String club_no;
	private String club_name;
	private String club_image;
	private String club_content;
	private String club_loc;
	private String club_type;
	private String club_regdate;
	private String club_master;
	private String club_master_name;
	private String club_mem_count;
	
	public String getClub_no() {
		return club_no;
	}
	public void setClub_no(String club_no) {
		this.club_no = club_no;
	}
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}
	public String getClub_image() {
		return club_image;
	}
	public void setClub_image(String club_image) {
		this.club_image = club_image;
	}
	public String getClub_content() {
		return club_content;
	}
	public void setClub_content(String club_content) {
		this.club_content = club_content;
	}
	public String getClub_loc() {
		return club_loc;
	}
	public void setClub_loc(String club_loc) {
		this.club_loc = club_loc;
	}
	public String getClub_type() {
		return club_type;
	}
	public void setClub_type(String club_type) {
		this.club_type = club_type;
	}
	public String getClub_regdate() {
		return club_regdate;
	}
	public void setClub_regdate(String club_regdate) {
		this.club_regdate = club_regdate;
	}
	public String getClub_master() {
		return club_master;
	}
	public void setClub_master(String club_master) {
		this.club_master = club_master;
	}
	public String getClub_master_name() {
		return club_master_name;
	}
	public void setClub_master_name(String club_master_name) {
		this.club_master_name = club_master_name;
	}
	public String getClub_mem_count() {
		return club_mem_count;
	}
	public void setClub_mem_count(String club_mem_count) {
		this.club_mem_count = club_mem_count;
	}
	
	@Override
	public String toString() {
		return "ClubDTO [club_no=" + club_no + ", club_name=" + club_name + ", club_image=" + club_image
				+ ", club_content=" + club_content + ", club_loc=" + club_loc + ", club_type=" + club_type
				+ ", club_regdate=" + club_regdate + ", club_master=" + club_master + ", club_master_name="
				+ club_master_name + ", club_mem_count=" + club_mem_count + "]";
	}
	
}
