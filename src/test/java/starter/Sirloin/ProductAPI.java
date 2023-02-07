package starter.Sirloin;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class ProductAPI {

    public static String ADD_PRODUCT = Constant.BASE_URL + "/products";

    @Step("Add product valid input and token")
    public void addProductValid(File json, String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
