package com.ritick.lms.service;

import java.sql.Date;

public interface FineService {

	public float getFineAmount(Date paymentDate, Date expiryDate) ;

}
