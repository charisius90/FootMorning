package com.footmorning.app.domain;

import java.util.Date;

public class MyclubAlbumReplyDTO {
	
	private int myclub_album_no;
	private int mem_no;
	private String myclub_album_re_content;
	private Date myclub_album_re_regdate;
	private int myclub_album_re_pos;
	private int myclub_album_re_depth;
	private int myclub_album_re_group;
	private int myclub_album_re_no;
	private String myclub_album_re_writer;

	public int getMyclub_album_no() {
		return myclub_album_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getMyclub_album_re_content() {
		return myclub_album_re_content;
	}

	public Date getMyclub_album_re_regdate() {
		return myclub_album_re_regdate;
	}

	public int getMyclub_album_re_pos() {
		return myclub_album_re_pos;
	}

	public int getMyclub_album_re_depth() {
		return myclub_album_re_depth;
	}

	public int getMyclub_album_re_group() {
		return myclub_album_re_group;
	}

	public int getMyclub_album_re_no() {
		return myclub_album_re_no;
	}

	public String getMyclub_album_re_writer() {
		return myclub_album_re_writer;
	}

	public void setMyclub_album_no(int myclub_album_no) {
		this.myclub_album_no = myclub_album_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setMyclub_album_re_content(String myclub_album_re_content) {
		this.myclub_album_re_content = myclub_album_re_content;
	}

	public void setMyclub_album_re_regdate(Date myclub_album_re_regdate) {
		this.myclub_album_re_regdate = myclub_album_re_regdate;
	}

	public void setMyclub_album_re_pos(int myclub_album_re_pos) {
		this.myclub_album_re_pos = myclub_album_re_pos;
	}

	public void setMyclub_album_re_depth(int myclub_album_re_depth) {
		this.myclub_album_re_depth = myclub_album_re_depth;
	}

	public void setMyclub_album_re_group(int myclub_album_re_group) {
		this.myclub_album_re_group = myclub_album_re_group;
	}

	public void setMyclub_album_re_no(int myclub_album_re_no) {
		this.myclub_album_re_no = myclub_album_re_no;
	}

	public void setMyclub_album_re_writer(String myclub_album_re_writer) {
		this.myclub_album_re_writer = myclub_album_re_writer;
	}

	@Override
	public String toString() {
		return "MyclubAlbumReplyDTO [myclub_album_no=" + myclub_album_no + ", mem_no=" + mem_no
				+ ", myclub_album_re_content=" + myclub_album_re_content + ", myclub_album_re_regdate="
				+ myclub_album_re_regdate + ", myclub_album_re_pos=" + myclub_album_re_pos + ", myclub_album_re_depth="
				+ myclub_album_re_depth + ", myclub_album_re_group=" + myclub_album_re_group + ", myclub_album_re_no="
				+ myclub_album_re_no + ", myclub_album_re_writer=" + myclub_album_re_writer + "]";
	}

}
