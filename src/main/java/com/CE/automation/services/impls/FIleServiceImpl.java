package com.CE.automation.services.impls;

import com.CE.automation.dto.FileDTO;
import com.CE.automation.helpers.CEAPIEndPoints;
import com.CE.automation.services.FileService;
import com.CE.automation.services.RequestFilter;
import com.google.common.base.Joiner;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.io.File;

import static io.restassured.RestAssured.given;

/**
 * Created by Skatukam on 09/12/2018.
 */
public class FIleServiceImpl implements FileService {

    public String getFileIdByMetadata(String targetFilePath) {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .queryParam("path", targetFilePath).when().
                        get(CEAPIEndPoints.RETRIEVE_FILES_METADATA).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().jsonPath().getString("id");
    }

    public String getFileId(String targetFilePath) {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",getFileIdByMetadata(targetFilePath))
                .get(CEAPIEndPoints.RETRIEVE_FILE)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract()
                .response().getHeader("Content-Disposition");
    }

    public String getFiles(String targetFilePath) {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .queryParam("path", targetFilePath).when().
                        get(CEAPIEndPoints.RETRIEVE_FILES).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().getHeader("Content-Disposition");
    }

    public String uploadFiles(FileDTO fileDTO) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(Joiner.on("/").join("Documents", fileDTO.getName())).getFile());
        return given().filter(new RequestFilter()).log().all()
                .contentType("multipart/form-data")
                .multiPart("file", file)
                .queryParam("path", fileDTO.getFilePath())
                .queryParam("tags", fileDTO.getTags())
                .queryParam("description", fileDTO.getDescription())
                .queryParam("overwrite", fileDTO.isOverwrite())
                .when()
                .post(CEAPIEndPoints.RETRIEVE_FILES)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract()
                .response().jsonPath().get("path");
    }

    public int deleteFileWithId(String targetFilePath) {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",getFileIdByMetadata(targetFilePath))
                .queryParam("emptyTrash", true).when()
                .delete(CEAPIEndPoints.DELETE_FILE)
                .then().log().all().extract().response().getStatusCode();
    }

    public int deleteFile(String targetFilePath) {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .queryParam("path", targetFilePath)
                .queryParam("emptyTrash", true).when()
                .delete(CEAPIEndPoints.DELETE_FILES)
                .then().log().all().extract().response().getStatusCode();
    }

    public String getFileMetadata(String targetFilePath) {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .queryParam("path", targetFilePath).when().
                        get(CEAPIEndPoints.RETRIEVE_FILES_METADATA).
                        then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().
                        response().jsonPath().getString("name");
    }

    public String getFileMetadataWithId(String targetFilePath) {
        return given().filter(new RequestFilter()).log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",getFileIdByMetadata(targetFilePath))
                .when()
                .get(CEAPIEndPoints.RETRIEVE_FILE_METADATA)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract()
                .response().jsonPath().getString("name");
    }
}
