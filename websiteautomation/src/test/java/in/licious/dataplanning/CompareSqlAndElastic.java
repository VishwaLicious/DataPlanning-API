package in.licious.dataplanning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import in.licious.util.ReadData;

public class CompareSqlAndElastic {

	public static String sqlandelastic() throws SQLException {
		
		String date=null;
		
		String excelfilepath1="C:\\Users\\vishwa\\git\\Data_Planning_API_Automation\\websiteautomation\\ExcelData\\Date.xlsx";
		
		ReadData rd = new ReadData();
		
		//Establishing connection to Mysql  DB
		//String url="jdbc:mysql://metabase-replica.c5zwbgmshqe9.ap-southeast-1.rds.amazonaws.com:3306/licious";
		//Connection  con;
		//con=DriverManager.getConnection(url, "marketing", "+\\\"4hf~`2CMAn:8=}");
		
		for(int i=0; i<30; i++) {
			
			 date = rd.readDataFromExcel("excelfilepath1", "Sheet1", i, 0);
			System.out.println(date);
			
		}
		return date;
		
		//return url;
		
		
	}
	
	public static void main (String args[]) throws SQLException {
		
		System.out.println("sqlandelastic");
		sqlandelastic();
	}
}
