package test.sdet;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class APItest {
@Test
	void test1() {
		Response response =get("https://reqres.in/api/users?delay=3");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
public void test2() {
	
	given().
	get("\"https://reqres.in/api/users?delay=3\"").
	then().
	statusCode(200);
	//body("data[1].id".equals(8)).
	//log().all();
	
}
//postest
JSONObject req = new JSONObject();
@Test

void test3() {
	
	req.put("email","peter@klaven");
	System.out.println(req);
	given().
	body(req.toJSONString()).
	when().
	post("https://reqres.in/api/users").
	then().statusCode(200).
	//body("id",equals(6)).
	log().all();
	
}
void test4() {
	
	given().
	get("\"https://reqres.in/api/users?delay=3\"").
	then().
	statusCode(200).
	log().all();
	

}
}
