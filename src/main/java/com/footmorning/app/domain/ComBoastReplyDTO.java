package com.footmorning.app.domain;

import java.util.Date;

/**
 * 
 * @author 손승한
 *
 */
public class ComBoastReplyDTO {
	   private int com_boast_re_no;
	   private int mem_no;
	   private String com_boast_reply_writer;
	   private String com_boast_re_content;
	   private Date com_boast_re_regdate;
	   private int com_boast_re_pos;
	   private int com_boast_re_depth;
	   private int com_boast_no;
	   private int com_boast_re_group;
	   
	   
	public int getCom_boast_re_no() {
		return com_boast_re_no;
	}
	public void setCom_boast_re_no(int com_boast_re_no) {
		this.com_boast_re_no = com_boast_re_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_boast_reply_writer() {
		return com_boast_reply_writer;
	}
	public void setCom_boast_reply_writer(String com_boast_reply_writer) {
		this.com_boast_reply_writer = com_boast_reply_writer;
	}
	public String getCom_boast_re_content() {
		return com_boast_re_content;
	}
	public void setCom_boast_re_content(String com_boast_re_content) {
		this.com_boast_re_content = com_boast_re_content;
	}
	public Date getCom_boast_re_regdate() {
		return com_boast_re_regdate;
	}
	public void setCom_boast_re_regdate(Date com_boast_re_regdate) {
		this.com_boast_re_regdate = com_boast_re_regdate;
	}
	public int getCom_boast_re_pos() {
		return com_boast_re_pos;
	}
	public void setCom_boast_re_pos(int com_boast_re_pos) {
		this.com_boast_re_pos = com_boast_re_pos;
	}
	public int getCom_boast_re_depth() {
		return com_boast_re_depth;
	}
	public void setCom_boast_re_depth(int com_boast_re_depth) {
		this.com_boast_re_depth = com_boast_re_depth;
	}
	public int getCom_boast_no() {
		return com_boast_no;
	}
	public void setCom_boast_no(int com_boast_no) {
		this.com_boast_no = com_boast_no;
	}
	public int getCom_boast_re_group() {
		return com_boast_re_group;
	}
	public void setCom_boast_re_group(int com_boast_re_group) {
		this.com_boast_re_group = com_boast_re_group;
	}
	@Override
	public String toString() {
		return "ComBoastReplyDTO [com_boast_re_no=" + com_boast_re_no + ", mem_no=" + mem_no
				+ ", com_boast_reply_writer=" + com_boast_reply_writer + ", com_boast_re_content="
				+ com_boast_re_content + ", com_boast_re_regdate=" + com_boast_re_regdate + ", com_boast_re_pos="
				+ com_boast_re_pos + ", com_boast_re_depth=" + com_boast_re_depth + ", com_boast_no=" + com_boast_no
				+ ", com_boast_re_group=" + com_boast_re_group + "]";
	}
}
