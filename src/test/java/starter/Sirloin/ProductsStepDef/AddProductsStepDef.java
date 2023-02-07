package starter.Sirloin.ProductsStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.AuthAPI;
import starter.Sirloin.ProductAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class AddProductsStepDef {
    @Steps
    ProductAPI productAPI;

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjI0fQ.pI_POmwE6aheZHbhJE0nudMNJKl8Ug-30bNzp2r9_3o";

    @Given("Post addProduct with valid json and token")
    public void postAddProductWithValidJsonAndToken() {
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductValid.json");
        productAPI.addProduct(json, token);

    }

    @When("Send request addProduct")
    public void sendRequestAddProduct() {
        SerenityRest.when().post(ProductAPI.ADD_PRODUCT);
    }

    @Given("Post addProduct without upc")
    public void postAddProductWithoutUpc() {
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductWithoutUPC.json");
        productAPI.addProduct(json, token);
    }

    @And("Validate json schema addProduct negative case")
    public void validateJsonSchemaAddProductNegativeCase() {
        File jsonSchema = new File(Constant.addPRODUCT_JSON_SCHEMA + "/negativeCaseAddProductSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post addProduct without category")
    public void postAddProductWithoutCategory() {
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductWithoutCategory.json");
        productAPI.addProduct(json, token);

    }

    @Given("Post addProduct without product name")
    public void postAddProductWithoutProductName() {
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductWithoutProductName.json");
        productAPI.addProduct(json, token);
    }

    @Given("Post addProduct without number of stock")
    public void postAddProductWithoutNumberOfStock() {
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductWithoutNumberStock.json");
        productAPI.addProduct(json, token);
    }

    @Given("Post addProduct without minimum stock")
    public void postAddProductWithoutMinimumStock() {
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductWithoutMinimumStock.json");
        productAPI.addProduct(json, token);
    }

    @Given("Post addProduct without price")
    public void postAddProductWithoutPrice() {
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductWithoutPrice.json");
        productAPI.addProduct(json, token);
    }

    @Given("Post addProduct without product image")
    public void postAddProductWithoutProductImage() {
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductWithoutProductImage.json");
        productAPI.addProduct(json, token);
    }

    @Given("Post addProduct with existing upc")
    public void postAddProductWithExistingUpc() {
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductWithExistingUPC.json");
        productAPI.addProduct(json, token);
    }

    @Given("Post addProduct with existing product name")
    public void postAddProductWithExistingProductName() {
        File json = new File(Constant.addPRODUCT_JSON_REQUEST + "/addProductWithExistingProductName.json");
        productAPI.addProduct(json, token);
    }
}
