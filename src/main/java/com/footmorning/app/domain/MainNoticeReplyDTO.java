package com.footmorning.app.domain;

import java.util.Date;

public class MainNoticeReplyDTO {

	private int main_notice_re_no;
	private String main_notice_re_content;
	private Date main_notice_re_regdate;
	private int main_notice_re_pos;
	private int main_notice_re_depth;
	private int main_notice_no;
	private int main_notice_re_group;
	private int mem_no;
	private String main_notice_re_writer;
	
	public int getMain_notice_re_no() {
		return main_notice_re_no;
	}
	public void setMain_notice_re_no(int main_notice_re_no) {
		this.main_notice_re_no = main_notice_re_no;
	}
	public String getMain_notice_re_content() {
		return main_notice_re_content;
	}
	public void setMain_notice_re_content(String main_notice_re_content) {
		this.main_notice_re_content = main_notice_re_content;
	}
	public Date getMain_notice_re_regdate() {
		return main_notice_re_regdate;
	}
	public void setMain_notice_re_regdate(Date main_notice_re_regdate) {
		this.main_notice_re_regdate = main_notice_re_regdate;
	}
	public int getMain_notice_re_pos() {
		return main_notice_re_pos;
	}
	public void setMain_notice_re_pos(int main_notice_re_pos) {
		this.main_notice_re_pos = main_notice_re_pos;
	}
	public int getMain_notice_re_depth() {
		return main_notice_re_depth;
	}
	public void setMain_notice_re_depth(int main_notice_re_depth) {
		this.main_notice_re_depth = main_notice_re_depth;
	}
	public int getMain_notice_no() {
		return main_notice_no;
	}
	public void setMain_notice_no(int main_notice_no) {
		this.main_notice_no = main_notice_no;
	}
	public int getMain_notice_re_group() {
		return main_notice_re_group;
	}
	public void setMain_notice_re_group(int main_notice_re_group) {
		this.main_notice_re_group = main_notice_re_group;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getMain_notice_re_writer() {
		return main_notice_re_writer;
	}
	public void setMain_notice_re_writer(String main_notice_re_writer) {
		this.main_notice_re_writer = main_notice_re_writer;
	}
	@Override
	public String toString() {
		return "MainNoticeReplyDTO [main_notice_re_no=" + main_notice_re_no + ", main_notice_re_content="
				+ main_notice_re_content + ", main_notice_re_regdate=" + main_notice_re_regdate
				+ ", main_notice_re_pos=" + main_notice_re_pos + ", main_notice_re_depth=" + main_notice_re_depth
				+ ", main_notice_no=" + main_notice_no + ", main_notice_re_group=" + main_notice_re_group + ", mem_no="
				+ mem_no + ", main_notice_re_writer=" + main_notice_re_writer + "]";
	}
}
