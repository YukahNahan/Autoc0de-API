package actions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import utils.Common;
import utils.Constants;


import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiActions {

    Response response;
    RequestSpecification request = SerenityRest.given();
    @Steps
    Common commonCode;

    @Step
    public void initialisePOSTCall(String endpoint, String jsonPayLoad) throws IOException {
        String jsonBody = commonCode.generateStringFromResource(System.getProperty("user.dir")+jsonPayLoad);
        request.header("Content-Type","application/json");
        request.body(jsonBody);
        response = request.when().post(Constants.HOST +endpoint);
    }

    @Step
    public void assertStatusCode(int statusCode){

        Assert.assertEquals(response.getStatusCode(),statusCode);
    }

    @Step
    public void checkValidResponse(String jsonSchemaFileName) {
        response.then().assertThat().body(matchesJsonSchemaInClasspath(jsonSchemaFileName));

    }
    @Step
    public void initialiseGETCall(String endpoint){
        request.header("Content-Type","application/json");
        response = request.when().get(Constants.HOST +endpoint);
    }

    @Step
    public void initialiseDELETECall(String endpoint, int id) throws IOException {
        request.header("Cookie", "token=abc123");
        request.header("Content-Type","application/json");
        request.given().auth().preemptive().basic("admin", "password123");
        response = request.when().delete(Constants.HOST +endpoint+"/"+id);
    }

}
