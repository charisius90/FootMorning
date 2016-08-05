package com.footmorning.app.domain;

import java.util.List;

public class FormationListDTO {
	private String backnumber;
	private String name;
	private LocationDTO location;
	
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
	public LocationDTO getLocation() {
		return location;
	}
	public void setLocation(LocationDTO location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "FormationDTO [backnumber=" + backnumber + ", name=" + name + ", location=" + location + "]";
	}
	
}
