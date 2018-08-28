package com.springclass.boot.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class TestClient {

	private static final Logger log = LoggerFactory.getLogger(TestClient.class);
	
	private static int numberOfTestAttempts = 10;

	private static String usersUri = "http://localhost:8080/users";
	private static String userToPost = "{ \"firstName\" : \"Mick\", \"lastName\" : \"Knutson\" }";

	/** 
	 * Simple Test method to verify the Spring Boot REST API.
	 * @param args
	 */
	public static void main(String args[]) {

		RestTemplate restTemplate = new RestTemplate();

		String result = null;
		
		// In case there was a User in the database already;
		delete_users(restTemplate);

		// First get user, and there should be none.
		result = TestClient.get_users(restTemplate);
		log.info("get_users Result: {}", result);
		assertThat(result, containsString("\"users\" : [ ]"));

		// Next post a new user.
		result = TestClient.post_user1(restTemplate);
		log.info("post_user1 Result: {}", result);

		result = TestClient.get_users(restTemplate);
		log.info("get_users Result: {}", result);
		assertThat(result, containsString("\"firstName\" : \"Mick\""));

		// Delete the user from the database:
		delete_users(restTemplate);

		result = TestClient.get_users(restTemplate);
		log.info("get_users Result: {}", result);
		assertThat(result, containsString("\"users\" : [ ]"));
		
		log.info("*** Successfully created a User through REST ***");

	}

	public static String get_users(RestTemplate restTemplate) {
		return restTemplate.getForObject(usersUri, String.class);
	}

	public static String post_user1(RestTemplate restTemplate) {
		String result = "";

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(userToPost, headers);
			ResponseEntity<String> response = restTemplate.postForEntity(usersUri, request, String.class);



			if (response != null) {
                response.getStatusCode();
                response.getStatusCodeValue();
                response.getHeaders();

				return response.getBody();
			}



		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * A simple deleteAll method to clear the database before restarting Boot application
	 * @param restTemplate
	 */
	public static void delete_users(RestTemplate restTemplate) {
		for(int i = 1; i < numberOfTestAttempts; i++){
			try{
				restTemplate.delete(usersUri + "/" + i);
			} catch (Exception e){}
		}
	}
}
