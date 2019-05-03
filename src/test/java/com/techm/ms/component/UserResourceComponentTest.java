/**
 * 
 */
package com.techm.ms.component;

import java.net.InetAddress;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * @author Murtuza
 *
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserResourceComponentTest {
	
	@LocalServerPort
	protected int randomServerPort;
	
	private String uri ="/createUser";

	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = "http://" + InetAddress.getLocalHost().getHostName() + ":" + randomServerPort + "/";
	}
	
	private  RequestSpecification givenBaseSpec() {
		return RestAssured.given()
						  .accept(ContentType.JSON)
						  .contentType(ContentType.JSON);
	}
	
	
	
	
	@Test
	public void testCreateUser_success() {
		givenBaseSpec()
		.when()
		.get(uri)
		.then()
		.statusCode(201);
	}
	
	@Test
	public void testCreateUser_duplicate() {
		givenBaseSpec()
		.when()
		.get(uri)
		.then()
		.statusCode(409);
	}
	
	@Test
	public void testGetUser_success() {
		givenBaseSpec()
		.when()
		.get(uri)
		.then()
		.statusCode(200);
	}
	
	@Test
	public void testGetUser_notfound() {
		givenBaseSpec()
		.when()
		.get(uri)
		.then()
		.statusCode(404);
	}
	
	
}
