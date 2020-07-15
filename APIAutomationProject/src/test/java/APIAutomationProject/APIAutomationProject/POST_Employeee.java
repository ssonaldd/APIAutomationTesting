package APIAutomationProject.APIAutomationProject;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_Employeee {
	
	@Test(dataProvider="empdataprovider")
	void PostEmployee(String eName, String eSalary, String eAge)
	{
	
	//Specify Base URI
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	
	//Create Request Object
	RequestSpecification ReqObj = RestAssured.given ();
	
	//Request Payload
	JSONObject ReqParam= new JSONObject();
	
	ReqParam.put("name",eName);
	ReqParam.put("salary",eSalary);
	ReqParam.put("age",eAge);
	
	ReqObj.body(ReqParam.toJSONString());
	
	//Response Object
	Response ResObj = ReqObj.request(Method.POST,"/create");
	
	//Print Response got from Server
	String ResponseBody = ResObj.getBody().asString();
	System.out.println("Response Body is:"+ResponseBody);
	
	//Status Code Validation
	int statuscode=ResObj.getStatusCode();
	System.out.println("Status Code is:"+statuscode);
	AssertJUnit.assertEquals(200, statuscode);
	
	//Verify the Data Which was input
	AssertJUnit.assertEquals(ResponseBody.contains(eName), true);
	AssertJUnit.assertEquals(ResponseBody.contains(eSalary), true);
	AssertJUnit.assertEquals(ResponseBody.contains(eAge), true);
}

	
	@DataProvider(name="empdataprovider")
	String [][] getEmployeeData()
	{
		String empData[][]={{"Anisha", "1000000", "30"},{"Anita", "900000", "30"},{"Amrita", "1200000", "30"}};
		return empData;
		
	}
	
	
}
