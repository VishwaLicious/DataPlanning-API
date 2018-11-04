package in.licious.dataplanning;

import org.testng.annotations.Test;

import com.google.gson.JsonElement;

public class Compare_DB {
@Test
public void compareData() throws Throwable
{ 
    Json1 j=new Json1();
    SQL_DB s=new SQL_DB();
    JsonElement js=j.jsonData();
    String js1=js.toString();
    
    //System.out.println(js1);
    String db=s.data_DB();
    //System.out.println(db);
    
    

    for(int i=0;i<=5;i++)
    {
    if(js1.equals(db))
    { 
        System.out.println("same"+js1+" "+db);
    }else
    {
        System.out.println("not same");
    }
    }
    /*for(int i=1;i<=5;i++)
    {
        if(j.jsonData().)
    }*/
}
}