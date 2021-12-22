package com.first;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class mainClass {
	public static void main(String args[]) throws SQLException {

		DBUtility db = new DBUtility();
		PreparedStatement pst;
		ResultSet rs;
		int status;
		
		//List all the books that are written by Author Loni and has price  less then 600.
		String q1 = "Select book_name from books where Author_name = 'Loni' And Cost < 600";
		pst =  db.createPST(q1);
		rs= db.query(pst);
		System.out.println("Name of Book written by Lone and cost less than 600 are: ");
		
			while(rs.next())
			{
			System.out.println(rs.getString("book_name"));
			}
			System.out.println("=======================================");
		//List the Issue details for the books that are not returned yet.
		String q2 = "Select * from lib_issue where return_date is null";
		pst = db.createPST(q2);
		rs = db.query(pst);
		while(rs.next()) {
			System.out.println("Lib_Issue_Id " + rs.getInt("Lib_Issue_Id") + "Book_no " + rs.getInt("Book_No") +
					"Member_Id " + rs.getInt("Member_Id") + "Issue_Date " + rs.getDate("Issue_Date") + "Return_date " + rs.getDate("Return_date"));
	
		}
		System.out.println("=======================================");
		//Update all the blank return_date with 31-Dec-06 excluding 7005 and 7006.
		String q3 = "Update Lib_issue Set return_date = '2006-12-31' where Lib_issue_id NOT IN (7005,7006)";
		pst = db.createPST(q3);
		status = db.execute(pst);
		if(status>0) {
			System.out.println("Updated successfully");
		}
		else
			System.out.println("nothing to update");

		System.out.println("=======================================");
		//  List all the Issue details that have books issued for more then 30 days.
		String q4 = "Select * from Lib_issue where return_date-issue_date >30 OR issue_date-return_date >30";
		pst = db.createPST(q4);
		rs = db.query(pst);
		while(rs.next()) {
			System.out.println("Lib_Issue_Id " + rs.getInt("Lib_Issue_Id") + "Book_no " + rs.getInt("Book_No") +
					"Member_Id " + rs.getInt("Member_Id") + "Issue_Date " + rs.getDate("Issue_Date") + "Return_date " + rs.getDate("Return_date"));
	
		}
		System.out.println("=======================================");
		
		// List all the books that have price in range of 500 to 750 and has category as Database.
		String q5 = "Select book_name from books where cost BETWEEN 500 and 750";
		pst =  db.createPST(q5);
		rs= db.query(pst);
		System.out.println("Name of Book Price in between 500 and 750 ");
		
			while(rs.next())
			{
			System.out.println(rs.getString("book_name"));
			}
			System.out.println("=======================================");
		
		//  List all the books that belong to any one of the following categories Science, Database, Fiction, Management
		String q6 = "Select book_name from books where Category In('Science', 'Database', 'Fiction', 'Management' )";
		pst =  db.createPST(q6);
		rs= db.query(pst);
		System.out.println("Name of Book having categories Science, Database, Fiction, Management ");
		
			while(rs.next())
			{
			System.out.println(rs.getString("book_name"));
			}
			System.out.println("=======================================");
		
		// List all the members in the descending order of Penalty due on them
		String q7 = "Select member_id, member_name from member order by Penalty_Amount DESC ";
		pst =  db.createPST(q7);
		rs= db.query(pst);
		System.out.println("Member details in Descending order by Penalty Due");
		while(rs.next())
		{
		System.out.println("Member_Id " + rs.getInt("Member_Id") + " Member_Name " + rs.getString("Member_Name") );
		}
		System.out.println("=======================================");
		
		// List all the books in ascending order of category and descending order of price.
		String q8 = "Select book_name, category, cost from books Order By Category Asc, Cost desc";
		pst =  db.createPST(q8);
		rs= db.query(pst);
		System.out.println("Book details in Ascending order by Category and descending order by Cost");
		while(rs.next())
		{
		System.out.println("book_name " + rs.getString("book_name") + " category " + rs.getString("category") + " cost " 
		+ rs.getDouble("cost") );
		}
		System.out.println("=======================================");
		
		//List all the books that contain word SQL in the name of the book.
		String q9= "Select book_name from books where book_name LIKE '%SQL%'";
		pst =  db.createPST(q9);
		rs= db.query(pst);
		System.out.println("Name of Book that containg SQL");
		
			while(rs.next())
			{
			System.out.println(rs.getString("book_name"));
			}
			System.out.println("=======================================");
		
		// List all the members whose name starts with R or G and contains letter I in it.
		String q10 = "select * from Member where member_name LIKE '%I%' and (member_name LIKE 'R%' or member_name LIKE 'G%')" ;
		pst =  db.createPST(q10);
		rs= db.query(pst);
		System.out.println("Member details start with R or G and have I");
		while(rs.next())
		{
		System.out.println("Member_Id " + rs.getInt("Member_Id") + " Member_Name " + rs.getString("Member_Name") );
		}
		System.out.println("=======================================");
		
		//List the entire book name in Init cap and author in upper case in the descending order of the book name.
		String q11 = "Select book_name, Upper(Author_name) AS Author_name  from Books Order By Book_name Desc";
		pst =  db.createPST(q11);
		rs= db.query(pst);
		while(rs.next())
		{
			String book_name= rs.getString("book_name");
			System.out.print("Book Name: " + book_name.substring(0,1).toUpperCase().concat(book_name.substring(1,book_name.length()).toLowerCase()));
			System.out.print(" Author_name " + rs.getString("Author_name"));
			System.out.println();
		}
		System.out.println("=======================================");
		
		//List the Issue Details for all the books issue by member 101  with Issue_date and Return Date in following format. ‘Monday, July, 10, 2006’.
		String q12 = "Select Lib_issue_id,Book_No,Member_Id,  DATE_FORMAT(issue_date , '%W %M %Y') as Issue_date, DATE_FORMAT(return_date , '%W %M %Y') as Return_date from Lib_issue";
		pst =  db.createPST(q12);
		rs= db.query(pst);
		while(rs.next())
		{
			System.out.println("Lib_Issue_Id " + rs.getInt("Lib_Issue_Id") + "Book_no " + rs.getInt("Book_No") +
					"Member_Id " + rs.getInt("Member_Id") + "Issue_Date " + rs.getString("Issue_Date") + "Return_date " + rs.getString("Return_date"));
			}

		System.out.println("=======================================");
		
		//List the data in the book table with category data displayed as D for Database, S for Science, R for RDBMS and O for all the  others.
		String q13 = "SELECT book_name , CASE category WHEN 'Database' THEN 'D'  WHEN 'Science' THEN 'S' WHEN 'RDBMS' THEN 'R' ELSE 'O' END as Category  FROM books";
		pst =  db.createPST(q13);
		rs= db.query(pst);
		while(rs.next())
		{
			System.out.println("Book Name :" + rs.getString("book_name") + " category type: " + rs.getString("Category"));
		}
		
		System.out.println("=======================================");
		
		//List all the members that became the member in the year 2006.
		String q14 = "Select * from member where Acc_Open_Date Like '2006%'";
		pst =  db.createPST(q14);
		rs= db.query(pst);
		while(rs.next())
		{
		System.out.println("Member_Id " + rs.getInt("Member_Id") + " Member_Name " + rs.getString("Member_Name") + " Acc_Open_Date " + rs.getDate("Acc_Open_Date"));
		}
		System.out.println("=======================================");
		
		//List the Lib_Issue_Id, Issue_Date, Return_Date and No of days Book was issued.
		String q15 = "Select Lib_issue_id, Issue_date, Return_date , return_date - issue_date as No_of_days_bookIssued from lib_issue";
		pst =  db.createPST(q15);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println(" Lib_issue_id " + rs.getInt("Lib_issue_id") + " Issue_date " + rs.getDate("Issue_date") + " Return_date " + rs.getDate("Return_date")
					+ " No_of_days_bookIssued " + rs.getInt("No_of_days_bookIssued"));
		}
		System.out.println("=======================================");
		
		//Find the details of the member of the Library in the order of their joining the library
		String q16 = "Select * from member Order By Acc_Open_Date";
		pst =  db.createPST(q16);
		rs= db.query(pst);
		while(rs.next())
		{
		System.out.println("Member_Id " + rs.getInt("Member_Id") + " Member_Name " + rs.getString("Member_Name") + " Acc_Open_Date " + rs.getDate("Acc_Open_Date"));
		}
		System.out.println("=======================================");
		
		//Display the count of total no of books issued to Member 101.
		String q17 = "Select Count(Book_no) as Number_of_books from Lib_issue where member_id =101";
		pst =  db.createPST(q17);
		rs= db.query(pst);
		while(rs.next())
		{
			System.out.println(" Number_of_books issue by member 101 is: " + rs.getInt("Number_of_books"));
		}
		System.out.println("=======================================");
		
		//Display the total penalty due for all the members.
		String q18= "Select sum(Penalty_Amount) as penalty_due from member";
		pst =  db.createPST(q18);
		rs= db.query(pst);
		while(rs.next())
		{
			System.out.println(" Penalty due for all the member is: " + rs.getDouble("penalty_due"));
		}
		System.out.println("=======================================");
		
		//  Display the total no of members 
		String q19 = "Select Count(member_id) as num_of_member from member";
		pst =  db.createPST(q19);
		rs= db.query(pst);
		while(rs.next())
		{
			System.out.println(" Total number of member is: " + rs.getInt("num_of_member"));
		}
		System.out.println("=======================================");
		
		//Display the total no of books issued
		String q20 = "Select count(Lib_Issue_Id) as Num_of_books from Lib_issue";
		pst =  db.createPST(q20);
		rs= db.query(pst);
		while(rs.next())
		{
			System.out.println(" Total number of book issue is: " + rs.getInt("Num_of_books"));
		}
		System.out.println("=======================================");
		
		// Display the average membership fees paid by all the members
		String q21 = "Select avg(Fees_paid) from member";
		pst =  db.createPST(q21);
		rs= db.query(pst);
		while(rs.next())
		{
			System.out.println(" Average fees paid by members is: " + rs.getDouble("avg(Fees_paid)"));
		}
		System.out.println("=======================================");
		
		//Display no of months between issue date and return date for all issue
		String q22 = "SELECT Lib_Issue_Id, abs(timestampdiff(MONTH,Return_date,Issue_Date)) as DateDiff from lib_issue";
		pst =  db.createPST(q22);
		rs= db.query(pst);
		while(rs.next())
		{
			System.out.println("Lib_Issue_Id: " + rs.getInt("Lib_Issue_Id") + " Difference in month is: " + rs.getInt("DateDiff"));
		}
		System.out.println("=======================================");
		
		//Display the length of member’s name
		String q23 ="Select LENGTH(member_name) as Length_of_names from member";
		pst =  db.createPST(q23);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Length_of_names: " + rs.getInt("Length_of_names"));
		}
		System.out.println("=======================================");
		
		// Display the first 5 characters of  membership_type for all members
		String q24 ="Select member_name , left(Membership_type , 5) as first5 from member";
		pst =  db.createPST(q24);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println( "member_name: " + rs.getString("member_name") + " first5 of membership type : " + rs.getString("first5"));
		}
		System.out.println("=======================================");
		
		// Display the last day of the issue date 
		String q25 = "Select member_id, last_day(issue_date) as last_date from lib_issue";
		pst =  db.createPST(q25);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Last day of issue date is " + rs.getDate("last_date") + " of member : " + rs.getString("member_id"));
		}
		System.out.println("=======================================");
		
		//Using the regular expression function select name of book  beginning with L
		String q26 = "select book_name from books where book_name regexp '^L'";
		pst =  db.createPST(q26);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Name of Book : " + rs.getString("book_name"));
		}
		System.out.println("=======================================");
		
		//Using regular expression replace using the string 'We are driving south by south east', replace south by North in the above string 
		String q27 = "select regexp_replace('We are driving south by south east','south', 'north') as UpdatedString";
		pst =  db.createPST(q27);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Updated String : " + rs.getString("UpdatedString"));
		}
		System.out.println("=======================================");
		
		//Display the member_name starting with R using regular expression 
		String q28 = "Select member_name from member where member_name regexp '^R'";
		pst =  db.createPST(q28);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Member name Starting with R : " + rs.getString("member_name"));
		}
		System.out.println("=======================================");
		
		//Display the Book_name containing word SQL using regular expression 
		String q29 ="select book_name from books where book_name regexp 'sql'";
		pst =  db.createPST(q29);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Book name containing SQL: " + rs.getString("book_name"));
		}
		System.out.println("=======================================");
		
		//Display the Author_name starting with "L" from first position using   regular expression
		String q30 = "Select Author_name from Books where Author_name regexp '^L'";
		pst =  db.createPST(q30);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Author name Starting with L: " + rs.getString("Author_name"));
		}
		System.out.println("=======================================");
		
		//Display the member_name containing "Ga" from first to second position using regular expression
		String q31 ="select member_name from member where member_name regexp '^ga'";
		pst =  db.createPST(q31);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Member name Starting with Ga: " + rs.getString("member_name"));
		}
		System.out.println("=======================================");
		
		//Replace the book_name "Mastering SQL" with "Advanced SQL" using regular expression
		String q32="select regexp_replace(book_name,'Mastering SQL', 'Advanced SQL') as UpdatedBookName from books";
		pst =  db.createPST(q32);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Replace the book_name \"Mastering SQL\" with \"Advanced SQL\": " + rs.getString("UpdatedBookName"));
		}
		System.out.println("=======================================");
		
		//Replace the author_name "Scott Urman" with "Scott K Urman" using regular expression 
		String q33 = "select regexp_replace(author_name,'Scott Urman', 'Scott K Urman') as Updated from Books";
		pst =  db.createPST(q33);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Replace the Author name \"Scott Urman\" with \"Scott K Urman\": " + rs.getString("Updated"));
		}
		System.out.println("=======================================");
		
		//Display the value of book_name from position 1 to 5 containing "G" using the using regular expression 
		String q34 = "Select book_name from books where book_name regexp '^G....|^.G...|^..G..|^...G.|^....G'";
		pst =  db.createPST(q34);
		rs= db.query(pst);
		while(rs.next()) {
			System.out.println("Get all the books having G in first 5 characters: " + rs.getString("book_name"));
		}
		System.out.println("=======================================");
		
		
		
		
		
		
		
		


		
	}

}
