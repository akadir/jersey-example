package io.git.kadir.jersey.example.entity;

import io.git.kadir.jersey.example.util.Constants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.MDC;

/**
 * @author akarakoc
 * Date :   10.05.2019
 * Time :   17:51
 */
@SuppressWarnings("unchecked")
public class SimpleReturnObjectBuilder {
    private boolean success;
    private JSONObject simpleReturnObject = new JSONObject();
    private String error = "";
    private String errorMessage = "";


    public SimpleReturnObjectBuilder data(JSONObject data) {
        simpleReturnObject.put("data", data);
        return this;
    }

    public SimpleReturnObjectBuilder data(JSONArray data) {
        simpleReturnObject.put("data", data);
        return this;
    }

    public SimpleReturnObjectBuilder data(String data) {
        simpleReturnObject.put("data", data);
        return this;
    }

    public SimpleReturnObjectBuilder data(Boolean data) {
        simpleReturnObject.put("data", data);
        return this;
    }

    public SimpleReturnObjectBuilder isSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public SimpleReturnObjectBuilder error(String error) {
        this.error = error;
        return this;
    }

    public SimpleReturnObjectBuilder errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public JSONObject buildJSONObject() {
        simpleReturnObject.put("success", this.success);
        simpleReturnObject.put("error", this.error);
        simpleReturnObject.put("errorMessage", this.errorMessage);
        simpleReturnObject.put("requestId", MDC.get(Constants.REQUEST_ID_KEY));
        return simpleReturnObject;
    }
}
