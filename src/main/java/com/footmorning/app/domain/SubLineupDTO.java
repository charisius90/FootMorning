package com.footmorning.app.domain;

import java.util.List;

public class SubLineupDTO {
	private String sublineup_list;
	private String lineup_no;
	private int game_no;
	private String game_flag;
	
	public String getSublineup_list() {
		return sublineup_list;
	}
	public void setSublineup_list(String sublineup_list) {
		this.sublineup_list = sublineup_list;
	}
	public String getLineup_no() {
		return lineup_no;
	}
	public void setLineup_no(String lineup_no) {
		this.lineup_no = lineup_no;
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
	@Override
	public String toString() {
		return "SubLineupDTO [sublineup_list=" + sublineup_list + ", lineup_no=" + lineup_no + ", game_no=" + game_no
				+ ", game_flag=" + game_flag + "]";
	}
	
	
}
