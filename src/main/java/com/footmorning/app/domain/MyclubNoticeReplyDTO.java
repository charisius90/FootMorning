package com.footmorning.app.domain;

import java.util.Date;

public class MyclubNoticeReplyDTO {

	private int myclub_notice_no;
	private int mem_no;
	private String myclub_notice_re_content;
	private Date myclub_notice_re_regdate;
	private int myclub_notice_re_pos;
	private int myclub_notice_re_depth;
	private int myclub_notice_re_group;
	private int myclub_notice_re_no;
	private String myclub_notice_re_writer;
	
	public String getMyclub_notice_re_writer() {
		return myclub_notice_re_writer;
	}

	public void setMyclub_notice_re_writer(String myclub_notice_re_writer) {
		this.myclub_notice_re_writer = myclub_notice_re_writer;
	}

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

	public String getMyclub_notice_re_content() {
		return myclub_notice_re_content;
	}

	public void setMyclub_notice_re_content(String myclub_notice_re_content) {
		this.myclub_notice_re_content = myclub_notice_re_content;
	}

	public Date getMyclub_notice_re_regdate() {
		return myclub_notice_re_regdate;
	}

	public void setMyclub_notice_re_regdate(Date myclub_notice_re_regdate) {
		this.myclub_notice_re_regdate = myclub_notice_re_regdate;
	}

	public int getMyclub_notice_re_pos() {
		return myclub_notice_re_pos;
	}

	public void setMyclub_notice_re_pos(int myclub_notice_re_pos) {
		this.myclub_notice_re_pos = myclub_notice_re_pos;
	}

	public int getMyclub_notice_re_depth() {
		return myclub_notice_re_depth;
	}

	public void setMyclub_notice_re_depth(int myclub_notice_re_depth) {
		this.myclub_notice_re_depth = myclub_notice_re_depth;
	}

	public int getMyclub_notice_re_group() {
		return myclub_notice_re_group;
	}

	public void setMyclub_notice_re_group(int myclub_notice_re_group) {
		this.myclub_notice_re_group = myclub_notice_re_group;
	}

	public int getMyclub_notice_re_no() {
		return myclub_notice_re_no;
	}

	public void setMyclub_notice_re_no(int myclub_notice_re_no) {
		this.myclub_notice_re_no = myclub_notice_re_no;
	}

	@Override
	public String toString() {
		return "MyclubNoticeReplyDTO [myclub_notice_no=" + myclub_notice_no + ", mem_no=" + mem_no
				+ ", myclub_notice_re_content=" + myclub_notice_re_content + ", myclub_notice_re_regdate="
				+ myclub_notice_re_regdate + ", myclub_notice_re_pos=" + myclub_notice_re_pos
				+ ", myclub_notice_re_depth=" + myclub_notice_re_depth + ", myclub_notice_re_group="
				+ myclub_notice_re_group + ", myclub_notice_re_no=" + myclub_notice_re_no + ", myclub_notice_re_writer="
				+ myclub_notice_re_writer + "]";
	}
	
}
