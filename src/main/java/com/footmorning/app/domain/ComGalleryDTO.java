package com.footmorning.app.domain;

import java.util.Date;

public class ComGalleryDTO {

	private int com_gallery_no;
	private String com_gallery_subject;
	private String com_gallery_content;
	private Date com_gallery_regdate;
	private int com_gallery_count;
	private int mem_no;
	private String com_gallery_writer;
	private String com_gallery_main_thumnail;
	private int replycount;

	public int getCom_gallery_no() {
		return com_gallery_no;
	}

	public String getCom_gallery_subject() {
		return com_gallery_subject;
	}

	public String getCom_gallery_content() {
		return com_gallery_content;
	}

	public Date getCom_gallery_regdate() {
		return com_gallery_regdate;
	}

	public int getCom_gallery_count() {
		return com_gallery_count;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getCom_gallery_writer() {
		return com_gallery_writer;
	}

	public String getCom_gallery_main_thumnail() {
		return com_gallery_main_thumnail;
	}

	public int getReplycount() {
		return replycount;
	}

	public void setCom_gallery_no(int com_gallery_no) {
		this.com_gallery_no = com_gallery_no;
	}

	public void setCom_gallery_subject(String com_gallery_subject) {
		this.com_gallery_subject = com_gallery_subject;
	}

	public void setCom_gallery_content(String com_gallery_content) {
		this.com_gallery_content = com_gallery_content;
	}

	public void setCom_gallery_regdate(Date com_gallery_regdate) {
		this.com_gallery_regdate = com_gallery_regdate;
	}

	public void setCom_gallery_count(int com_gallery_count) {
		this.com_gallery_count = com_gallery_count;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setCom_gallery_writer(String com_gallery_writer) {
		this.com_gallery_writer = com_gallery_writer;
	}

	public void setCom_gallery_main_thumnail(String com_gallery_main_thumnail) {
		this.com_gallery_main_thumnail = com_gallery_main_thumnail;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}

	@Override
	public String toString() {
		return "ComGalleryDTO [com_gallery_no=" + com_gallery_no + ", com_gallery_subject=" + com_gallery_subject
				+ ", com_gallery_content=" + com_gallery_content + ", com_gallery_regdate=" + com_gallery_regdate
				+ ", com_gallery_count=" + com_gallery_count + ", mem_no=" + mem_no + ", com_gallery_writer="
				+ com_gallery_writer + ", com_gallery_main_thumnail=" + com_gallery_main_thumnail + ", replycount="
				+ replycount + "]";
	}

}
