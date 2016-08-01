package com.footmorning.app.domain;

import java.util.Date;

public class MyclubNoticeDTO {

	private int myclub_notice_no;
	private int mem_no;
	private String myclub_notice_subject;
	private String myclub_notice_content;
	private Date myclub_notice_regdate;
	private int myclub_notice_count;
	private String myclub_notice_main_thumnail;
	private String myclub_notice_writer;
	private int club_no;
	private int replycount;

	public int getMyclub_notice_no() {
		return myclub_notice_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getMyclub_notice_subject() {
		return myclub_notice_subject;
	}

	public String getMyclub_notice_content() {
		return myclub_notice_content;
	}

	public Date getMyclub_notice_regdate() {
		return myclub_notice_regdate;
	}

	public int getMyclub_notice_count() {
		return myclub_notice_count;
	}

	public String getMyclub_notice_main_thumnail() {
		return myclub_notice_main_thumnail;
	}

	public String getMyclub_notice_writer() {
		return myclub_notice_writer;
	}

	public int getClub_no() {
		return club_no;
	}

	public int getReplycount() {
		return replycount;
	}

	public void setMyclub_notice_no(int myclub_notice_no) {
		this.myclub_notice_no = myclub_notice_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setMyclub_notice_subject(String myclub_notice_subject) {
		this.myclub_notice_subject = myclub_notice_subject;
	}

	public void setMyclub_notice_content(String myclub_notice_content) {
		this.myclub_notice_content = myclub_notice_content;
	}

	public void setMyclub_notice_regdate(Date myclub_notice_regdate) {
		this.myclub_notice_regdate = myclub_notice_regdate;
	}

	public void setMyclub_notice_count(int myclub_notice_count) {
		this.myclub_notice_count = myclub_notice_count;
	}

	public void setMyclub_notice_main_thumnail(String myclub_notice_main_thumnail) {
		this.myclub_notice_main_thumnail = myclub_notice_main_thumnail;
	}

	public void setMyclub_notice_writer(String myclub_notice_writer) {
		this.myclub_notice_writer = myclub_notice_writer;
	}

	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}

	@Override
	public String toString() {
		return "MyclubNoticeDTO [myclub_notice_no=" + myclub_notice_no + ", mem_no=" + mem_no
				+ ", myclub_notice_subject=" + myclub_notice_subject + ", myclub_notice_content="
				+ myclub_notice_content + ", myclub_notice_regdate=" + myclub_notice_regdate + ", myclub_notice_count="
				+ myclub_notice_count + ", myclub_notice_main_thumnail=" + myclub_notice_main_thumnail
				+ ", myclub_notice_writer=" + myclub_notice_writer + ", club_no=" + club_no + ", replycount="
				+ replycount + "]";
	}

}
