package com.ritick.lms.model;

import java.sql.Date;


public class Fine {

	private Date paymentDate;
	private int amount;

	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Fine() {
		super();
	}
	public Fine(Date paymentDate, int amount) {
		super();
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Fine [paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}


}
