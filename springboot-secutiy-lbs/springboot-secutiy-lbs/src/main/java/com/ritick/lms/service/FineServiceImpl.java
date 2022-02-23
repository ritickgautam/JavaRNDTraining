package com.ritick.lms.service;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritick.lms.dao.FineDAO;
import com.ritick.lms.dao.FineDAOImpl;

@Service
public class FineServiceImpl implements FineService {

	@Autowired
	FineDAO fineDao = new FineDAOImpl();

	@Override
	@Transactional
	public float getFineAmount(Date paymentDate, Date expiryDate) {
		return fineDao.getFineAmount(paymentDate, expiryDate);
	}

}
