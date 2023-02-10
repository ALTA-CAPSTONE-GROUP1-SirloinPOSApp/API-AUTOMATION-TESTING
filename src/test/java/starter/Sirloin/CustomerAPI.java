package starter.Sirloin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class CustomerAPI {

    public static String INPUT_CUSTOMER = Constant.BASE_URL + "/customers";

    public static String GET_CUSTOMER = Constant.BASE_URL + "/customers";

    public static String GET_CUSTOMER_ByID = Constant.BASE_URL + "/customers/{id}";

    public static String GET_CUSTOMER_InvalidID = Constant.BASE_URL + "/customers/{id}";


    @Step("Add customer with token")
    public void inputCustomer(File json, String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get all customer")
    public void getCustomer(String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }

    @Step("Get customer with id")
    public void getCustomerById(String token, int id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", id);
    }

    @Step("Get customer with invalid")
    public void getCustomerInvalidId(String token, String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", id);
    }

}
