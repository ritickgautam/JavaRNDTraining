package com.ritick.lms.dao;

import java.sql.Date;

public interface FineDAO {

	public float getFineAmount(Date paymentDate, Date expiryDate) ;

}
