package com.CE.automation.services.impls;

import com.CE.automation.helpers.CEAPIEndPoints;
import com.CE.automation.services.CommonService;
import com.CE.automation.services.RequestFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

/**
 * Created by Skatukam on 09/14/2018.
 */
public class CommonServiceImpl implements CommonService {
    public String getPing(){
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .get(CEAPIEndPoints.PING).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().jsonPath().getString("endpoint");
    }
    public int retrieveStorage(){
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .get(CEAPIEndPoints.RETRIEVE_STORAGE).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().getStatusCode();
    }
    public String getFileAndFolder(String path,String text){
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .queryParam("path",path)
                .queryParam("text",text)
                .get(CEAPIEndPoints.FILE_OR_DIRECTORY_SEARCH).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().jsonPath().getString("path");
    }
}
