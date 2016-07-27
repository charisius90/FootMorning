package com.footmorning.app.domain;

public class ClubDTO {
	private String no;
	private String name;
	private String image;
	private String content;
	private String loc;
	private String type;
	private String regdate;
	private String master;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	
	@Override
	public String toString() {
		return "ClubDTO [no=" + no + ", name=" + name + ", image=" + image + ", content=" + content + ", loc=" + loc
				+ ", type=" + type + ", regdate=" + regdate + ", master=" + master + "]";
	}
}
