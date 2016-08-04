package com.footmorning.app.domain;

import java.util.List;

public class SubLineupDTO2 {
	private String backnumber;
	private String name;
	public String getBacknumber() {
		return backnumber;
	}
	public void setBacknumber(String backnumber) {
		this.backnumber = backnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SubLineupDTO [backnumber=" + backnumber + ", name=" + name + "]";
	}
}
