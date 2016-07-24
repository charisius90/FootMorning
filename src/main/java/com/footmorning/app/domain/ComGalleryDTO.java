package com.footmorning.app.domain;

public class ComGalleryDTO {
	
	private String com_gallery_no;
	private String mem_no;
	private String com_gallery_writer;
	private String com_gallery_subject;
	private String com_gallery_content;
	private String com_gallery_regdate;
	private String com_gallery_count;
	
	public String getCom_gallery_no() {
		return com_gallery_no;
	}
	public void setCom_gallery_no(String com_gallery_no) {
		this.com_gallery_no = com_gallery_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_gallery_subject() {
		return com_gallery_subject;
	}
	public void setCom_gallery_subject(String com_gallery_subject) {
		this.com_gallery_subject = com_gallery_subject;
	}
	public String getCom_gallery_content() {
		return com_gallery_content;
	}
	public void setCom_gallery_content(String com_gallery_content) {
		this.com_gallery_content = com_gallery_content;
	}
	public String getCom_gallery_regdate() {
		return com_gallery_regdate;
	}
	public void setCom_gallery_regdate(String com_gallery_regdate) {
		this.com_gallery_regdate = com_gallery_regdate;
	}
	public String getCom_gallery_count() {
		return com_gallery_count;
	}
	public void setCom_gallery_count(String com_gallery_count) {
		this.com_gallery_count = com_gallery_count;
	}
	public String getCom_gallery_writer() {
		return com_gallery_writer;
	}
	public void setCom_gallery_writer(String com_gallery_writer) {
		this.com_gallery_writer = com_gallery_writer;
	}
	
	@Override
	public String toString() {
		return "ComGalleryDTO [com_gallery_no=" + com_gallery_no + ", mem_no=" + mem_no
				+ ", com_gallery_writer=" + com_gallery_writer + ", com_gallery_subject="
				+ com_gallery_subject + ", com_gallery_content=" + com_gallery_content + ", com_gallery_regdate="
				+ com_gallery_regdate + ", com_gallery_count=" + com_gallery_count + "]";
	}
	
}
