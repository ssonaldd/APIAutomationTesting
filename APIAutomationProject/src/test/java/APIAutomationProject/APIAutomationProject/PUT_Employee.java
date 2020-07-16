package APIAutomationProject.APIAutomationProject;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.TestCase;
import junit.framework.Assert;


public class PUT_Employee extends TestCase {

	
	public void testPutEmployee() {

		// Specify Base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// Create Request Object
		RequestSpecification ReqObj = RestAssured.given();

		// Request Payload
		JSONObject ReqParam = new JSONObject();

		ReqParam.put("name", "Anammika");
		ReqParam.put("salary", "300000");
		ReqParam.put("age", "21");

		ReqObj.body(ReqParam.toJSONString());

		// Response Object
		Response ResObj = ReqObj.request(Method.PUT, "/update/1");

		// Print Response got from Server
		String ResponseBody = ResObj.getBody().asString();
		System.out.println("Response Body is:" + ResponseBody);
		
		// Status Code Validation
		int statuscode = ResObj.getStatusCode();
		System.out.println("Status Code is:" + statuscode);
		Assert.assertEquals(200, statuscode);
		Assert.assertEquals("application/json;charset=utf-8", ResObj.contentType());
		Assert.assertEquals("success", ResObj.jsonPath().getString("status"));
		// Verify the Data Which was input
		Assert.assertEquals(true, ResponseBody.contains("Anamika"));
		Assert.assertEquals(true, ResponseBody.contains("300000"));
		Assert.assertEquals(true, ResponseBody.contains("21"));
	}

}
