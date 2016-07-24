package com.footmorning.app.domain;

public class ComFreeDTO {
	private String com_free_no;
	private String mem_no;
	private String com_free_writer;
	private String com_free_subject;
	private String com_free_content;
	private String com_free_regdate;
	private String com_free_count;
	public String getCom_free_no() {
		return com_free_no;
	}
	public void setCom_free_no(String com_free_no) {
		this.com_free_no = com_free_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_free_subject() {
		return com_free_subject;
	}
	public void setCom_free_subject(String com_free_subject) {
		this.com_free_subject = com_free_subject;
	}
	public String getCom_free_content() {
		return com_free_content;
	}
	public void setCom_free_content(String com_free_content) {
		this.com_free_content = com_free_content;
	}
	public String getCom_free_regdate() {
		return com_free_regdate;
	}
	public void setCom_free_regdate(String com_free_regdate) {
		this.com_free_regdate = com_free_regdate;
	}
	public String getCom_free_count() {
		return com_free_count;
	}
	public void setCom_free_count(String com_free_count) {
		this.com_free_count = com_free_count;
	}
	public String getCom_free_writer() {
		return com_free_writer;
	}
	public void setCom_free_writer(String com_free_writer) {
		this.com_free_writer = com_free_writer;
	}
	
	@Override
	public String toString() {
		return "ComFreeDTO [com_free_no=" + com_free_no + ", mem_no=" + mem_no
				+ ", com_free_writer=" + com_free_writer + ", com_free_subject="
				+ com_free_subject + ", com_free_content=" + com_free_content + ", com_free_regdate=" + com_free_regdate
				+ ", com_free_count=" + com_free_count + "]";
	}
	
}
