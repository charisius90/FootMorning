package com.footmorning.app.domain;

public class ComDiscussionWorldDTO {
	private String com_discussion_world_no;
	private String mem_no;
	private String com_discussion_world_subject;
	private String com_discussion_world_content;
	private String com_discussion_world_regdate;
	private String com_discussion_world_count;
	
	public String getCom_discussion_world_no() {
		return com_discussion_world_no;
	}
	public void setCom_discussion_world_no(String com_discussion_world_no) {
		this.com_discussion_world_no = com_discussion_world_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_discussion_world_subject() {
		return com_discussion_world_subject;
	}
	public void setCom_discussion_world_subject(String com_discussion_world_subject) {
		this.com_discussion_world_subject = com_discussion_world_subject;
	}
	public String getCom_discussion_world_content() {
		return com_discussion_world_content;
	}
	public void setCom_discussion_world_content(String com_discussion_world_content) {
		this.com_discussion_world_content = com_discussion_world_content;
	}
	public String getCom_discussion_world_regdate() {
		return com_discussion_world_regdate;
	}
	public void setCom_discussion_world_regdate(String com_discussion_world_regdate) {
		this.com_discussion_world_regdate = com_discussion_world_regdate;
	}
	public String getCom_discussion_world_count() {
		return com_discussion_world_count;
	}
	public void setCom_discussion_world_count(String com_discussion_world_count) {
		this.com_discussion_world_count = com_discussion_world_count;
	}
	
	@Override
	public String toString() {
		return "ComDiscussionWorldDTO [com_discussion_world_no=" + com_discussion_world_no + ", mem_no=" + mem_no
				+ ", com_discussion_world_subject=" + com_discussion_world_subject + ", com_discussion_world_content="
				+ com_discussion_world_content + ", com_discussion_world_regdate=" + com_discussion_world_regdate
				+ ", com_discussion_world_count=" + com_discussion_world_count + "]";
	}


}
