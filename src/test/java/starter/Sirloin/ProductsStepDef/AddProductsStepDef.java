package starter.Sirloin.ProductsStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.AuthAPI;
import starter.Sirloin.ProductAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class AddProductsStepDef {
    @Steps
    ProductAPI productAPI;
    @Given("Post addProduct with valid json and token")
    public void postAddProductWithValidJsonAndToken() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjI0fQ.pI_POmwE6aheZHbhJE0nudMNJKl8Ug-30bNzp2r9_3o";
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductValid.json");
        productAPI.addProductValid(json, token);

    }

    @When("Send request addProduct")
    public void sendRequestAddProduct() {
        SerenityRest.when().post(ProductAPI.ADD_PRODUCT);
    }
}
