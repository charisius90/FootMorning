package com.footmorning.app.domain;

import java.util.Date;

public class ChallengeDTO {

	private int challeng_no;
	private int sender_club_no;
	private int receiver_club_no;
	private String challenge_content;
	private int game_no;
	private String game_flag;
	private Date game_date;
	private String game_time;
	private String game_addr;
	private int club_ability;
	
	
	public int getChalleng_no() {
		return challeng_no;
	}
	public void setChalleng_no(int challeng_no) {
		this.challeng_no = challeng_no;
	}
	public int getSender_club_no() {
		return sender_club_no;
	}
	public void setSender_club_no(int sender_club_no) {
		this.sender_club_no = sender_club_no;
	}
	public int getReceiver_club_no() {
		return receiver_club_no;
	}
	public void setReceiver_club_no(int receiver_club_no) {
		this.receiver_club_no = receiver_club_no;
	}
	public String getChallenge_content() {
		return challenge_content;
	}
	public void setChallenge_content(String challenge_content) {
		this.challenge_content = challenge_content;
	}
	public int getGame_no() {
		return game_no;
	}
	public void setGame_no(int game_no) {
		this.game_no = game_no;
	}
	public String getGame_flag() {
		return game_flag;
	}
	public void setGame_flag(String game_flag) {
		this.game_flag = game_flag;
	}
	public Date getGame_date() {
		return game_date;
	}
	public void setGame_date(Date game_date) {
		this.game_date = game_date;
	}
	public String getGame_time() {
		return game_time;
	}
	public void setGame_time(String game_time) {
		this.game_time = game_time;
	}
	public String getGame_addr() {
		return game_addr;
	}
	public void setGame_addr(String game_addr) {
		this.game_addr = game_addr;
	}
	public int getClub_ability() {
		return club_ability;
	}
	public void setClub_ability(int club_ability) {
		this.club_ability = club_ability;
	}
	@Override
	public String toString() {
		return "ChallengeDTO [challeng_no=" + challeng_no + ", sender_club_no=" + sender_club_no + ", receiver_club_no="
				+ receiver_club_no + ", challenge_content=" + challenge_content + ", game_no=" + game_no
				+ ", game_flag=" + game_flag + ", game_date=" + game_date + ", game_time=" + game_time + ", game_addr="
				+ game_addr + ", club_ability=" + club_ability + "]";
	}
	
	
}
