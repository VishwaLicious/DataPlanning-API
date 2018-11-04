package in.licious.dataplanning;




import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import in.licious.util.ReadData;

public class Json1 {
   // @Test
    public JsonElement jsonData(/*String elasticData1, String Mysqldata1*/) throws Throwable {
        String elasticdata=" ";
        String elasticdata1="select sum(order_item_quantity) from orderdataplannew where product_id='pr_5785b9065d7e1' and hub_id in ('4') and sheduled='2018-09-20'";
        
        JsonElement rootobj=null;
            ReadData rd=new ReadData();
            String excelFilePath="C:\\Users\\vishwa\\git\\SeleniumWebDriver\\ExcelData\\CompareQueries.xlsx";
            for(int i=1;i<=5;i++)
            {
             elasticdata=rd.readDataFromExcel(excelFilePath, "Mysql", i, 1);
             //System.out.println(elasticdata);
            String date1="'2018-07-01'";String date2="'2018-07-31'";
//        System.out.println(elasticdata);
            //String ss="select sum(revenue),sum(quantity) from aggregation-data where date BETWEEN '2018-07-01' AND '2018-07-31' and product_id ='pr_57f539b03c668' and hub_id = 4";
            //String sURL = "https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode(/*rd.readDataFromExcel(excelFilePath, "DB_Data", 1, 1)*/elasticdata); //just a string
            String sURL = "https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode(/*rd.readDataFromExcel(excelFilePath, "DB_Data", 1, 1)*/elasticdata1); //just a string
            
        
            
//        String    sURL1 = URLEncoder.encode(sURL, "UTF-8");
            // Connect to the URL using java's native library
            URL url = new URL(sURL);
            URLConnection request = url.openConnection();
            request.connect();

            // Convert to a JSON object to print data
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
             rootobj = root.getAsJsonObject().get("aggregations").getAsJsonObject().get("SUM(order_item_quantity)").getAsJsonObject().get("value"); //May be an array, may be an object.
            
         //   Object s1=rootobj;
            System.out.println(rootobj);
            }
            return rootobj;
    }
}