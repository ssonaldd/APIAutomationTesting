package APIAutomationProject.APIAutomationProject;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class PUT_Employee {
	
	@SuppressWarnings("unchecked")
	void PostEmployee()
	{
	
	//Specify Base URI
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	
	//Create Request Object
	RequestSpecification ReqObj = RestAssured.given ();
	
	//Request Payload
	JSONObject ReqParam= new JSONObject();
		
	ReqParam.put("name","Anammika");
	ReqParam.put("salary","300000");
	ReqParam.put("age","21");
	
	ReqObj.body(ReqParam.toJSONString());
	
	//Response Object
	Response ResObj = ReqObj.request(Method.PUT,"/update/1");
		
	//Print Response got from Server
	String ResponseBody = ResObj.getBody().asString();
	System.out.println("Response Body is:"+ResponseBody);
	
	//Status Code Validation
	int statuscode=ResObj.getStatusCode();
	System.out.println("Status Code is:"+statuscode);
	AssertJUnit.assertEquals(200, statuscode);
	
	//Verify the Data Which was input
	AssertJUnit.assertEquals(ResponseBody.contains("Anamika"), true);
	AssertJUnit.assertEquals(ResponseBody.contains("300000"), true);
	AssertJUnit.assertEquals(ResponseBody.contains("21"), true);
}

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
	PUT_Employee Obj= new PUT_Employee();
	Obj.PostEmployee();
	
	}
	
}
