package com.footmorning.app.domain;

import java.util.Date;

public class MatchDTO {
	   private int game_no;
	   private Date game_date;
	   private String game_time;
	   private String game_addr;
	   private String game_flag;
	   private int club_no;
	   private int game_score;
	   private String club_name;
	   private int club_ability;
	   private String club_master_name;
	   
	   
	   
	   
	   
	public String getClub_master_name() {
		return club_master_name;
	}
	public void setClub_master_name(String club_master_name) {
		this.club_master_name = club_master_name;
	}
	public int getClub_ability() {
		return club_ability;
	}
	public void setClub_ability(int club_ability) {
		this.club_ability = club_ability;
	}
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}
	public int getGame_no() {
		return game_no;
	}
	public void setGame_no(int game_no) {
		this.game_no = game_no;
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
	public String getGame_flag() {
		return game_flag;
	}
	public void setGame_flag(String game_flag) {
		this.game_flag = game_flag;
	}
	public int getClub_no() {
		return club_no;
	}
	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}
	public int getGame_score() {
		return game_score;
	}
	public void setGame_score(int game_score) {
		this.game_score = game_score;
	}
	@Override
	public String toString() {
		return "MatchDTO [game_no=" + game_no + ", game_date=" + game_date + ", game_time=" + game_time + ", game_addr="
				+ game_addr + ", game_flag=" + game_flag + ", club_no=" + club_no + ", game_score=" + game_score
				+ ", club_name=" + club_name + ", club_ability=" + club_ability + ", club_master_name="
				+ club_master_name + "]";
	}
	
}
