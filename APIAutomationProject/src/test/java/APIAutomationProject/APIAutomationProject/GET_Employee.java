package APIAutomationProject.APIAutomationProject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import junit.framework.TestCase;

public class GET_Employee extends TestCase {

	public void testGetEmployee() {

		// Specify Base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// Create Request Object
		RequestSpecification ReqObj = RestAssured.given();

		// Response Object
		Response ResObj = ReqObj.request(Method.GET, "/employees");

		// Print Response got from Server
		String ResponseBody = ResObj.getBody().asString();
		System.out.println("Response Body is:" + ResponseBody);

		// Status Code Validation
		int statuscode = ResObj.getStatusCode();
		System.out.println("Status Code is:" + statuscode);
		Assert.assertEquals(200, statuscode);
		Assert.assertEquals("application/json;charset=utf-8", ResObj.contentType());
		Assert.assertEquals("success", ResObj.jsonPath().getString("status"));
		
		// Status Line Verification
		String Statusline = ResObj.getStatusLine();
		System.out.println("Status Line is: " + Statusline);
		Assert.assertEquals("HTTP/1.1 200 OK", Statusline);
	}
}
