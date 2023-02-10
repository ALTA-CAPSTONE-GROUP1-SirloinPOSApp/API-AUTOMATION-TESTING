package starter.Sirloin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class CustomerAPI {

    public static String INPUT_CUSTOMER = Constant.BASE_URL + "/customers";

    @Step("Add customer with token")
    public void inputCustomer(File json, String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
