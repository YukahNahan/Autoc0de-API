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
}
