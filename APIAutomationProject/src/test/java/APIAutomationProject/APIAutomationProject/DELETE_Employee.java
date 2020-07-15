package APIAutomationProject.APIAutomationProject;

import org.testng.AssertJUnit;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DELETE_Employee {
		
		@SuppressWarnings("unchecked")
		void DeleteEmployee()
		{
		
		//Specify Base URI
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		//Create Request Object
		RequestSpecification ReqObj = RestAssured.given ();
		
		//Response Object
		Response ResObj = ReqObj.request(Method.DELETE,"/delete/15");
			
		//Print Response got from Server
		String ResponseBody = ResObj.getBody().asString();
		System.out.println("Response Body is:"+ResponseBody);
		
		//Status Code Validation
		int statuscode=ResObj.getStatusCode();
		System.out.println("Status Code is:"+statuscode);
		AssertJUnit.assertEquals(200, statuscode);
		
	}

		public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		DELETE_Employee Obj= new DELETE_Employee();
		Obj.DeleteEmployee();
		
		}
		
	}

	
	

