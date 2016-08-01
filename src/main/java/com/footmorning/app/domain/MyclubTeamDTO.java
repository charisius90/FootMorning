package com.footmorning.app.domain;

/**
 * @author Gyuchae
 *
 */
public class MyclubTeamDTO {

	private int myclub_team_no;
	private int mem_no;
	private String myclub_team_subject;
	private String myclub_team_content;
	private String myclub_team_regdate;
	private int myclub_team_count;
	private String myclub_team_main_thumnail;
	private String myclub_team_writer;
	private int club_no;

	public int getMyclub_team_no() {
		return myclub_team_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getMyclub_team_subject() {
		return myclub_team_subject;
	}

	public String getMyclub_team_content() {
		return myclub_team_content;
	}

	public String getMyclub_team_regdate() {
		return myclub_team_regdate;
	}

	public int getMyclub_team_count() {
		return myclub_team_count;
	}

	public String getMyclub_team_main_thumnail() {
		return myclub_team_main_thumnail;
	}

	public String getMyclub_team_writer() {
		return myclub_team_writer;
	}

	public int getClub_no() {
		return club_no;
	}

	public void setMyclub_team_no(int myclub_team_no) {
		this.myclub_team_no = myclub_team_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setMyclub_team_subject(String myclub_team_subject) {
		this.myclub_team_subject = myclub_team_subject;
	}

	public void setMyclub_team_content(String myclub_team_content) {
		this.myclub_team_content = myclub_team_content;
	}

	public void setMyclub_team_regdate(String myclub_team_regdate) {
		this.myclub_team_regdate = myclub_team_regdate;
	}

	public void setMyclub_team_count(int myclub_team_count) {
		this.myclub_team_count = myclub_team_count;
	}

	public void setMyclub_team_main_thumnail(String myclub_team_main_thumnail) {
		this.myclub_team_main_thumnail = myclub_team_main_thumnail;
	}

	public void setMyclub_team_writer(String myclub_team_writer) {
		this.myclub_team_writer = myclub_team_writer;
	}

	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}

	@Override
	public String toString() {
		return "MyclubTeamDTO [myclub_team_no=" + myclub_team_no + ", mem_no=" + mem_no + ", myclub_team_subject="
				+ myclub_team_subject + ", myclub_team_content=" + myclub_team_content + ", myclub_team_regdate="
				+ myclub_team_regdate + ", myclub_team_count=" + myclub_team_count + ", myclub_team_main_thumnail="
				+ myclub_team_main_thumnail + ", myclub_team_writer=" + myclub_team_writer + ", club_no=" + club_no
				+ "]";
	}

}
