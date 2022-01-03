package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.product;
import com.Utility.DBUtility;


public class ProductDAOImpl implements ProductDAO {

	DBUtility db = new DBUtility();
	PreparedStatement pst;
	ResultSet rs;

	@Override
	public int save(product p) throws SQLException {
		String sql ="insert into product(pname,price,vendor,quantity,warranty,userid) values(?,?,?,?,?,?)";
		pst = db.createPST(sql);
		pst.setString(1, p.getpName());
		pst.setDouble(2, p.getPrice());
		pst.setString(3, p.getVendor());
		pst.setInt(4, p.getQuantity());
		pst.setInt(5, p.getWarranty());
		pst.setInt(6, p.getUserid());
		
		return db.execute(pst);
	}

	@Override
	public int updateProduct(product p) throws SQLException {
		String sql = "Update product set pname=?,price=?,quantity=?,vendor=?,warranty=? where pid=?";
		pst = db.createPST(sql);
		pst.setString(1, p.getpName());
		pst.setDouble(2, p.getPrice());
		pst.setInt(3, p.getQuantity());
		pst.setString(4, p.getVendor());
		pst.setInt(5, p.getWarranty());
		pst.setInt(6, p.getPid());
		return db.execute(pst);
	}

	@Override
	public int deleteProduct(int pid) throws SQLException {
		String sql = "Delete from product where pid=?";
		pst = db.createPST(sql);
		pst.setInt(1,pid);
		return db.execute(pst);

	}

	@Override
	public product findproductBypid(int pid) throws SQLException {
		String sql = "Select * from product where pid=?";
		pst=db.createPST(sql);
		pst.setInt(1, pid);
		rs = db.query(pst);
		
		if(rs.next()) {
			product p = new product();
			p.setPid(rs.getInt("pid"));
			p.setpName(rs.getString("pName"));
			p.setPrice(rs.getDouble("price"));
			p.setQuantity(rs.getInt("quantity"));
			p.setUserid(rs.getInt("userId"));
			p.setVendor(rs.getString("vendor"));
			p.setWarranty(rs.getInt("warranty"));
			return p;
		}
		else
			return null;
	}

	@Override
	public List<product> findproductByuserid(int userid) throws SQLException {
		String sql = "Select * from product where userid=?";
		pst=db.createPST(sql);
		pst.setInt(1,userid);
		rs = db.query(pst);
		
		List<product> products = new ArrayList<>();
		while(rs.next()) {
			product p = new product();
			p.setPid(rs.getInt("pid"));
			p.setpName(rs.getString("pname"));
			p.setPrice(rs.getDouble("price"));
			p.setQuantity(rs.getInt("quantity"));
			p.setVendor(rs.getString("vendor"));
			p.setWarranty(rs.getInt("warranty"));
			p.setUserid(rs.getInt("userid"));
			
			products.add(p);
		}
		
		return products;
	}

}
