package com.footmorning.app.domain;

public class ComQnADTO {
	
	private String com_qna_no;
	private String mem_no;
	private String com_qna_writer;
	private String com_qna_subject;
	private String com_qna_content;
	private String com_qna_regdate;
	private String com_qna_count;
	
	public String getCom_qna_no() {
		return com_qna_no;
	}
	public void setCom_qna_no(String com_qna_no) {
		this.com_qna_no = com_qna_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
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
	public String getCom_qna_regdate() {
		return com_qna_regdate;
	}
	public void setCom_qna_regdate(String com_qna_regdate) {
		this.com_qna_regdate = com_qna_regdate;
	}
	public String getCom_qna_count() {
		return com_qna_count;
	}
	public void setCom_qna_count(String com_qna_count) {
		this.com_qna_count = com_qna_count;
	}
	public String getCom_qna_writer() {
		return com_qna_writer;
	}
	public void setCom_qna_writer(String com_qna_writer) {
		this.com_qna_writer = com_qna_writer;
	}
	
	@Override
	public String toString() {
		return "ComQnADTO [com_qna_no=" + com_qna_no + ", mem_no=" + mem_no
				+ ", com_qna_writer=" + com_qna_writer + ", com_qna_subject=" + com_qna_subject
				+ ", com_qna_content=" + com_qna_content + ", com_qna_regdate=" + com_qna_regdate + ", com_qna_count="
				+ com_qna_count + "]";
	}
	
}
