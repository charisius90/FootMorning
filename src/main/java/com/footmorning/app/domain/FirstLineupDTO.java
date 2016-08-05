package com.footmorning.app.domain;

import java.util.List;

public class FirstLineupDTO {
	private String firstlineup_list;
	private int game_no;
	private String game_flag;
	
	public String getFirstlineup_list() {
		return firstlineup_list;
	}
	public void setFirstlineup_list(String firstlineup_list) {
		this.firstlineup_list = firstlineup_list;
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
		return "FirstLineupListDTO [firstlineup_list=" + firstlineup_list + ", game_no=" + game_no + ", game_flag="
				+ game_flag + "]";
	}
	
}
