package com.footmorning.app.domain;

public class ComBoastDTO {
	private String com_boast_no;
	private String mem_no;
	private String com_boast_subject;
	private String com_boast_content;
	private String com_boast_regdate;
	private String com_boast_count;
	
	public String getCom_boast_no() {
		return com_boast_no;
	}
	public void setCom_boast_no(String com_boast_no) {
		this.com_boast_no = com_boast_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
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
	public String getCom_boast_regdate() {
		return com_boast_regdate;
	}
	public void setCom_boast_regdate(String com_boast_regdate) {
		this.com_boast_regdate = com_boast_regdate;
	}
	public String getCom_boast_count() {
		return com_boast_count;
	}
	public void setCom_boast_count(String com_boast_count) {
		this.com_boast_count = com_boast_count;
	}
	
	@Override
	public String toString() {
		return "ComBoastDTO [com_boast_no=" + com_boast_no + ", mem_no=" + mem_no + ", com_boast_subject="
				+ com_boast_subject + ", com_boast_content=" + com_boast_content + ", com_boast_regdate="
				+ com_boast_regdate + ", com_boast_count=" + com_boast_count + "]";
	}
	
}
