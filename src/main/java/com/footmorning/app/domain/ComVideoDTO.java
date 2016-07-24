package com.footmorning.app.domain;

public class ComVideoDTO {
	private String com_video_no;
	private String mem_no;
	private String com_video_writer;
	private String com_video_subject;
	private String com_video_content;
	private String com_video_regdate;
	private String com_video_count;
	
	public String getCom_video_no() {
		return com_video_no;
	}
	public void setCom_video_no(String com_video_no) {
		this.com_video_no = com_video_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_video_subject() {
		return com_video_subject;
	}
	public void setCom_video_subject(String com_video_subject) {
		this.com_video_subject = com_video_subject;
	}
	public String getCom_video_content() {
		return com_video_content;
	}
	public void setCom_video_content(String com_video_content) {
		this.com_video_content = com_video_content;
	}
	public String getCom_video_regdate() {
		return com_video_regdate;
	}
	public void setCom_video_regdate(String com_video_regdate) {
		this.com_video_regdate = com_video_regdate;
	}
	public String getCom_video_count() {
		return com_video_count;
	}
	public void setCom_video_count(String com_video_count) {
		this.com_video_count = com_video_count;
	}
	public String getCom_video_writer() {
		return com_video_writer;
	}
	public void setCom_video_writer(String com_video_writer) {
		this.com_video_writer = com_video_writer;
	}
	
	@Override
	public String toString() {
		return "ComVideoDTO [com_video_no=" + com_video_no + ", mem_no=" + mem_no
				+ ", com_video_writer=" + com_video_writer + ", com_video_subject="
				+ com_video_subject + ", com_video_content=" + com_video_content + ", com_video_regdate="
				+ com_video_regdate + ", com_video_count=" + com_video_count + "]";
	}

}
