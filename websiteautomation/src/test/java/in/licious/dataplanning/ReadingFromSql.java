package in.licious.dataplanning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import in.licious.util.ReadData;

public class ReadingFromSql {
	public static String data_DB() throws Throwable
    {
        String productId=null;
        String hubId=null;
        String date=" ";
        ResultSet res1=null;
        String resQuery=null;
        String excelFilePath="C:\\Users\\vishwa\\Desktop\\Data Planning\\Data Set.xlsx";
        
        ReadData rd=new ReadData();
            
            // Dev DB Access for OTP
            String url1="jdbc:mysql://metabase-replica.c5zwbgmshqe9.ap-southeast-1.rds.amazonaws.com:3306/licious";
             
            Connection con;
                // Establishing DB connection for Dev
                con=DriverManager.getConnection(url1, "marketing", "+\"4hf~`2CMAn:8=}");
                
                // Establishing DB connection for ORT
                
                //ResultSet res = con.createStatement().executeQuery(" use licious");
                
                // To know the count of products in excel (Get last row num)
                int productCount=rd.lastrownumber();
                System.out.println(productCount);
                           
                //System.out.println(DB_data);
                for(int date1=1;date1<=1;date1++) {
                	date=rd.readDataFromExcel(excelFilePath, "Sheet1", date1, 4);
                	System.out.println(date);
                
                for(int i=1;i<=productCount;i++)
                {
                productId=rd.readDataFromExcel(excelFilePath,"Sheet1",i,0);
                System.out.println(productId);
                	for(int j=1;j<=1;j++)
                	{
                		hubId=rd.readDataFromExcel(excelFilePath,"Sheet1",j, 2);
                		int hubNumber=Integer.parseInt(hubId);
                		System.out.println(hubNumber);
                		String query="select sum(quantity) from orders o, order_items oi where o.order_id=oi.order_id and o.status!='rejected'  and product_id='"+productId+"' and hub_id='"+hubNumber+"' and date(o.order_processing_date)='"+date+"';";
                		System.out.println(query);
                		res1 = con.createStatement().executeQuery(query);
                		while (res1.next())
        				{		
                			//resQuery=res1.getString(1);
                			//System.out.println(resQuery);	
                			System.out.println(res1.getString(1));
        				}	
                	
                	}
                	
                }
                }
                con.close();
                res1.close();
				return url1;
        
}

public static void main(String args[]) throws Throwable {
	
	
	// Instantiate a Date object
    Date date = new Date();

    // display time and date using toString()
    System.out.println(date.toString());
    
    
	System.out.println("MAin Execution");
	 data_DB();
	
	 System.out.println("************************************************");
	 Date date1 = new Date();
	 System.out.println(date1.toString());

}


}
    
    /*
    for(int i=1;i<=5;i++)
    {
        for(int j=0;j<=2;j++)
        {
         DB_data=rd.readDataFromExcel(excelFilePath, "Sheet1", i, 0);
        System.out.println(DB_data);
    
        //}
     res1 = con.createStatement().executeQuery(rd.readDataFromExcel(excelFilePath, "DB_Data", 1, 0)DB_data);
    
    while (res1.next())
    {
       //String otp = res1.getString(1);
      
       otp1=res1.getString(1);
      
      // System.out.println(otp);
              
               System.out.println(otp1);
      
    }
    
    }*/
//        System.out.println("Pass 44");

/*public static int dataprovider() {

}*/

