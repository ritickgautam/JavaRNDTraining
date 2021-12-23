package com.Test;

import com.Utility.DBUtility;

public class TestConn {
	public static void main(String[] args) {
		DBUtility db = new DBUtility();
		System.out.println(db.testConn());
	}

}
