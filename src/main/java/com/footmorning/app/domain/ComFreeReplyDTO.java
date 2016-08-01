package com.footmorning.app.domain;

import java.util.Date;

public class ComFreeReplyDTO {
	private int com_free_re_no;
	private int mem_no;
	private String com_free_re_writer;
	private String com_free_re_content;
	private Date com_free_re_regdate;
	private int com_free_re_pos;
	private int com_free_re_depth;
	private int com_free_no;
	private int com_free_re_group;
	public int getCom_free_re_no() {
		return com_free_re_no;
	}
	public void setCom_free_re_no(int com_free_re_no) {
		this.com_free_re_no = com_free_re_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_free_re_writer() {
		return com_free_re_writer;
	}
	public void setCom_free_re_writer(String com_free_re_writer) {
		this.com_free_re_writer = com_free_re_writer;
	}
	public String getCom_free_re_content() {
		return com_free_re_content;
	}
	public void setCom_free_re_content(String com_free_re_content) {
		this.com_free_re_content = com_free_re_content;
	}
	public Date getCom_free_re_regdate() {
		return com_free_re_regdate;
	}
	public void setCom_free_re_regdate(Date com_free_re_regdate) {
		this.com_free_re_regdate = com_free_re_regdate;
	}
	public int getCom_free_re_pos() {
		return com_free_re_pos;
	}
	public void setCom_free_re_pos(int com_free_re_pos) {
		this.com_free_re_pos = com_free_re_pos;
	}
	public int getCom_free_re_depth() {
		return com_free_re_depth;
	}
	public void setCom_free_re_depth(int com_free_re_depth) {
		this.com_free_re_depth = com_free_re_depth;
	}
	public int getCom_free_no() {
		return com_free_no;
	}
	public void setCom_free_no(int com_free_no) {
		this.com_free_no = com_free_no;
	}
	public int getCom_free_re_group() {
		return com_free_re_group;
	}
	public void setCom_free_re_group(int com_free_re_group) {
		this.com_free_re_group = com_free_re_group;
	}
	@Override
	public String toString() {
		return "ComFreeReplyDTO [com_free_re_no=" + com_free_re_no + ", mem_no=" + mem_no + ", com_free_re_writer="
				+ com_free_re_writer + ", com_free_re_content=" + com_free_re_content + ", com_free_re_regdate="
				+ com_free_re_regdate + ", com_free_re_pos=" + com_free_re_pos + ", com_free_re_depth="
				+ com_free_re_depth + ", com_free_no=" + com_free_no + ", com_free_re_group=" + com_free_re_group + "]";
	}

	
	
}
