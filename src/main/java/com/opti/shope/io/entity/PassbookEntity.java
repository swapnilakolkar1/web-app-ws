package com.opti.shope.io.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "account_statement")
public class PassbookEntity implements Serializable{
	private static final long serialVersionUID = 5446475659780626892L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(value = TemporalType.DATE )
	@Column(name = "date" ,nullable=false)
	private Date date;
	
	@Column(name = "code", nullable=false, length=2)
	private String code; // "CR/WD"
	
	@Column(name = "description", nullable=false, length=10)
	private String description;// ":"save/intrest/",
	
	@Column(name = "chequeNumber", length=15)
	private String chequeNumber;// ":"",
	
	@Column(name="amount", nullable=false, precision=12, scale=2)
	private Double amount;// "amount":"",
	
	@Column(name="closingBal", nullable=false, precision=12, scale=2)
	private Double closingBal;
	
	@ManyToOne	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

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

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
}
