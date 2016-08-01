package com.footmorning.app.domain;

import java.util.Date;

public class ComVideoReplyDTO {

	private int com_video_re_no;
	private String com_video_re_content;
	private Date com_video_re_regdate;
	private int com_video_re_pos;
	private int com_video_re_depth;
	private int com_video_no;
	private int com_video_re_group;
	private int mem_no;
	private String com_video_re_writer;

	public int getCom_video_re_no() {
		return com_video_re_no;
	}

	public String getCom_video_re_content() {
		return com_video_re_content;
	}

	public Date getCom_video_re_regdate() {
		return com_video_re_regdate;
	}

	public int getCom_video_re_pos() {
		return com_video_re_pos;
	}

	public int getCom_video_re_depth() {
		return com_video_re_depth;
	}

	public int getCom_video_no() {
		return com_video_no;
	}

	public int getCom_video_re_group() {
		return com_video_re_group;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getCom_video_re_writer() {
		return com_video_re_writer;
	}

	public void setCom_video_re_no(int com_video_re_no) {
		this.com_video_re_no = com_video_re_no;
	}

	public void setCom_video_re_content(String com_video_re_content) {
		this.com_video_re_content = com_video_re_content;
	}

	public void setCom_video_re_regdate(Date com_video_re_regdate) {
		this.com_video_re_regdate = com_video_re_regdate;
	}

	public void setCom_video_re_pos(int com_video_re_pos) {
		this.com_video_re_pos = com_video_re_pos;
	}

	public void setCom_video_re_depth(int com_video_re_depth) {
		this.com_video_re_depth = com_video_re_depth;
	}

	public void setCom_video_no(int com_video_no) {
		this.com_video_no = com_video_no;
	}

	public void setCom_video_re_group(int com_video_re_group) {
		this.com_video_re_group = com_video_re_group;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setCom_video_re_writer(String com_video_re_writer) {
		this.com_video_re_writer = com_video_re_writer;
	}

	@Override
	public String toString() {
		return "ComvideoReplyDTO [com_video_re_no=" + com_video_re_no + ", com_video_re_content="
				+ com_video_re_content + ", com_video_re_regdate=" + com_video_re_regdate
				+ ", com_video_re_pos=" + com_video_re_pos + ", com_video_re_depth=" + com_video_re_depth
				+ ", com_video_no=" + com_video_no + ", com_video_re_group=" + com_video_re_group + ", mem_no="
				+ mem_no + ", com_video_re_writer=" + com_video_re_writer + "]";
	}

}
