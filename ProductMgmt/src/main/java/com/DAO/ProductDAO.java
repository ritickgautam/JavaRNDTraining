package com.DAO;

import java.sql.SQLException;
import java.util.List;

import com.Model.product;

public interface ProductDAO {
	public int save(product p) throws SQLException;
	public int updateProduct(product p) throws SQLException;
	public int deleteProduct(int pid) throws SQLException;
	public product findproductBypid(int pid) throws SQLException;
	public List<product> findproductByuserid(int userid) throws SQLException;

}
