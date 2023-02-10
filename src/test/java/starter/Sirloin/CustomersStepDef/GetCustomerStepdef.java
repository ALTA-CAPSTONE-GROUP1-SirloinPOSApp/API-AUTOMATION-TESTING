package starter.Sirloin.CustomersStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.CustomerAPI;

public class GetCustomerStepdef {

    @Steps
    CustomerAPI customerAPI;

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjU0fQ.4OjLwaZl68OM8zHYCSmNhD3S579V8n8JV0iT2GwAD6c";
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
        customerAPI.getCustomerInvalidId(token,id);
    }

    @When("Send request getCustomer with invalid id")
    public void sendRequestGetCustomerWithInvalidId() {
        SerenityRest.when().get(CustomerAPI.GET_CUSTOMER_InvalidID);
    }
}
