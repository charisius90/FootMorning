package com.footmorning.app.domain;

public class ClubAuthDTO {

	private int club_no;
	private int mem_garde;
	private int auth_writer;
	private int auth_mod;
	private int auth_cash;
	private int auth_access;
	private int auth_info;
	private int auth_member;
	private int auth_club;

	public int getClub_no() {
		return club_no;
	}

	public int getMem_garde() {
		return mem_garde;
	}

	public int getAuth_writer() {
		return auth_writer;
	}

	public int getAuth_mod() {
		return auth_mod;
	}

	public int getAuth_cash() {
		return auth_cash;
	}

	public int getAuth_access() {
		return auth_access;
	}

	public int getAuth_info() {
		return auth_info;
	}

	public int getAuth_member() {
		return auth_member;
	}

	public int getAuth_club() {
		return auth_club;
	}

	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}

	public void setMem_garde(int mem_garde) {
		this.mem_garde = mem_garde;
	}

	public void setAuth_writer(int auth_writer) {
		this.auth_writer = auth_writer;
	}

	public void setAuth_mod(int auth_mod) {
		this.auth_mod = auth_mod;
	}

	public void setAuth_cash(int auth_cash) {
		this.auth_cash = auth_cash;
	}

	public void setAuth_access(int auth_access) {
		this.auth_access = auth_access;
	}

	public void setAuth_info(int auth_info) {
		this.auth_info = auth_info;
	}

	public void setAuth_member(int auth_member) {
		this.auth_member = auth_member;
	}

	public void setAuth_club(int auth_club) {
		this.auth_club = auth_club;
	}

	@Override
	public String toString() {
		return "ClubAuth [club_no=" + club_no + ", mem_garde=" + mem_garde + ", auth_writer=" + auth_writer
				+ ", auth_mod=" + auth_mod + ", auth_cash=" + auth_cash + ", auth_access=" + auth_access
				+ ", auth_info=" + auth_info + ", auth_member=" + auth_member + ", auth_club=" + auth_club + "]";
	}

}
