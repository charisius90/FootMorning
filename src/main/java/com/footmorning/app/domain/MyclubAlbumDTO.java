package com.footmorning.app.domain;

import java.util.Date;

public class MyclubAlbumDTO {

	private int myclub_album_no;
	private int mem_no;
	private String myclub_album_subject;
	private String myclub_album_content;
	private Date myclub_album_regdate;
	private int myclub_album_count;
	private String myclub_album_main_thumnail;
	private String myclub_album_writer;
	private int club_no;
	private int replycount;

	public int getMyclub_album_no() {
		return myclub_album_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getMyclub_album_subject() {
		return myclub_album_subject;
	}

	public String getMyclub_album_content() {
		return myclub_album_content;
	}

	public Date getMyclub_album_regdate() {
		return myclub_album_regdate;
	}

	public int getMyclub_album_count() {
		return myclub_album_count;
	}

	public String getMyclub_album_main_thumnail() {
		return myclub_album_main_thumnail;
	}

	public String getMyclub_album_writer() {
		return myclub_album_writer;
	}

	public int getClub_no() {
		return club_no;
	}

	public int getReplycount() {
		return replycount;
	}

	public void setMyclub_album_no(int myclub_album_no) {
		this.myclub_album_no = myclub_album_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setMyclub_album_subject(String myclub_album_subject) {
		this.myclub_album_subject = myclub_album_subject;
	}

	public void setMyclub_album_content(String myclub_album_content) {
		this.myclub_album_content = myclub_album_content;
	}

	public void setMyclub_album_regdate(Date myclub_album_regdate) {
		this.myclub_album_regdate = myclub_album_regdate;
	}

	public void setMyclub_album_count(int myclub_album_count) {
		this.myclub_album_count = myclub_album_count;
	}

	public void setMyclub_album_main_thumnail(String myclub_album_main_thumnail) {
		this.myclub_album_main_thumnail = myclub_album_main_thumnail;
	}

	public void setMyclub_album_writer(String myclub_album_writer) {
		this.myclub_album_writer = myclub_album_writer;
	}

	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}

	@Override
	public String toString() {
		return "MyclubAlbumDTO [myclub_album_no=" + myclub_album_no + ", mem_no=" + mem_no + ", myclub_album_subject="
				+ myclub_album_subject + ", myclub_album_content=" + myclub_album_content + ", myclub_album_regdate="
				+ myclub_album_regdate + ", myclub_album_count=" + myclub_album_count + ", myclub_album_main_thumnail="
				+ myclub_album_main_thumnail + ", myclub_album_writer=" + myclub_album_writer + ", club_no=" + club_no
				+ ", replycount=" + replycount + "]";
	}

}
