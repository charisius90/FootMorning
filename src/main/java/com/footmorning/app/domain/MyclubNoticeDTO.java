package com.footmorning.app.domain;

public class MyclubNoticeDTO {

	private int myclub_notice_no;
	private int mem_no;
	private String myclub_notice_subject;
	private String myclub_notice_content;
	private String myclub_notice_regdate;
	private int myclub_notice_count;
	
	public int getMyclub_notice_no() {
		return myclub_notice_no;
	}
	public void setMyclub_notice_no(int myclub_notice_no) {
		this.myclub_notice_no = myclub_notice_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getMyclub_notice_subject() {
		return myclub_notice_subject;
	}
	public void setMyclub_notice_subject(String myclub_notice_subject) {
		this.myclub_notice_subject = myclub_notice_subject;
	}
	public String getMyclub_notice_content() {
		return myclub_notice_content;
	}
	public void setMyclub_notice_content(String myclub_notice_content) {
		this.myclub_notice_content = myclub_notice_content;
	}
	public String getMyclub_notice_regdate() {
		return myclub_notice_regdate;
	}
	public void setMyclub_notice_regdate(String myclub_notice_regdate) {
		this.myclub_notice_regdate = myclub_notice_regdate;
	}
	public int getMyclub_notice_count() {
		return myclub_notice_count;
	}
	public void setMyclub_notice_count(int myclub_notice_count) {
		this.myclub_notice_count = myclub_notice_count;
	}
	@Override
	public String toString() {
		return "MyclubNoticeDTO [myclub_notice_no=" + myclub_notice_no + ", mem_no=" + mem_no
				+ ", myclub_notice_subject=" + myclub_notice_subject + ", myclub_notice_content="
				+ myclub_notice_content + ", myclub_notice_regdate=" + myclub_notice_regdate + ", myclub_notice_count="
				+ myclub_notice_count + "]";
	}
}
