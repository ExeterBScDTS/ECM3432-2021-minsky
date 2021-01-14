package minskyone;


import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class servergetIT {
    @Test
    public void testFail() throws Exception {
		Response response = RestAssured.get("http://localhost:8080");
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}
}
