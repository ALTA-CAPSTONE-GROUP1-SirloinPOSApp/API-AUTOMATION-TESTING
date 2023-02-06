package starter.Sirloin.AuthStepDef.LoginStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.AuthAPI;
import starter.Sirloin.Utils.Constant;
import starter.Sirloin.Utils.SirloinResponses;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDef {

    @Steps
    AuthAPI authAPI;
    @Given("Post login with valid email and password")
    public void postLoginWithValidEmailAndPassword() {
        File json = new File(Constant.LOGIN_JSON_REQUEST+"/validEmailPass.json");
        authAPI.postLogin(json);
    }

    @When("Send request login")
    public void sendRequestLogin() {
        SerenityRest.when().post(AuthAPI.POST_LOGIN);

    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Response body page should be {int}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void responseBodyPageShouldBeIdAnd(int id, String business_name, String email, String address, String phone_number, String token, String message) {
        SerenityRest.then()
                .body(SirloinResponses.ID, equalTo(id))
                .body(SirloinResponses.BUSINESS_NAME, equalTo(business_name))
                .body(SirloinResponses.EMAIL, equalTo(email))
                .body(SirloinResponses.ADDRESS, equalTo(address))
                .body(SirloinResponses.PHONE_NUMBER, equalTo(phone_number))
                .body(SirloinResponses.TOKEN, equalTo(token))
                .body(SirloinResponses.MESSAGE, equalTo(message));
    }

    @And("Validate json schema login")
    public void validateJsonSchemaLogin() {
        File jsonSchema = new File(Constant.LOGIN_JSON_SCHEMA+"/validEmailPassSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
