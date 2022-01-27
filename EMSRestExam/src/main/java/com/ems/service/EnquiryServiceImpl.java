package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.EnquiryDAO;
import com.ems.model.Enquiry;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryDAO dao;


	@Override
	public List<Enquiry> getQueries() {
		// TODO Auto-generated method stub
		return dao.getQueries();
	}

	@Override
	public Enquiry getQueryById(int id) {
		// TODO Auto-generated method stub
		return dao.getQueryById(id);
	}

	@Override
	public List<Enquiry> getQueriesByUserId(int userId) {
		// TODO Auto-generated method stub
		return dao.getQueriesByUserId(userId);
	}

	@Override
	public void registerQuery(Enquiry query) {
		dao.registerQuery(query);

	}

	@Override
	public void updateQuery(int id) {
		dao.updateQuery(id);
	}

	@Override
	public void deleteQuery(int id) {
		dao.deleteQuery(id);

	}




}
