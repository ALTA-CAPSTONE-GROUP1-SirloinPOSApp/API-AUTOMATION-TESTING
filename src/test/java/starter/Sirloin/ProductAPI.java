package starter.Sirloin;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class ProductAPI {

    public static String ADD_PRODUCT = Constant.BASE_URL + "/products";

    public static String GET_PRODUCT = Constant.BASE_URL + "/products";

    public static String GET_PRODUCT_ByID = Constant.BASE_URL + "/products/{id}";

    public static String GET_PRODUCT_INVALID_ID = Constant.BASE_URL + "/products/{id}";

    public static String PUT_PRODUCT = Constant.BASE_URL + "/products/{id}";


    @Step("Add product with token")
    public void addProduct(File json, String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get product with token")
    public void getProduct(String token){
        SerenityRest.given()
                .header("Authorization","Bearer " + token);
    }

    @Step("Get product by id with token")
    public void getProductById(int id, String token){
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", id);

    }

    @Step("Get product by invalid id with token")
    public void getProductInvalidID(String id, String token){
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", id);

    }

    @Step("Update product with token")
    public void updateProduct(String id, String token){
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", id);

    }

}
