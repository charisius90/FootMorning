package com.footmorning.app.util;

public class SearchCriteria extends Criteria {

	private String searchType;
	private String keyword;
	private String club_no;
	private String selectType;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getClub_no() {
		return club_no;
	}

	public void setClub_no(String club_no) {
		this.club_no = club_no;
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + ", club_no=" + club_no
				+ ", selectType=" + selectType + "]";
	}

}
