package StepDefenition;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef {

	public RequestSpecification req = RestAssured.given();
	public HashMap<String,String> touristheaader;
	public Object obj;
	public Response res;
	
	@Given("create the POST request")
	public void create_the_post_request() {
		
		 req.baseUri("http://restapi.adequateshop.com/api");
		//req.baseUri("http://restapi.adequateshop.com/api/Tourist?page=2");
		req.basePath("/Tourist");
		System.out.println("BaseUrL is added");
		
		
	}
	@When("fetch the endpoint")
	public void fetch_the_endpoint() throws IOException, ParseException {
		
		
		
		touristheaader=new HashMap<String,String>();
		touristheaader.put("Content-Type", "application/json");
		
		req.headers(touristheaader);
		
		System.out.println("Header and body is created");
	}
	@Then("Post the request")
	public void post_the_request() throws IOException, ParseException {
	   
		req.headers(touristheaader);
		System.out.println("header is added");
FileReader readr =new FileReader("C:\\Users\\Administrator\\Desktop\\Project\\RestAssured\\RestAssured\\JsonFiles\\Tourist.json");
JSONParser jpa= new JSONParser();
System.out.println("File is readed");
		obj=jpa.parse(readr);
		
		req.body(obj);
		System.out.println("Requested is created");
		res=req.post();
		System.out.println("Request is posed");
	}
	@Then("verify the status code in response")
	public void verify_the_status_code_in_response() {
	   
		 JsonPath jp = new JsonPath(res.asString());
			
		 
			System.out.println(res.statusCode());
			//System.out.println(jp.get("tourist_name"));
			System.out.println(res.asString());
	}
}
