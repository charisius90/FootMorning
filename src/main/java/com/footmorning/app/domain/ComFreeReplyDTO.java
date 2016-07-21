package com.footmorning.app.domain;

public class ComFreeReplyDTO {
	private String com_free_re_no;
	private String mem_no;
	private String com_free_re_content;
	private String com_free_re_regdate;
	private String com_free_re_pos;
	private String com_free_re_depth;
	private String com_free_re_group;
	
	public String getCom_free_re_no() {
		return com_free_re_no;
	}
	public void setCom_free_re_no(String com_free_re_no) {
		this.com_free_re_no = com_free_re_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_free_re_content() {
		return com_free_re_content;
	}
	public void setCom_free_re_content(String com_free_re_content) {
		this.com_free_re_content = com_free_re_content;
	}
	public String getCom_free_re_regdate() {
		return com_free_re_regdate;
	}
	public void setCom_free_re_regdate(String com_free_re_regdate) {
		this.com_free_re_regdate = com_free_re_regdate;
	}
	public String getCom_free_re_pos() {
		return com_free_re_pos;
	}
	public void setCom_free_re_pos(String com_free_re_pos) {
		this.com_free_re_pos = com_free_re_pos;
	}
	public String getCom_free_re_depth() {
		return com_free_re_depth;
	}
	public void setCom_free_re_depth(String com_free_re_depth) {
		this.com_free_re_depth = com_free_re_depth;
	}
	public String getCom_free_re_group() {
		return com_free_re_group;
	}
	public void setCom_free_re_group(String com_free_re_group) {
		this.com_free_re_group = com_free_re_group;
	}
	
	@Override
	public String toString() {
		return "ComFreeReply [com_free_re_no=" + com_free_re_no + ", mem_no=" + mem_no + ", com_free_re_content="
				+ com_free_re_content + ", com_free_re_regdate=" + com_free_re_regdate + ", com_free_re_pos="
				+ com_free_re_pos + ", com_free_re_depth=" + com_free_re_depth + ", com_free_re_group="
				+ com_free_re_group + "]";
	}

}
