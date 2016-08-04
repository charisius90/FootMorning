package com.footmorning.app.domain;

import java.util.List;

public class LocationDTO {
	private String top;
	private String left;
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	@Override
	public String toString() {
		return "LocationDTO [top=" + top + ", left=" + left + "]";
	}
	
}
