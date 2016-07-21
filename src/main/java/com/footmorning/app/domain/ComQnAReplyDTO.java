package com.footmorning.app.domain;

public class ComQnAReplyDTO {

	private String com_qna_re_no;
	private String mem_no;
	private String com_qna_no;
	private String com_qna_re_content;
	private String com_qna_re_regdate;
	private String com_qna_re_pos;
	private String com_qna_re_depth;
	private String com_qna_re_group;
	
	
	public String getCom_qna_re_no() {
		return com_qna_re_no;
	}
	public void setCom_qna_re_no(String com_qna_re_no) {
		this.com_qna_re_no = com_qna_re_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getCom_qna_no() {
		return com_qna_no;
	}
	public void setCom_qna_no(String com_qna_no) {
		this.com_qna_no = com_qna_no;
	}
	public String getCom_qna_re_content() {
		return com_qna_re_content;
	}
	public void setCom_qna_re_content(String com_qna_re_content) {
		this.com_qna_re_content = com_qna_re_content;
	}
	public String getCom_qna_re_regdate() {
		return com_qna_re_regdate;
	}
	public void setCom_qna_re_regdate(String com_qna_re_regdate) {
		this.com_qna_re_regdate = com_qna_re_regdate;
	}
	public String getCom_qna_re_pos() {
		return com_qna_re_pos;
	}
	public void setCom_qna_re_pos(String com_qna_re_pos) {
		this.com_qna_re_pos = com_qna_re_pos;
	}
	public String getCom_qna_re_depth() {
		return com_qna_re_depth;
	}
	public void setCom_qna_re_depth(String com_qna_re_depth) {
		this.com_qna_re_depth = com_qna_re_depth;
	}
	public String getCom_qna_re_group() {
		return com_qna_re_group;
	}
	public void setCom_qna_re_group(String com_qna_re_group) {
		this.com_qna_re_group = com_qna_re_group;
	}
	
	@Override
	public String toString() {
		return "ComQnAReplyDTO [com_qna_re_no=" + com_qna_re_no + ", mem_no=" + mem_no + ", com_qna_no=" + com_qna_no
				+ ", com_qna_re_content=" + com_qna_re_content + ", com_qna_re_regdate=" + com_qna_re_regdate
				+ ", com_qna_re_pos=" + com_qna_re_pos + ", com_qna_re_depth=" + com_qna_re_depth
				+ ", com_qna_re_group=" + com_qna_re_group + "]";
	}
	


	
}
