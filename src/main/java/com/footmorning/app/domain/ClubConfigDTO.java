package com.footmorning.app.domain;

/**
 * 클럽 가입조건 DTO
 * @author 박수항
 *
 */
public class ClubConfigDTO {
	private String config_no;
	private String config_reject_from;
	private String config_reject_to;
	private String config_gender;
	private String config_birth_from;
	private String config_birth_to;
	private String club_no;
	
	public String getConfig_no() {
		return config_no;
	}
	public void setConfig_no(String config_no) {
		this.config_no = config_no;
	}
	public String getConfig_reject_from() {
		return config_reject_from;
	}
	public void setConfig_reject_from(String config_reject_from) {
		this.config_reject_from = config_reject_from;
	}
	public String getConfig_reject_to() {
		return config_reject_to;
	}
	public void setConfig_reject_to(String config_reject_to) {
		this.config_reject_to = config_reject_to;
	}
	public String getConfig_gender() {
		return config_gender;
	}
	public void setConfig_gender(String config_gender) {
		this.config_gender = config_gender;
	}
	public String getConfig_birth_from() {
		return config_birth_from;
	}
	public void setConfig_birth_from(String config_birth_from) {
		this.config_birth_from = config_birth_from;
	}
	public String getConfig_birth_to() {
		return config_birth_to;
	}
	public void setConfig_birth_to(String config_birth_to) {
		this.config_birth_to = config_birth_to;
	}
	public String getClub_no() {
		return club_no;
	}
	public void setClub_no(String club_no) {
		this.club_no = club_no;
	}
	
	@Override
	public String toString() {
		return "ClubConfigDTO [config_no=" + config_no + ", config_reject_from=" + config_reject_from
				+ ", config_reject_to=" + config_reject_to + ", config_gender=" + config_gender + ", config_birth_from="
				+ config_birth_from + ", config_birth_to=" + config_birth_to + ", club_no=" + club_no + "]";
	}
	
}
