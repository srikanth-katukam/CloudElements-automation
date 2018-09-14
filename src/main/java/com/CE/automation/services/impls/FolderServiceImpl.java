package com.CE.automation.services.impls;

import com.CE.automation.beans.Folder;
import com.CE.automation.dto.FolderDTO;
import com.CE.automation.helpers.CEAPIEndPoints;
import com.CE.automation.mappers.FolderMapper;
import com.CE.automation.services.FolderService;
import com.CE.automation.services.RequestFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/**
 * Created by Skatukam on 09/13/2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolderServiceImpl implements FolderService {
    public String createFolder(String json) throws JsonProcessingException {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(CEAPIEndPoints.CREATE_FOLDERS)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract()
                .response().jsonPath().getString("path");
    }

    public int deleteFolder(String targetFolderPath) {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .queryParam("path", targetFolderPath).when()
                .queryParam("emptyTrash", true).
                        delete(CEAPIEndPoints.DELETE_FOLDERS).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().getStatusCode();
    }

    public String getFolderId(String json) throws JsonProcessingException {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(CEAPIEndPoints.CREATE_FOLDERS)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract()
                .response().jsonPath().getString("id");
    }
    public String getFolderIdByMetadata(String targtFolderPath) {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .queryParam("path", targtFolderPath)
                .when()
                .get(CEAPIEndPoints.RETRIEVE_FOLDERS_METADATA)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract()
                .response().jsonPath().getString("id");
    }
    public int deleteFolderWithId(String targtFolderPath) throws JsonProcessingException {
        FolderServiceImpl folderService= new FolderServiceImpl();
                return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .pathParam("id", folderService.getFolderIdByMetadata(targtFolderPath))
                .queryParam("emptyTrash", true)
                .when()
                .delete(CEAPIEndPoints.DELETE_FOLDER).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().getStatusCode();
    }

    public String getFolderMetadata(String targtFolderPath){
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .queryParam("path", targtFolderPath).when().
                        get(CEAPIEndPoints.RETRIEVE_FOLDERS_METADATA).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().jsonPath().getString("path");
    }

    public String getFolderMetadataWithId(String targtFolderPath){
        FolderServiceImpl folderService= new FolderServiceImpl();
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .pathParam("id", folderService.getFolderIdByMetadata(targtFolderPath))
                .when().
                        get(CEAPIEndPoints.RETRIEVE_FOLDER_METADATA).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().jsonPath().getString("path");
    }

}

