package com.CE.automation.services.impls;

import com.CE.automation.helpers.CEAPIEndPoints;
import com.CE.automation.services.RequestFilter;
import com.CE.automation.services.UserService;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

/**
 * Created by Skatukam on 09/14/2018.
 */
public class UserServiceImpl implements UserService {
    public String getUserInfo(){
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                        .get(CEAPIEndPoints.GET_ME).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().jsonPath().getString("login");
    }
}
