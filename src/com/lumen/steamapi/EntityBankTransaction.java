package com.lumen.steamapi;


import java.time.LocalDate;

public class EntityBankTransaction {
//	Input: A List<Transaction> (id, customerName, amount, type[DEBIT/CREDIT], date).
	
	int id;
	String customerName;
	double ammout;
	@SuppressWarnings("rawtypes")
	Enum CardType;
	LocalDate date;
	public EntityBankTransaction(int id, String customerName, double ammout, Enum cardType, LocalDate date) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.ammout = ammout;
		CardType = cardType;
		this.date = date;
	}
	public EntityBankTransaction() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getAmmout() {
		return ammout;
	}
	public void setAmmout(double ammout) {
		this.ammout = ammout;
	}
	public Enum getCardType() {
		return CardType;
	}
	public void setCardType(Enum cardType) {
		CardType = cardType;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "EntityBankTransaction [id=" + id + ", customerName=" + customerName + ", ammout=" + ammout
				+ ", CardType=" + CardType + ", date=" + date + "]";
	}
}
