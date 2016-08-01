package com.footmorning.app.domain;

import java.util.Date;

public class MyclubTeamReplyDTO {

	private int myclub_team_no;
	private int mem_no;
	private String myclub_team_re_content;
	private Date myclub_team_re_regdate;
	private int myclub_team_re_pos;
	private int myclub_team_re_depth;
	private int myclub_team_re_group;
	private int myclub_team_re_no;
	private String myclub_team_re_writer;

	public int getMyclub_team_no() {
		return myclub_team_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getMyclub_team_re_content() {
		return myclub_team_re_content;
	}

	public Date getMyclub_team_re_regdate() {
		return myclub_team_re_regdate;
	}

	public int getMyclub_team_re_pos() {
		return myclub_team_re_pos;
	}

	public int getMyclub_team_re_depth() {
		return myclub_team_re_depth;
	}

	public int getMyclub_team_re_group() {
		return myclub_team_re_group;
	}

	public int getMyclub_team_re_no() {
		return myclub_team_re_no;
	}

	public String getMyclub_team_re_writer() {
		return myclub_team_re_writer;
	}

	public void setMyclub_team_no(int myclub_team_no) {
		this.myclub_team_no = myclub_team_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setMyclub_team_re_content(String myclub_team_re_content) {
		this.myclub_team_re_content = myclub_team_re_content;
	}

	public void setMyclub_team_re_regdate(Date myclub_team_re_regdate) {
		this.myclub_team_re_regdate = myclub_team_re_regdate;
	}

	public void setMyclub_team_re_pos(int myclub_team_re_pos) {
		this.myclub_team_re_pos = myclub_team_re_pos;
	}

	public void setMyclub_team_re_depth(int myclub_team_re_depth) {
		this.myclub_team_re_depth = myclub_team_re_depth;
	}

	public void setMyclub_team_re_group(int myclub_team_re_group) {
		this.myclub_team_re_group = myclub_team_re_group;
	}

	public void setMyclub_team_re_no(int myclub_team_re_no) {
		this.myclub_team_re_no = myclub_team_re_no;
	}

	public void setMyclub_team_re_writer(String myclub_team_re_writer) {
		this.myclub_team_re_writer = myclub_team_re_writer;
	}

	@Override
	public String toString() {
		return "MyclubTeamReplyDTO [myclub_team_no=" + myclub_team_no + ", mem_no=" + mem_no
				+ ", myclub_team_re_content=" + myclub_team_re_content + ", myclub_team_re_regdate="
				+ myclub_team_re_regdate + ", myclub_team_re_pos=" + myclub_team_re_pos + ", myclub_team_re_depth="
				+ myclub_team_re_depth + ", myclub_team_re_group=" + myclub_team_re_group + ", myclub_team_re_no="
				+ myclub_team_re_no + ", myclub_team_re_writer=" + myclub_team_re_writer + "]";
	}

}
