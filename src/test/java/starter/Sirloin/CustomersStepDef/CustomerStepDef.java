package starter.Sirloin.CustomersStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.CustomerAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class CustomerStepDef {

    @Steps
    CustomerAPI customerAPI;

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjU0fQ.4OjLwaZl68OM8zHYCSmNhD3S579V8n8JV0iT2GwAD6c";
    @Given("Post inputCustomer with valid json")
    public void postInputCustomerWithValidJson() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerValid.json");
        customerAPI.inputCustomer(json, token);
    }

    @When("Send request inputCustomer")
    public void sendRequestInputCustomer() {
        SerenityRest.when().post(CustomerAPI.INPUT_CUSTOMER);
    }

    @Given("Post inputCustomer with invalid json")
    public void postInputCustomerWithInvalidJson() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerInvalid.json");
        customerAPI.inputCustomer(json, token);
    }

    @Given("Post inputCustomer with registered email")
    public void postInputCustomerWithRegisteredEmail() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerRegisteredEmail.json");
        customerAPI.inputCustomer(json, token);
    }

    @Given("Post inputCustomer with registered phone number")
    public void postInputCustomerWithRegisteredPhoneNumber() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerRegisteredPhone.json");
        customerAPI.inputCustomer(json, token);
    }

    @Given("Get display all customer")
    public void getDisplayAllCustomer() {
        customerAPI.getCustomer(token);
    }

    @When("Send request getCustomer")
    public void sendRequestGetCustomer() {
        SerenityRest.when().get(CustomerAPI.GET_CUSTOMER);
    }

    @Given("Get display customer with id {int}")
    public void getDisplayCustomerWithId(int id) {
        customerAPI.getCustomerById(token, id);
    }

    @When("Send request getCustomer with id")
    public void sendRequestGetCustomerWithId() {
        SerenityRest.when().get(CustomerAPI.GET_CUSTOMER_ByID);
    }

    @Given("Get display customer with invalid id {string}")
    public void getDisplayCustomerWithInvalidId(String id) {
        customerAPI.getCustomerInvalidId(token, id);
    }

    @When("Send request getCustomer with invalid id")
    public void sendRequestGetCustomerWithInvalidId() {
        SerenityRest.when().get(CustomerAPI.GET_CUSTOMER_InvalidID);
    }
}
