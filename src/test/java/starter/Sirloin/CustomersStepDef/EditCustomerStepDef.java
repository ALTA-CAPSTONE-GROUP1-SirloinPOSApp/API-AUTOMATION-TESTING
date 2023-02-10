package starter.Sirloin.CustomersStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.CustomerAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class EditCustomerStepDef {

    @Steps
    CustomerAPI customerAPI;

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjU0fQ.4OjLwaZl68OM8zHYCSmNhD3S579V8n8JV0iT2GwAD6c";

    @Given("Put editCustomer with valid id {int}")
    public void putEditCustomerWithValidId(int id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerValid.json");
        customerAPI.editCustomerById(token, id, json);

    }

    @When("Send request editCustomer")
    public void sendRequestEditCustomer() {
        SerenityRest.when().put(CustomerAPI.EDIT_CUSTOMER_ByID);
    }

    @Given("Put editCustomer with invalid id {string}")
    public void putEditCustomerWithInvalidId(String id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerValid.json");
        customerAPI.editCustomerInvalidId(token, id, json);
    }

    @Given("Put editCustomer with valid json and id {int}")
    public void putEditCustomerWithValidJsonAndId(int id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerValid.json");
        customerAPI.editCustomerById(token, id, json);

    }

    @Given("Put editCustomer with invalid json and id {int}")
    public void putEditCustomerWithInvalidJsonAndId(int id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerInvalid.json");
        customerAPI.editCustomerById(token, id, json);
    }
}
