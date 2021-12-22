package com.first;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class mainClass {
	
	public static void main(String args[]) throws SQLException
	{
		
		DBUtility db = new DBUtility();
		PreparedStatement pst;
		ResultSet rs;
		ResultSetMetaData rsmd;
		//CREATING TABLES
		String member = "Create Table Member("
				+ "Member_Id Int(5) NOT NULL UNIQUE AUTO_INCREMENT, "
				+ "Member_Name VARCHAR(30), "
				+ "Member_address VARCHAR(50), "
				+ "Acc_Open_Date DATE, "
				+ "Membership_type VARCHAR(20), "
				+ "Fees_paid INT(4), "
				+ "Max_Books_Allowed INT(2), "
				+ "Penalty_Amount DECIMAL(7,2)) ";
		pst = db.createPST(member);
		int status = db.execute(pst);
		if(status==0) {
			System.out.println("Created new Table Member");
		}
		else
			System.out.println("Error in creating new Table Member");

		String books = "Create Table Books("
				+ "Book_No Int(6) NOT NULL UNIQUE AUTO_INCREMENT, "
				+ "Book_Name VARCHAR(30), "
				+ "Author_name VARCHAR(30), "
				+ "Cost DECIMAL(7,2), "
				+ "Category VARCHAR(10)) ";
		pst = db.createPST(books);
		status = db.execute(pst);
		if(status==0) {
			System.out.println("Created new Table Books");
		}
		else
			System.out.println("Error in creating new Table Books");
		
		String issue = "Create Table Issue("
				+ "Lib_Issue_Id Int(10) NOT NULL UNIQUE AUTO_INCREMENT, "
				+ "Book_No int(6), "
				+ "Member_Id int(5), "
				+ "Issue_Date Date, "
				+ "Return_date DATE) ";
		pst = db.createPST(issue);
		status = db.execute(pst);
		if(status==0) {
			System.out.println("Created new Table Issue");
		}
		else
			System.out.println("Error in creating new Table Issue");
		
		//VIEW THE STRUCTURE OF TABLES
		 pst = db.createPST("select * from Member");
		 rs = db.query(pst);
		 rsmd = (ResultSetMetaData) rs.getMetaData();
		 System.out.println("No. of columns in Member table: " + rsmd.getColumnCount());
		 
		 for(int i=0;i<rsmd.getColumnCount();i++)
		 {
			 System.out.println(rsmd.getColumnName(i+1) + " " + rsmd.getColumnTypeName(i+1));
		 }
		 System.out.println("---------------------------------------------");
		 pst = db.createPST("select * from Books");
		 rs = db.query(pst);
		 rsmd = (ResultSetMetaData) rs.getMetaData();
		 System.out.println("No. of columns in Books table: " + rsmd.getColumnCount());
		 
		 for(int i=0;i<rsmd.getColumnCount();i++)
		 {
			 System.out.println(rsmd.getColumnName(i+1) + " " + rsmd.getColumnTypeName(i+1));
		 }
		 System.out.println("---------------------------------------------");
		 pst = db.createPST("select * from Issue");
		 rs = db.query(pst);
		 rsmd = (ResultSetMetaData) rs.getMetaData();
		 System.out.println("No. of columns in Issue table: " + rsmd.getColumnCount());
		 
		 for(int i=0;i<rsmd.getColumnCount();i++)
		 {
			 System.out.println(rsmd.getColumnName(i+1) + " " + rsmd.getColumnTypeName(i+1));
		 }
		 System.out.println("---------------------------------------------");
		 
		 //DROP MEMBER TABLE
		 String drop = String.format("DROP TABLE IF EXISTS %s", "member");
		 pst = db.createPST(drop);
		 db.execute(pst);
		 System.out.println("Member Table Deleted Successfully");
		 System.out.println("---------------------------------------------");
		 
		//CREATING MEMBER TABLE AGAIN WITH CONSTRAIN
		String member1 = "Create Table Member("
				+ "Member_Id Int(5) NOT NULL Primary Key AUTO_INCREMENT, "
				+ "Member_Name VARCHAR(30), "
				+ "Member_address VARCHAR(50), "
				+ "Acc_Open_Date DATE, "
				+ "Membership_type ENUM('Lifetime', 'Annual', 'Quarterly', 'Halfyearly') , "
				+ "Fees_paid INT(4), "
				+ "Max_Books_Allowed INT(2), "
				+ "Penalty_Amount DECIMAL(7,2)) ";
		pst = db.createPST(member1);
		status = db.execute(pst);
		if(status==0) {
			System.out.println("Created new Table Member");
		}
		else
			System.out.println("Error in creating new Table Member");
		System.out.println("---------------------------------------------");
		 
		//UPDATE THE LENGTH OF COLUMN MEMBER_NAME
		String q1 = "ALTER TABLE member "
				+ "CHANGE COLUMN Member_Name Member_Name VARCHAR(40) ";
		pst= db.createPST(q1);
		db.execute(pst);
		System.out.println("Updated the table member column member_name to length 40" );
		System.out.println("---------------------------------------------");
		 
		//ADDING NEW COLUMN IN ISSUE Reference
		String q2 = "ALTER TABLE Issue "
				+ "Add COLUMN Reference char(30) ";
		pst= db.createPST(q2);
		db.execute(pst);
		System.out.println("Added new column to Issue");
		System.out.println("---------------------------------------------");
		 
		//DELETE COLUMN REFERNCE from ISSUE
		String q3 = "ALTER TABLE Issue "
				+ "DROP COLUMN Reference";
		pst= db.createPST(q3);
		db.execute(pst);
		System.out.println("Removed column reference from Issue");
		System.out.println("---------------------------------------------");
		 
		//Renaming table ISsue to Lib_Issue
		String q4 = "ALTER TABLE Issue "
				+ "Rename TO Lib_Issue";
		pst= db.createPST(q4);
		db.execute(pst);
		System.out.println("Renamed the table issue to Lib_Issue ");
		System.out.println("---------------------------------------------");
		 
		//Inserted value in Member
		String q5 = "insert into member values(1,'Richa Sharma','Pune','2005-12-10','lifetime', 25000, 5 , 50)";
		pst= db.createPST(q5);
		if(db.execute(pst)>0) {
			System.out.println("Inserted the data in table member ");
		}
		else
			System.out.println("Error in inserting");
		System.out.println("---------------------------------------------");
		 
		//Inserted value in Member
		String q6 = "insert into member values(2,'Garima Sen','Pune',?,'Annual', 1000, 3 , null)";
		pst= db.createPST(q6);
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		pst.setTimestamp(1, date);
		if(db.execute(pst)>0) {
			System.out.println("Inserted the data in table member ");
		}
		else
			System.out.println("Error in inserting");
		System.out.println("---------------------------------------------");
		 
		//Update length of column Member_name
		String q7 = "ALTER TABLE member "
				+ "CHANGE COLUMN Member_Name Member_Name VARCHAR(20) ";
		pst= db.createPST(q7);
		try {
			if(db.execute(pst)>0) {
				System.out.println("Updated the table member column member_name to length 20" );
			}
		} catch (Exception e) {
			System.out.println("Error in update as data get Truncated for value more than 10");

		}
		System.out.println("---------------------------------------------");
		 
		//Enter size greater than defined
		String q8 = " insert into member values(3,'Sushmita Sen','Pune',?,'Halfyearly', 1000, 110 , null)";
		pst= db.createPST(q8);
		try {
			if(db.execute(pst)>0) {
				System.out.println("Added the record of data having issue max book greater than 110" );
			}
		} catch (Exception e) {
			System.out.println("Error in update as data entered is more than the size allocated to that field");

		}
		System.out.println("---------------------------------------------");
		 
		//GENERATE NEW TABLE MEMBER101 from existing TABLE MEMBER
		String q9 = "Create table Member101 AS select * from Member";
		pst= db.createPST(q9);
		if(db.execute(pst)>0) {
			System.out.println("Created new Table Member101 as Member");
		}
		else
			System.out.println("Error in creating Member101");
		System.out.println("---------------------------------------------");
		System.out.println("Done All");
		
		
		
		
	}
}
