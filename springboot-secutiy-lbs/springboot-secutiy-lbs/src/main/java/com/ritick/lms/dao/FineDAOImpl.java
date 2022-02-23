package com.ritick.lms.dao;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class FineDAOImpl implements FineDAO{

	@Override
	public float getFineAmount(Date paymentDate, Date expiryDate) {
		float fineamount = 0;
		long days;
		days = paymentDate.getTime() - expiryDate.getTime();
		float daysBetween = (days / (1000*60*60*24));
		if(daysBetween>=5){
			fineamount = daysBetween * 50;
			return fineamount;
		}
		if(daysBetween<=4){
			fineamount = daysBetween * 30;
			return fineamount;
		}
		return fineamount;
	}

}
