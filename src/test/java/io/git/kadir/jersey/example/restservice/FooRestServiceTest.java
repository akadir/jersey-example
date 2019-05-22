package io.git.kadir.jersey.example.restservice;

import io.git.kadir.jersey.example.restservice.auth.UserCredential;
import io.git.kadir.jersey.example.restservice.configuration.MyJerseyTest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

/**
 * @author akarakoc
 * Date :   13.05.2019
 * Time :   09:17
 */
public class FooRestServiceTest extends MyJerseyTest {
    private final String url = "/foo";

    @Test
    public void testFoo_withCorrectUserCredentials_thenResponseShouldBeOkWithCorrectResult() throws ParseException {
        String expectedResultData = "lorem";
        Response response = target(url)
                .queryParam("bar", "lorem")
                .request()
                .header("userId", UserCredential.CORRECT.getUserId())
                .header("password", UserCredential.CORRECT.getPassword())
                .get();

        assertEquals("Http Response should be 200: ", Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("Http Content-Type should be correct: ", MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        String content = response.readEntity(String.class);
        JSONParser parser = new JSONParser();
        JSONObject responseJson = (JSONObject) parser.parse(content);
        assertTrue("success true", (Boolean) responseJson.get("success"));
        assertNotNull("requestId not null", responseJson.get("requestId"));
        assertEquals("result should contain correct data", expectedResultData, responseJson.get("data"));
        System.out.println("System prop foo: " + System.getProperty("foo"));
    }

    @Test
    public void testFoo_withWrongUserCredentials_thenResponseShouldBeUnauthorizedWithError() throws ParseException {
        String expectedError = "BadAuthenticationCredentialException";
        Response response = target(url)
                .queryParam("bar", "lorem")
                .request()
                .header("userId", UserCredential.WRONG.getUserId())
                .header("password", UserCredential.WRONG.getPassword())
                .get();

        assertEquals("Http Response should be 401: ", Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
        assertEquals("Http Content-Type should be correct: ", MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        String content = response.readEntity(String.class);
        JSONParser parser = new JSONParser();
        JSONObject responseJson = (JSONObject) parser.parse(content);
        assertFalse("success false", (Boolean) responseJson.get("success"));
        assertNotNull("requestId not null", responseJson.get("requestId"));
        assertEquals("response should contain error", expectedError, responseJson.get("error"));
        System.out.println("System prop foo: " + System.getProperty("foo"));
    }

    @Test
    public void testPostFoo_withStringValue_thenResponseShouldBe200() {
        MultivaluedHashMap<String, String> form = new MultivaluedHashMap<>();
        form.add("foo", "foo");
        JSONObject jo = new JSONObject();
        jo.put("foo", "foo");
        Response response = target("/ipsum")
                .request()
                .header("userId", UserCredential.CORRECT.getUserId())
                .header("password", UserCredential.CORRECT.getPassword())
                .post(Entity.form(form));

        System.out.println(response.getStatus());
    }
}
