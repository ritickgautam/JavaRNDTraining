package com.ems.dao;

import java.util.List;

import com.ems.model.Enquiry;

public interface EnquiryDAO {
	public void registerQuery(Enquiry query);

	public void updateQuery(int id);

	public void deleteQuery(int id);

	public Enquiry getQueryById(int id);

	public List<Enquiry> getQueriesByUserId(int userId);

	public List<Enquiry> getQueries();
}
