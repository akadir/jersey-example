package io.git.kadir.jersey.example.restservice;

import io.git.kadir.jersey.example.restservice.auth.UserCredential;
import io.git.kadir.jersey.example.restservice.configuration.MyJerseyTest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * @author akarakoc
 * Date :   10.05.2019
 * Time :   11:07
 */
public class StatusTest extends MyJerseyTest {
    private final String isUpPath = "/isUp";

    @Test
    public void testStatus_withCorrectRequest_thenResponseIsOkAndContainsTrue() throws ParseException {
        final int expectedResponseStatus = 200;
        final boolean expectedResponseContent = true;
        Response response = target(isUpPath)
                .request()
                .header(HttpHeaders.AUTHORIZATION, UserCredential.CORRECT.getBasicAuthToken())
                .get();
        int responseStatus = response.getStatus();
        String responseContent = response.readEntity(String.class);
        JSONParser parser = new JSONParser();
        JSONObject responseJson = (JSONObject) parser.parse(responseContent);
        assertEquals("Should return status 200", expectedResponseStatus, responseStatus);
        assertEquals("Should return true", expectedResponseContent, responseJson.get("data"));
    }
}
