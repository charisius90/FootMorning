package com.footmorning.app.util;

public class SearchClubCriteria extends ClubCriteria {

	private String searchType;
	private String keyword;
	private String club_no;

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

	@Override
	public String toString() {
		return "SearchClubCriteria [searchType=" + searchType + ", keyword=" + keyword + ", club_no=" + club_no + "]";
	}

}
