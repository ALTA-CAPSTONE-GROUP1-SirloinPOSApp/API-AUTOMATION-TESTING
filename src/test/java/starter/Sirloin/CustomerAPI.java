package starter.Sirloin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class CustomerAPI {

    public static String ADD_CUSTOMERS = Constant.BASE_URL + "/customers";

    @Step
    public void addCustomers(String token, File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
