package com.footmorning.app.domain;

import java.util.List;

public class LocationDTO {
	private Integer top;
	private Integer left;
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Integer getLeft() {
		return left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	@Override
	public String toString() {
		return "LocationDTO [top=" + top + ", left=" + left + "]";
	}
	
}
