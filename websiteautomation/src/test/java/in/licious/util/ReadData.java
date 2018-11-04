 package in.licious.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
public class ReadData {
	
	public static String readDataFromPropertiesFile(String propertiesFilePath,String key){
		
		Properties property=new Properties();
		try {
			property.load(new FileInputStream(propertiesFilePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return property.getProperty(key);
	}
	public static void initProperties(){
		ClassLoader.getSystemResourceAsStream("");
	}
	public static String readDataFromExcel(String excelFilePath,String excelSheetName,int rowNumber,int columnNumber){
		
		FileInputStream fis=null;
		String value=null;
		try {
			fis = new FileInputStream(excelFilePath);
			if(rowNumber>0){
				//value=WorkbookFactory.create(fis).getSheet(excelSheetName).getRow(rowNumber).getCell(columnNumber).toString();
				//The above of line code was converting yyyy-mm-dd to dd-mon-yyyy hence using below line of code
				value=WorkbookFactory.create(fis).getSheet(excelSheetName).getRow(rowNumber).getCell(columnNumber).getStringCellValue();
			}
			else{
				throw new RuntimeException("rowNumber should be greater than one");
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	
	//to get to know the last row no
	
	public static int lastrownumber() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream fis =new FileInputStream("C:\\Users\\vishwa\\Desktop\\Data Planning\\Data Set.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Sheet1");
		int lastrownumber=s.getLastRowNum();
		return lastrownumber;
		
	}
	
	@DataProvider
	public static Object[][] getdata() throws Throwable{
		
		
		int rowindex=lastrownumber();
		Object[][] obj=new Object[rowindex][1];
		for (int i=1;i<rowindex;i++)
		{
			obj[i][0]=readDataFromExcel("C:\\\\Users\\\\vishwa\\\\Desktop\\\\Data Planning\\\\Data Set.xlsx", "Sheet1", i, 0);
			System.out.println(obj[i][0]);
		}
		String obj1=obj.toString();
		System.out.println(obj1);
		return obj;
		
		
	}
		
	public static void main(String args[]) throws Throwable
	{
		getdata();
	}

}
