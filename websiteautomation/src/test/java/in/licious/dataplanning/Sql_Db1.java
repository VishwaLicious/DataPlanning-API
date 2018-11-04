package in.licious.dataplanning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.testng.annotations.Test;

import in.licious.util.ReadData;

public class Sql_Db1 {
    //@Test
	 
	
	public static void main(String args[]) throws Throwable
	{
		System.out.println("HUI>>>>>>>>>>>>>");
		data_DB();
	}
		
    public static String data_DB() throws Throwable
    {
        String otp1=null;
        double otp2=0;
        String DB_data=" ";
        ResultSet res1=null;
        String excelFilePath="C:\\Users\\vishwa\\git\\Data_Planning_API_Automation\\websiteautomation\\ExcelData\\Data Set.xlsx";
        
        ReadData rd=new ReadData();
            
            // Dev DB Access for OTP
            String url1="jdbc:mysql://metabase-replica.c5zwbgmshqe9.ap-southeast-1.rds.amazonaws.com:3306/licious";
            
            
            Connection con;

                // Establishing DB connection for Dev
                con=DriverManager.getConnection(url1, "marketing", "+\"4hf~`2CMAn:8=}");
                
                // Establishing DB connection for ORT
                
                //ResultSet res = con.createStatement().executeQuery(" use licious");
                
                
                //System.out.println(DB_data);
                for(int i=1;i<=5;i++)
                {
                    /*for(int j=0;j<=2;j++)
                    {*/
                     DB_data=rd.readDataFromExcel(excelFilePath, "Sheet1", i, 0);
                    System.out.println(DB_data);
                
                    //}
                 res1 = con.createStatement().executeQuery(/*rd.readDataFromExcel(excelFilePath, "DB_Data", 1, 0)*/DB_data);
                
                while (res1.next())
                {
                   //String otp = res1.getString(1);
                  
                   otp1=res1.getString(1);
                  
                  // System.out.println(otp);
                          
                           System.out.println(otp1);
                  
                }
                
                }
//                    System.out.println("Pass 44");
                
                otp2= Double.parseDouble(otp1);
                
                String total2 = String.valueOf(otp2);
              
               System.out.println(otp2);
                //System.out.println(res1.getString(1));
                con.close();
                res1.close();
                    
            Class.forName("com.mysql.cj.jdbc.Driver");
            return total2;
                    
        }
        
        
	
    

}