package com.footmorning.app.domain;

import java.util.Date;

public class ComQnADTO {
	
	private int com_qna_no;
	private int  mem_no;
	private String com_qna_writer;
	private String com_qna_subject;
	private String com_qna_content;
	private Date com_qna_regdate;
	private String com_qna_main_thumnail;
	private int com_qna_count;
	
	
	public int getCom_qna_no() {
		return com_qna_no;
	}
	public void setCom_qna_no(int com_qna_no) {
		this.com_qna_no = com_qna_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_qna_writer() {
		return com_qna_writer;
	}
	public void setCom_qna_writer(String com_qna_writer) {
		this.com_qna_writer = com_qna_writer;
	}
	public String getCom_qna_subject() {
		return com_qna_subject;
	}
	public void setCom_qna_subject(String com_qna_subject) {
		this.com_qna_subject = com_qna_subject;
	}
	public String getCom_qna_content() {
		return com_qna_content;
	}
	public void setCom_qna_content(String com_qna_content) {
		this.com_qna_content = com_qna_content;
	}
	public Date getCom_qna_regdate() {
		return com_qna_regdate;
	}
	public void setCom_qna_regdate(Date com_qna_regdate) {
		this.com_qna_regdate = com_qna_regdate;
	}
	public String getCom_qna_main_thumnail() {
		return com_qna_main_thumnail;
	}
	public void setCom_qna_main_thumnail(String com_qna_main_thumnail) {
		this.com_qna_main_thumnail = com_qna_main_thumnail;
	}
	public int getCom_qna_count() {
		return com_qna_count;
	}
	public void setCom_qna_count(int com_qna_count) {
		this.com_qna_count = com_qna_count;
	}
	@Override
	public String toString() {
		return "ComQnADTO [com_qna_no=" + com_qna_no + ", mem_no=" + mem_no + ", com_qna_writer=" + com_qna_writer
				+ ", com_qna_subject=" + com_qna_subject + ", com_qna_content=" + com_qna_content + ", com_qna_regdate="
				+ com_qna_regdate + ", com_qna_main_thumnail=" + com_qna_main_thumnail + ", com_qna_count="
				+ com_qna_count + "]";
	}
	

	
}
