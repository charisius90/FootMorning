package com.footmorning.app.domain;

public class MyclubCashBookDTO {
	private String cashbook_no;
	private String cashbook_index;
	private String cashbook_date;
	private String cashbook_type;
	private String cashbook_content;
	private String cashbook_amount;
	private String cashbook_balance;
	private String club_no;
	
	public String getCashbook_no() {
		return cashbook_no;
	}
	public void setCashbook_no(String cashbook_no) {
		this.cashbook_no = cashbook_no;
	}
	public String getCashbook_index() {
		return cashbook_index;
	}
	public void setCashbook_index(String cashbook_index) {
		this.cashbook_index = cashbook_index;
	}
	public String getCashbook_date() {
		return cashbook_date;
	}
	public void setCashbook_date(String cashbook_date) {
		this.cashbook_date = cashbook_date;
	}
	public String getCashbook_type() {
		return cashbook_type;
	}
	public void setCashbook_type(String cashbook_type) {
		this.cashbook_type = cashbook_type;
	}
	public String getCashbook_amount() {
		return cashbook_amount;
	}
	public void setCashbook_amount(String cashbook_amount) {
		this.cashbook_amount = cashbook_amount;
	}
	public String getCashbook_balance() {
		return cashbook_balance;
	}
	public void setCashbook_balance(String cashbook_balance) {
		this.cashbook_balance = cashbook_balance;
	}
	public String getClub_no() {
		return club_no;
	}
	public void setClub_no(String club_no) {
		this.club_no = club_no;
	}
	public String getCashbook_content() {
		return cashbook_content;
	}
	public void setCashbook_content(String cashbook_content) {
		this.cashbook_content = cashbook_content;
	}
	
	@Override
	public String toString() {
		return "MyclubCashBookDTO [cashbook_no=" + cashbook_no + ", cashbook_index=" + cashbook_index
				+ ", cashbook_date=" + cashbook_date + ", cashbook_type=" + cashbook_type + ", cashbook_content=" + cashbook_content + ", cashbook_amount="
				+ cashbook_amount + ", cashbook_balance=" + cashbook_balance + ", club_no=" + club_no + "]";
	}
	
}
