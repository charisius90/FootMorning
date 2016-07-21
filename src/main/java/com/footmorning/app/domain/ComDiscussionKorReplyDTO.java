package com.footmorning.app.domain;

public class ComDiscussionKorReplyDTO {
	private String com_discussion_kor_re_no;
	private String mem_no;
	private String com_discussion_kor_no;
	private String com_discussion_kor_content;
	private String com_discussion_kor_regdate;
	private String com_discussion_kor_re_pos;
	private String com_discussion_kor_re_depth;
	private String com_discussion_kor_re_group;
	
	public String getCom_discussion_kor_re_no() {
		return com_discussion_kor_re_no;
	}
	public void setCom_discussion_kor_re_no(String com_discussion_kor_re_no) {
		this.com_discussion_kor_re_no = com_discussion_kor_re_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_discussion_kor_no() {
		return com_discussion_kor_no;
	}
	public void setCom_discussion_kor_no(String com_discussion_kor_no) {
		this.com_discussion_kor_no = com_discussion_kor_no;
	}
	public String getCom_discussion_kor_content() {
		return com_discussion_kor_content;
	}
	public void setCom_discussion_kor_content(String com_discussion_kor_content) {
		this.com_discussion_kor_content = com_discussion_kor_content;
	}
	public String getCom_discussion_kor_regdate() {
		return com_discussion_kor_regdate;
	}
	public void setCom_discussion_kor_regdate(String com_discussion_kor_regdate) {
		this.com_discussion_kor_regdate = com_discussion_kor_regdate;
	}
	public String getCom_discussion_kor_re_pos() {
		return com_discussion_kor_re_pos;
	}
	public void setCom_discussion_kor_re_pos(String com_discussion_kor_re_pos) {
		this.com_discussion_kor_re_pos = com_discussion_kor_re_pos;
	}
	public String getCom_discussion_kor_re_depth() {
		return com_discussion_kor_re_depth;
	}
	public void setCom_discussion_kor_re_depth(String com_discussion_kor_re_depth) {
		this.com_discussion_kor_re_depth = com_discussion_kor_re_depth;
	}
	public String getCom_discussion_kor_re_group() {
		return com_discussion_kor_re_group;
	}
	public void setCom_discussion_kor_re_group(String com_discussion_kor_re_group) {
		this.com_discussion_kor_re_group = com_discussion_kor_re_group;
	}
	
	@Override
	public String toString() {
		return "ComDiscussionKorReplyDTO [com_discussion_kor_re_no=" + com_discussion_kor_re_no + ", mem_no=" + mem_no
				+ ", com_discussion_kor_no=" + com_discussion_kor_no + ", com_discussion_kor_content="
				+ com_discussion_kor_content + ", com_discussion_kor_regdate=" + com_discussion_kor_regdate
				+ ", com_discussion_kor_re_pos=" + com_discussion_kor_re_pos + ", com_discussion_kor_re_depth="
				+ com_discussion_kor_re_depth + ", com_discussion_kor_re_group=" + com_discussion_kor_re_group + "]";
	}
	
}
