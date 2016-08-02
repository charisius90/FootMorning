package com.footmorning.app.domain;

import java.util.Date;
/**
 * 
 * @author 손승한
 *
 */
public class MainNoticeDTO {

	private int main_notice_no;
	private int  mem_no;
	private String main_notice_writer;
	private String main_notice_subject;
	private String main_notice_content;
	private Date main_notice_regdate;
	private String main_notice_main_thumnail;
	private int main_notice_count;
	private String club_name;
	private int club_no;
	private int replycount;
	
	
	public int getMain_notice_no() {
		return main_notice_no;
	}
	public void setMain_notice_no(int main_notice_no) {
		this.main_notice_no = main_notice_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getMain_notice_writer() {
		return main_notice_writer;
	}
	public void setMain_notice_writer(String main_notice_writer) {
		this.main_notice_writer = main_notice_writer;
	}
	public String getMain_notice_subject() {
		return main_notice_subject;
	}
	public void setMain_notice_subject(String main_notice_subject) {
		this.main_notice_subject = main_notice_subject;
	}
	public String getMain_notice_content() {
		return main_notice_content;
	}
	public void setMain_notice_content(String main_notice_content) {
		this.main_notice_content = main_notice_content;
	}
	public Date getMain_notice_regdate() {
		return main_notice_regdate;
	}
	public void setMain_notice_regdate(Date main_notice_regdate) {
		this.main_notice_regdate = main_notice_regdate;
	}
	public String getMain_notice_main_thumnail() {
		return main_notice_main_thumnail;
	}
	public void setMain_notice_main_thumnail(String main_notice_main_thumnail) {
		this.main_notice_main_thumnail = main_notice_main_thumnail;
	}
	public int getMain_notice_count() {
		return main_notice_count;
	}
	public void setMain_notice_count(int main_notice_count) {
		this.main_notice_count = main_notice_count;
	}
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}
	public int getClub_no() {
		return club_no;
	}
	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	@Override
	public String toString() {
		return "MainNoticeDTO [main_notice_no=" + main_notice_no + ", mem_no=" + mem_no + ", main_notice_writer="
				+ main_notice_writer + ", main_notice_subject=" + main_notice_subject + ", main_notice_content="
				+ main_notice_content + ", main_notice_regdate=" + main_notice_regdate + ", main_notice_main_thumnail="
				+ main_notice_main_thumnail + ", main_notice_count=" + main_notice_count + ", club_name=" + club_name
				+ ", club_no=" + club_no + ", replycount=" + replycount + "]";
	}
}
