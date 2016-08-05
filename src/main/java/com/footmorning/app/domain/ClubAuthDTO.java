package com.footmorning.app.domain;

public class ClubAuthDTO {

	private String club_no;
	private String mem_grade;
	private String auth_write;
	private String auth_mod;
	private String auth_cash;
	private String auth_access;
	private String auth_info;
	private String auth_member;
	private String auth_club;

	public String getClub_no() {
		return club_no;
	}

	public String getAuth_write() {
		return auth_write;
	}

	public String getAuth_mod() {
		return auth_mod;
	}

	public String getAuth_cash() {
		return auth_cash;
	}

	public String getAuth_access() {
		return auth_access;
	}

	public String getAuth_info() {
		return auth_info;
	}

	public String getAuth_member() {
		return auth_member;
	}

	public String getAuth_club() {
		return auth_club;
	}

	public void setClub_no(String club_no) {
		this.club_no = club_no;
	}

	public void setAuth_write(String auth_write) {
		this.auth_write = auth_write;
	}

	public void setAuth_mod(String auth_mod) {
		this.auth_mod = auth_mod;
	}

	public void setAuth_cash(String auth_cash) {
		this.auth_cash = auth_cash;
	}

	public void setAuth_access(String auth_access) {
		this.auth_access = auth_access;
	}

	public void setAuth_info(String auth_info) {
		this.auth_info = auth_info;
	}

	public void setAuth_member(String auth_member) {
		this.auth_member = auth_member;
	}

	public void setAuth_club(String auth_club) {
		this.auth_club = auth_club;
	}

	public String getMem_grade() {
		return mem_grade;
	}
	
	public void setMem_grade(String mem_grade) {
		this.mem_grade = mem_grade;
	}
	
	@Override
	public String toString() {
		return "ClubAuth [club_no=" + club_no + ", mem_grade=" + mem_grade + ", auth_write=" + auth_write
				+ ", auth_mod=" + auth_mod + ", auth_cash=" + auth_cash + ", auth_access=" + auth_access
				+ ", auth_info=" + auth_info + ", auth_member=" + auth_member + ", auth_club=" + auth_club + "]";
	}

}
