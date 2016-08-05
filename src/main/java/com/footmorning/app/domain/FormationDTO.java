package com.footmorning.app.domain;

import java.util.List;

public class FormationDTO {
	private String formation_list;
	private String lineup_no;

	public String getFormation_list() {
		return formation_list;
	}

	public void setFormation_list(String formation_list) {
		this.formation_list = formation_list;
	}
	
	public String getLineup_no() {
		return lineup_no;
	}

	public void setLineup_no(String lineup_no) {
		this.lineup_no = lineup_no;
	}

	@Override
	public String toString() {
		return "FormationDTO [formation_list=" + formation_list + ", lineup_no=" + lineup_no + "]";
	}

}
