package steps;

import actions.ApiActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import utils.Constants;

import java.io.IOException;

public class ApiSteps {
    @Steps
    ApiActions apiActions;



    @When("I trigger POST call to Authenticate the user$")
        public void iTriggerPostCallToAuthenticateTheUser() throws IOException {
        apiActions.initialisePOSTCall(Constants.LOGIN_ENDPONT, "\\testdata\\NewLoginPayLoad.json");


        }

    @Then("I see the status code as (\\d+)$")
    public void iSeeTheStatusCodeAs(int statusCode) {
        apiActions.assertStatusCode(statusCode);
    }

    @And("the response body should match \"([^\"]*)\" file$")
    public void theResponseBodyShouldMatchFile(String jsonSchemaFileName) throws Throwable {
        apiActions.checkValidResponse(jsonSchemaFileName);
    }

    @When("I trigger POST call to create a new booking")
    public void iTriggerPOSTCallToCreateANewBooking() throws IOException {
        apiActions.initialisePOSTCall(Constants.BOOKING_ENDPOINT
                , "\\testdata\\NewBookingsPayload.json");

    }

    @When("I trigger GET call on bookings list")
    public void iTriggerGETCallOnBookingsList() {
apiActions.initialiseGETCall(Constants.BOOKING_ENDPOINT);
    }

    @When("I trigger DELETE call on booking number {int}")
    public void iTriggerDELETECallOnBookingNumber(int id) throws IOException{
apiActions.initialiseDELETECall(Constants.BOOKING_ENDPOINT, id);
    }

    @When("I trigger GET call with the booking id {int}")
    public void iTriggerGETCallWithTheBookingId(int bookingid) {
        apiActions.initialiseGETCall(Constants.BOOKING_ENDPOINT+"/"+bookingid);

    }

    @When("I trigger PUT call to update the booking {int}")
    public void iTriggerPUTCallToUpdateANewBooking(int id) throws IOException {
        apiActions.initialisePUTCall(Constants.BOOKING_ENDPOINT
                , "\\testdata\\UpdateBookingPayload.json", id);
    }

    @When("I trigger POST call to create a new post")
    public void iTriggerPOSTCallToCreateANewPost() throws IOException {
        apiActions.initialisePOSTCall(Constants.POSTS_ENDPOINT
                , "\\testdata\\NewUserPayload.json");

    }


    @When("I trigger POST call to create a new user")
    public void iTriggerPOSTCallToCreateANewUser() throws IOException {
        apiActions.initialisePOSTCall(Constants.USERS_ENDPOINT
                , "\\testdata\\NewUserPayload.json");

    }

    @When("I trigger GET call on photography list")
    public void iTriggerGETCallOnPhotographyList() {
        apiActions.initialiseGETCall(Constants.PHOTOGRAPHY_ENDPOINT);
    }

    @When("I trigger GET call on albums list")
    public void iTriggerGETCallOnAlbumsList() {
        apiActions.initialiseGETCall(Constants.ALBUMS_ENDPOINT);
    }

    @When("I trigger GET call on comments list")
    public void iTriggerGETCallOnCommentsList() {
        apiActions.initialiseGETCall(Constants.COMMENTS_ENDPOINT);
    }

    @When("I trigger GET call on users list")
    public void iTriggerGETCallOnUsersList() {
        apiActions.initialiseGETCall(Constants.USERS_ENDPOINT);
    }
}