package com.footmorning.app.domain;

public class ComVideoReplyDTO {
	private String com_video_re_no;
	private String mem_no;
	private String com_video_no;
	private String com_video_re_content;
	private String com_video_re_regdate;
	private String com_video_re_pos;
	private String com_video_re_depth;
	private String com_video_re_group;
	
	public String getCom_video_re_no() {
		return com_video_re_no;
	}
	public void setCom_video_re_no(String com_video_re_no) {
		this.com_video_re_no = com_video_re_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_video_no() {
		return com_video_no;
	}
	public void setCom_video_no(String com_video_no) {
		this.com_video_no = com_video_no;
	}
	public String getCom_video_re_content() {
		return com_video_re_content;
	}
	public void setCom_video_re_content(String com_video_re_content) {
		this.com_video_re_content = com_video_re_content;
	}
	public String getCom_video_re_regdate() {
		return com_video_re_regdate;
	}
	public void setCom_video_re_regdate(String com_video_re_regdate) {
		this.com_video_re_regdate = com_video_re_regdate;
	}
	public String getCom_video_re_pos() {
		return com_video_re_pos;
	}
	public void setCom_video_re_pos(String com_video_re_pos) {
		this.com_video_re_pos = com_video_re_pos;
	}
	public String getCom_video_re_depth() {
		return com_video_re_depth;
	}
	public void setCom_video_re_depth(String com_video_re_depth) {
		this.com_video_re_depth = com_video_re_depth;
	}
	public String getCom_video_re_group() {
		return com_video_re_group;
	}
	public void setCom_video_re_group(String com_video_re_group) {
		this.com_video_re_group = com_video_re_group;
	}
	
	@Override
	public String toString() {
		return "ComVideoReplyDTO [com_video_re_no=" + com_video_re_no + ", mem_no=" + mem_no + ", com_video_no="
				+ com_video_no + ", com_video_re_content=" + com_video_re_content + ", com_video_re_regdate="
				+ com_video_re_regdate + ", com_video_re_pos=" + com_video_re_pos + ", com_video_re_depth="
				+ com_video_re_depth + ", com_video_re_group=" + com_video_re_group + "]";
	}

	
}
