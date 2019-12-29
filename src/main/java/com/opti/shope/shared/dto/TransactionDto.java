package com.opti.shope.shared.dto;

import java.io.Serializable;
import java.util.Date;


public class TransactionDto  implements Serializable{
	private static final long serialVersionUID = -7908189335278791040L;

	private long id;
	
	private Date date;
	
	private String code; // "CR/WD"
	
	private String description;// ":"save/intrest/",
	
	private String chequeNumber;// ":"",
	
	private Double amount;// "amount":"",
	
	private Double closingBal;

	private UserDto userDto;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getClosingBal() {
		return closingBal;
	}

	public void setClosingBal(Double closingBal) {
		this.closingBal = closingBal;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	

}
