package com.footmorning.app.domain;

import java.util.Date;

public class ComGalleryReplyDTO {

	private int com_gallery_re_no;
	private String com_gallery_re_content;
	private Date com_gallery_re_regdate;
	private int com_gallery_re_pos;
	private int com_gallery_re_depth;
	private int com_gallery_no;
	private int com_gallery_re_group;
	private int mem_no;
	private String com_gallery_re_writer;

	public int getCom_gallery_re_no() {
		return com_gallery_re_no;
	}

	public String getCom_gallery_re_content() {
		return com_gallery_re_content;
	}

	public Date getCom_gallery_re_regdate() {
		return com_gallery_re_regdate;
	}

	public int getCom_gallery_re_pos() {
		return com_gallery_re_pos;
	}

	public int getCom_gallery_re_depth() {
		return com_gallery_re_depth;
	}

	public int getCom_gallery_no() {
		return com_gallery_no;
	}

	public int getCom_gallery_re_group() {
		return com_gallery_re_group;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getCom_gallery_re_writer() {
		return com_gallery_re_writer;
	}

	public void setCom_gallery_re_no(int com_gallery_re_no) {
		this.com_gallery_re_no = com_gallery_re_no;
	}

	public void setCom_gallery_re_content(String com_gallery_re_content) {
		this.com_gallery_re_content = com_gallery_re_content;
	}

	public void setCom_gallery_re_regdate(Date com_gallery_re_regdate) {
		this.com_gallery_re_regdate = com_gallery_re_regdate;
	}

	public void setCom_gallery_re_pos(int com_gallery_re_pos) {
		this.com_gallery_re_pos = com_gallery_re_pos;
	}

	public void setCom_gallery_re_depth(int com_gallery_re_depth) {
		this.com_gallery_re_depth = com_gallery_re_depth;
	}

	public void setCom_gallery_no(int com_gallery_no) {
		this.com_gallery_no = com_gallery_no;
	}

	public void setCom_gallery_re_group(int com_gallery_re_group) {
		this.com_gallery_re_group = com_gallery_re_group;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setCom_gallery_re_writer(String com_gallery_re_writer) {
		this.com_gallery_re_writer = com_gallery_re_writer;
	}

	@Override
	public String toString() {
		return "ComGalleryReplyDTO [com_gallery_re_no=" + com_gallery_re_no + ", com_gallery_re_content="
				+ com_gallery_re_content + ", com_gallery_re_regdate=" + com_gallery_re_regdate
				+ ", com_gallery_re_pos=" + com_gallery_re_pos + ", com_gallery_re_depth=" + com_gallery_re_depth
				+ ", com_gallery_no=" + com_gallery_no + ", com_gallery_re_group=" + com_gallery_re_group + ", mem_no="
				+ mem_no + ", com_gallery_re_writer=" + com_gallery_re_writer + "]";
	}

}
