package com.footmorning.app.domain;

public class MyclubFreeDTO {

	private int myclub_free_no;
	private int mem_no;
	private String myclub_free_subject;
	private String myclub_free_content;
	private String myclub_free_regdate;
	private int myclub_free_count;
	private String myclub_free_main_thumnail;
	private String myclub_free_writer;
	private int club_no;

	public int getMyclub_free_no() {
		return myclub_free_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getMyclub_free_subject() {
		return myclub_free_subject;
	}

	public String getMyclub_free_content() {
		return myclub_free_content;
	}

	public String getMyclub_free_regdate() {
		return myclub_free_regdate;
	}

	public int getMyclub_free_count() {
		return myclub_free_count;
	}

	public String getMyclub_free_main_thumnail() {
		return myclub_free_main_thumnail;
	}

	public String getMyclub_free_writer() {
		return myclub_free_writer;
	}

	public int getClub_no() {
		return club_no;
	}

	public void setMyclub_free_no(int myclub_free_no) {
		this.myclub_free_no = myclub_free_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setMyclub_free_subject(String myclub_free_subject) {
		this.myclub_free_subject = myclub_free_subject;
	}

	public void setMyclub_free_content(String myclub_free_content) {
		this.myclub_free_content = myclub_free_content;
	}

	public void setMyclub_free_regdate(String myclub_free_regdate) {
		this.myclub_free_regdate = myclub_free_regdate;
	}

	public void setMyclub_free_count(int myclub_free_count) {
		this.myclub_free_count = myclub_free_count;
	}

	public void setMyclub_free_main_thumnail(String myclub_free_main_thumnail) {
		this.myclub_free_main_thumnail = myclub_free_main_thumnail;
	}

	public void setMyclub_free_writer(String myclub_free_writer) {
		this.myclub_free_writer = myclub_free_writer;
	}

	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}

	@Override
	public String toString() {
		return "MyclubFreeDTO [myclub_free_no=" + myclub_free_no + ", mem_no=" + mem_no + ", myclub_free_subject="
				+ myclub_free_subject + ", myclub_free_content=" + myclub_free_content + ", myclub_free_regdate="
				+ myclub_free_regdate + ", myclub_free_count=" + myclub_free_count + ", myclub_free_main_thumnail="
				+ myclub_free_main_thumnail + ", myclub_free_writer=" + myclub_free_writer + ", club_no=" + club_no
				+ "]";
	}
	
	
}
