package APIAutomationProject.APIAutomationProject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GET_Employee1 {
	
	void GetEmployee1()
	{
	
	//Specify Base URI
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	
	//Create Request Object
	RequestSpecification ReqObj = RestAssured.given ();
	
	//Response Objects
	Response ResObj = ReqObj.request(Method.GET,"/employee/1");
	
	//Print Response got from Server
	String ResponseBody = ResObj.getBody().asString();
	System.out.println("Response Body is:"+ResponseBody);
	
	//Status Code Validation
	int statuscode=ResObj.getStatusCode();
	System.out.println("Status Code is:"+statuscode);
	Assert.assertEquals(200, statuscode);
	
	//Status Line Verification
	String Statusline = ResObj.getStatusLine();
	System.out.println("Status Line is: "+Statusline);
	Assert.assertEquals("HTTP/1.1 200 OK", Statusline);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	GET_Employee1 Obj= new GET_Employee1();
	Obj.GetEmployee1();
	
	}

}
