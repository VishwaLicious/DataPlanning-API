package in.licious.dataplanning_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class UpdateActualsAndLossSaleToDemandPlanAPI {
	@Test
	public void updateActualsAndLossSaleToDemandPlanTest()
	{
	RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
//		requestParams.put("date", "2018-10-01"); 
//		requestParams.put("date", "2018-10-02");
//		requestParams.put("date", "2018-10-03");
//		requestParams.put("date", "2018-10-04");
//		requestParams.put("date", "2018-10-05");
		//requestParams.put("date", "2018-10-08");
		//requestParams.put("date", "2018-10-05");
		requestParams.put("date", "2018-10-28");
		//requestParams.put("date", "2018-10-09");
		//requestParams.put("date", "2018-10-10");
		
		// Add a header stating the Request body is a JSON 	123
		request.header("Content-Type", "application/json");
		// Add a header stating the Request body is a JSON
		request.header("token", "e6e061838856bf47e1de730719fb2609");
		
		request.body(requestParams.toJSONString());
		
		Response response = request.post("http://13.126.207.17/forecast/services/updateActualsAndLossSaleToDemandPlan");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String data = response.getContentType();
		ResponseBody data1 = response.getBody();

		System.out.println(statusCode);
		System.out.println(data);
		System.out.println(data1.asString());
	}
}
