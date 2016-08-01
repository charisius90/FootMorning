package com.footmorning.app.domain;

import java.util.Date;

public class MyclubVideoReplyDTO {
	
	private int myclub_video_no;
	private int mem_no;
	private String myclub_video_re_content;
	private Date myclub_video_re_regdate;
	private int myclub_video_re_pos;
	private int myclub_video_re_depth;
	private int myclub_video_re_group;
	private int myclub_video_re_no;
	private String myclub_video_re_writer;

	public int getMyclub_video_no() {
		return myclub_video_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getMyclub_video_re_content() {
		return myclub_video_re_content;
	}

	public Date getMyclub_video_re_regdate() {
		return myclub_video_re_regdate;
	}

	public int getMyclub_video_re_pos() {
		return myclub_video_re_pos;
	}

	public int getMyclub_video_re_depth() {
		return myclub_video_re_depth;
	}

	public int getMyclub_video_re_group() {
		return myclub_video_re_group;
	}

	public int getMyclub_video_re_no() {
		return myclub_video_re_no;
	}

	public String getMyclub_video_re_writer() {
		return myclub_video_re_writer;
	}

	public void setMyclub_video_no(int myclub_video_no) {
		this.myclub_video_no = myclub_video_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setMyclub_video_re_content(String myclub_video_re_content) {
		this.myclub_video_re_content = myclub_video_re_content;
	}

	public void setMyclub_video_re_regdate(Date myclub_video_re_regdate) {
		this.myclub_video_re_regdate = myclub_video_re_regdate;
	}

	public void setMyclub_video_re_pos(int myclub_video_re_pos) {
		this.myclub_video_re_pos = myclub_video_re_pos;
	}

	public void setMyclub_video_re_depth(int myclub_video_re_depth) {
		this.myclub_video_re_depth = myclub_video_re_depth;
	}

	public void setMyclub_video_re_group(int myclub_video_re_group) {
		this.myclub_video_re_group = myclub_video_re_group;
	}

	public void setMyclub_video_re_no(int myclub_video_re_no) {
		this.myclub_video_re_no = myclub_video_re_no;
	}

	public void setMyclub_video_re_writer(String myclub_video_re_writer) {
		this.myclub_video_re_writer = myclub_video_re_writer;
	}

	@Override
	public String toString() {
		return "MyclubVideoReplyDTO [myclub_video_no=" + myclub_video_no + ", mem_no=" + mem_no
				+ ", myclub_video_re_content=" + myclub_video_re_content + ", myclub_video_re_regdate="
				+ myclub_video_re_regdate + ", myclub_video_re_pos=" + myclub_video_re_pos + ", myclub_video_re_depth="
				+ myclub_video_re_depth + ", myclub_video_re_group=" + myclub_video_re_group + ", myclub_video_re_no="
				+ myclub_video_re_no + ", myclub_video_re_writer=" + myclub_video_re_writer + "]";
	}

}
