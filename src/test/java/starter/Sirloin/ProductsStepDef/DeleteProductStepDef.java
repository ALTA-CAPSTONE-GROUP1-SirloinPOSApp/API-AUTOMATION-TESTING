package starter.Sirloin.ProductsStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.ProductAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class DeleteProductStepDef {

    @Steps
    ProductAPI productAPI;

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjU0fQ.4OjLwaZl68OM8zHYCSmNhD3S579V8n8JV0iT2GwAD6c";
    @Given("Delete product with valid parameter id {int}")
    public void deleteProductWithValidParameterId(int id) {
        productAPI.deleteProduct(token, id);
    }

    @When("Send request deleteProduct")
    public void sendRequestDeleteProduct() {
        SerenityRest.when().delete(ProductAPI.DELETE_PRODUCT);
    }

    @And("Validate json schema deleteProduct")
    public void validateJsonSchemaDeleteProduct() {
        File jsonSchema = new File(Constant.deletePRODUCT_JSON_SCHEMA + "/deleteProductSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Delete product with invalid parameter {string}")
    public void deleteProductWithInvalidParameter(String id) {
        productAPI.deleteProductInvalidID(token, id);
    }

    @Given("Delete product with invalid token with id {int}")
    public void deleteProductWithInvalidTokenWithId(int id) {
        String invalidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp5cnVlLCJ1c2VySUQiOjU0fQ.4OjLwaZl68OM8zHYCSmNhD3S579V8n8JV0iT2GwAD6c";
        productAPI.deleteProduct(invalidToken, id);
    }
}
