package com.footmorning.app.domain;

import java.util.Date;
/**
 * 
 * @author 손승한
 *
 */
public class ComBoastDTO {

	private int com_boast_no;
	private int  mem_no;
	private String com_boast_writer;
	private String com_boast_subject;
	private String com_boast_content;
	private Date com_boast_regdate;
	private String com_boast_main_thumnail;
	private int com_boast_count;
	private String club_name;
	private int club_no;
	private int replycount;
	
	public int getCom_boast_no() {
		return com_boast_no;
	}
	public void setCom_boast_no(int com_boast_no) {
		this.com_boast_no = com_boast_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_boast_writer() {
		return com_boast_writer;
	}
	public void setCom_boast_writer(String com_boast_writer) {
		this.com_boast_writer = com_boast_writer;
	}
	public String getCom_boast_subject() {
		return com_boast_subject;
	}
	public void setCom_boast_subject(String com_boast_subject) {
		this.com_boast_subject = com_boast_subject;
	}
	public String getCom_boast_content() {
		return com_boast_content;
	}
	public void setCom_boast_content(String com_boast_content) {
		this.com_boast_content = com_boast_content;
	}
	public Date getCom_boast_regdate() {
		return com_boast_regdate;
	}
	public void setCom_boast_regdate(Date com_boast_regdate) {
		this.com_boast_regdate = com_boast_regdate;
	}
	public String getCom_boast_main_thumnail() {
		return com_boast_main_thumnail;
	}
	public void setCom_boast_main_thumnail(String com_boast_main_thumnail) {
		this.com_boast_main_thumnail = com_boast_main_thumnail;
	}
	public int getCom_boast_count() {
		return com_boast_count;
	}
	public void setCom_boast_count(int com_boast_count) {
		this.com_boast_count = com_boast_count;
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
		return "ComBoastDTO [com_boast_no=" + com_boast_no + ", mem_no=" + mem_no + ", com_boast_writer="
				+ com_boast_writer + ", com_boast_subject=" + com_boast_subject + ", com_boast_content="
				+ com_boast_content + ", com_boast_regdate=" + com_boast_regdate + ", com_boast_main_thumnail="
				+ com_boast_main_thumnail + ", com_boast_count=" + com_boast_count + ", club_name=" + club_name
				+ ", club_no=" + club_no + ", replycount=" + replycount + "]";
	}
	
	
}
