package com.footmorning.app.domain;

import java.util.Date;

public class MyclubVideoDTO {

	private int myclub_video_no;
	private int mem_no;
	private String myclub_video_subject;
	private String myclub_video_content;
	private Date myclub_video_regdate;
	private int myclub_video_count;
	private String myclub_video_main_thumnail;
	private String myclub_video_writer;
	private int club_no;
	private int replycount;

	public int getMyclub_video_no() {
		return myclub_video_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getMyclub_video_subject() {
		return myclub_video_subject;
	}

	public String getMyclub_video_content() {
		return myclub_video_content;
	}

	public Date getMyclub_video_regdate() {
		return myclub_video_regdate;
	}

	public int getMyclub_video_count() {
		return myclub_video_count;
	}

	public String getMyclub_video_main_thumnail() {
		return myclub_video_main_thumnail;
	}

	public String getMyclub_video_writer() {
		return myclub_video_writer;
	}

	public int getClub_no() {
		return club_no;
	}

	public int getReplycount() {
		return replycount;
	}

	public void setMyclub_video_no(int myclub_video_no) {
		this.myclub_video_no = myclub_video_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setMyclub_video_subject(String myclub_video_subject) {
		this.myclub_video_subject = myclub_video_subject;
	}

	public void setMyclub_video_content(String myclub_video_content) {
		this.myclub_video_content = myclub_video_content;
	}

	public void setMyclub_video_regdate(Date myclub_video_regdate) {
		this.myclub_video_regdate = myclub_video_regdate;
	}

	public void setMyclub_video_count(int myclub_video_count) {
		this.myclub_video_count = myclub_video_count;
	}

	public void setMyclub_video_main_thumnail(String myclub_video_main_thumnail) {
		this.myclub_video_main_thumnail = myclub_video_main_thumnail;
	}

	public void setMyclub_video_writer(String myclub_video_writer) {
		this.myclub_video_writer = myclub_video_writer;
	}

	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}

	@Override
	public String toString() {
		return "MyclubVideoDTO [myclub_video_no=" + myclub_video_no + ", mem_no=" + mem_no + ", myclub_video_subject="
				+ myclub_video_subject + ", myclub_video_content=" + myclub_video_content + ", myclub_video_regdate="
				+ myclub_video_regdate + ", myclub_video_count=" + myclub_video_count + ", myclub_video_main_thumnail="
				+ myclub_video_main_thumnail + ", myclub_video_writer=" + myclub_video_writer + ", club_no=" + club_no
				+ ", replycount=" + replycount + "]";
	}

}
