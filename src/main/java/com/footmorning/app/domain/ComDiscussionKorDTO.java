package com.footmorning.app.domain;

import java.util.Date;

public class ComDiscussionKorDTO {
	
	private int com_discussion_kor_no;
	private int  mem_no;
	private String com_discussion_kor_writer;
	private String com_discussion_kor_subject;
	private String com_discussion_kor_content;
	private Date com_discussion_kor_regdate;
	private String com_discussion_kor_main_thumnail;
	private int com_discussion_kor_count;
	private int replycount;
	
	public int getCom_discussion_kor_no() {
		return com_discussion_kor_no;
	}
	public void setCom_discussion_kor_no(int com_discussion_kor_no) {
		this.com_discussion_kor_no = com_discussion_kor_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_discussion_kor_writer() {
		return com_discussion_kor_writer;
	}
	public void setCom_discussion_kor_writer(String com_discussion_kor_writer) {
		this.com_discussion_kor_writer = com_discussion_kor_writer;
	}
	public String getCom_discussion_kor_subject() {
		return com_discussion_kor_subject;
	}
	public void setCom_discussion_kor_subject(String com_discussion_kor_subject) {
		this.com_discussion_kor_subject = com_discussion_kor_subject;
	}
	public String getCom_discussion_kor_content() {
		return com_discussion_kor_content;
	}
	public void setCom_discussion_kor_content(String com_discussion_kor_content) {
		this.com_discussion_kor_content = com_discussion_kor_content;
	}
	public Date getCom_discussion_kor_regdate() {
		return com_discussion_kor_regdate;
	}
	public void setCom_discussion_kor_regdate(Date com_discussion_kor_regdate) {
		this.com_discussion_kor_regdate = com_discussion_kor_regdate;
	}
	public String getCom_discussion_kor_main_thumnail() {
		return com_discussion_kor_main_thumnail;
	}
	public void setCom_discussion_kor_main_thumnail(String com_discussion_kor_main_thumnail) {
		this.com_discussion_kor_main_thumnail = com_discussion_kor_main_thumnail;
	}
	public int getCom_discussion_kor_count() {
		return com_discussion_kor_count;
	}
	public void setCom_discussion_kor_count(int com_discussion_kor_count) {
		this.com_discussion_kor_count = com_discussion_kor_count;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	@Override
	public String toString() {
		return "ComDiscussionKorDTO [com_discussion_kor_no=" + com_discussion_kor_no + ", mem_no=" + mem_no
				+ ", com_discussion_kor_writer=" + com_discussion_kor_writer + ", com_discussion_kor_subject="
				+ com_discussion_kor_subject + ", com_discussion_kor_content=" + com_discussion_kor_content
				+ ", com_discussion_kor_regdate=" + com_discussion_kor_regdate + ", com_discussion_kor_main_thumnail="
				+ com_discussion_kor_main_thumnail + ", com_discussion_kor_count=" + com_discussion_kor_count
				+ ", replycount=" + replycount + "]";
	}
	
}
