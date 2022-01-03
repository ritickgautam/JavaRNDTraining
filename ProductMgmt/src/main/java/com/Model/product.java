package com.Model;

public class product {
	private int pid;
	private String pName;
	private double price;
	private int quantity;
	private String vendor;
	private int warranty;
	private int userid;
	
	
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "products [pid=" + pid + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity + ", vendor="
				+ vendor + ", warranty=" + warranty + ", userid=" + userid + "]";
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	

}
