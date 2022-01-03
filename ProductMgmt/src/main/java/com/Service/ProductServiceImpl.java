package com.Service;

import java.sql.SQLException;
import java.util.List;

import com.DAO.ProductDAO;
import com.DAO.ProductDAOImpl;
import com.Model.product;

public class ProductServiceImpl implements ProductService {

	ProductDAO dao = new ProductDAOImpl();
	@Override
	public int save(product p) throws SQLException {
		
		return dao.save(p);
	}

	@Override
	public int updateProduct(product p) throws SQLException {
		return dao.updateProduct(p);
	}

	@Override
	public int deleteProduct(int pid) throws SQLException {
		
		return dao.deleteProduct(pid);
	}

	@Override
	public product findproductBypid(int pid) throws SQLException {
		
		return dao.findproductBypid(pid);
	}

	@Override
	public List<product> findproductByuserid(int userid) throws SQLException {
		
		return dao.findproductByuserid(userid);
	}

}
