package com.footmorning.app.domain;

public class ComGalleryReplyDTO {
	private String com_gallery_re_no;
	private String mem_no;
	private String com_gallery_no;
	private String com_gallery_re_content;
	private String com_gallery_re_regdate;
	private String com_gallery_re_pos;
	private String com_gallery_re_depth;
	private String com_gallery_re_group;
	
	
	public String getCom_gallery_re_no() {
		return com_gallery_re_no;
	}
	public void setCom_gallery_re_no(String com_gallery_re_no) {
		this.com_gallery_re_no = com_gallery_re_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_gallery_no() {
		return com_gallery_no;
	}
	public void setCom_gallery_no(String com_gallery_no) {
		this.com_gallery_no = com_gallery_no;
	}
	public String getCom_gallery_re_content() {
		return com_gallery_re_content;
	}
	public void setCom_gallery_re_content(String com_gallery_re_content) {
		this.com_gallery_re_content = com_gallery_re_content;
	}
	public String getCom_gallery_re_regdate() {
		return com_gallery_re_regdate;
	}
	public void setCom_gallery_re_regdate(String com_gallery_re_regdate) {
		this.com_gallery_re_regdate = com_gallery_re_regdate;
	}
	public String getCom_gallery_re_pos() {
		return com_gallery_re_pos;
	}
	public void setCom_gallery_re_pos(String com_gallery_re_pos) {
		this.com_gallery_re_pos = com_gallery_re_pos;
	}
	public String getCom_gallery_re_depth() {
		return com_gallery_re_depth;
	}
	public void setCom_gallery_re_depth(String com_gallery_re_depth) {
		this.com_gallery_re_depth = com_gallery_re_depth;
	}
	public String getCom_gallery_re_group() {
		return com_gallery_re_group;
	}
	public void setCom_gallery_re_group(String com_gallery_re_group) {
		this.com_gallery_re_group = com_gallery_re_group;
	}
	
	@Override
	public String toString() {
		return "ComGalleryReplyDTO [com_gallery_re_no=" + com_gallery_re_no + ", mem_no=" + mem_no + ", com_gallery_no="
				+ com_gallery_no + ", com_gallery_re_content=" + com_gallery_re_content + ", com_gallery_re_regdate="
				+ com_gallery_re_regdate + ", com_gallery_re_pos=" + com_gallery_re_pos + ", com_gallery_re_depth="
				+ com_gallery_re_depth + ", com_gallery_re_group=" + com_gallery_re_group + "]";
	}
	

	
}
