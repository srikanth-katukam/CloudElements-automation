package com.CE.automation.Steps;

import com.CE.automation.dto.FileDTO;
import com.CE.automation.dto.FolderDTO;
import com.CE.automation.dto.UserDTO;
import com.CE.automation.services.FolderService;
import com.CE.automation.services.UserService;
import com.CE.automation.services.impls.FolderServiceImpl;
import com.CE.automation.services.impls.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
/**
 * Created by Skatukam on 09/13/2018.
 */
public class FolderSteps {

    private String folderName;
    private String jsonString;
    int statusCode;

    @Given("^I create a folder using below data$")
    public void CreateFolder(List<FolderDTO> folderDTOs) throws JsonProcessingException {
        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        stringObjectMap.put("path",folderDTOs.get(0).getPath());
        JSONObject json = new JSONObject();
        json.putAll(stringObjectMap);
        System.out.println("Print :" +stringObjectMap);
        FolderService folderService=new FolderServiceImpl();
        jsonString=folderService.createFolder(json.toJSONString());
        System.out.println(jsonString);
    }

    @Given("^I delete folder with below data$")
    public void deleteFolder(List<FolderDTO> folderDTOs) {
        FolderService fileService = new FolderServiceImpl();
        statusCode = fileService.deleteFolder(folderDTOs.get(0).getPath());
        System.out.println(statusCode);
    }

    @Given("^I delete folder with below data associated with Id$")
    public void deleteFolderWithId(List<FolderDTO> folderDTOs) throws JsonProcessingException {
        FolderService fileService = new FolderServiceImpl();
        statusCode = fileService.deleteFolderWithId(folderDTOs.get(0).getPath());
        System.out.println(statusCode);
    }
    @Given("^I retrieve folder meta using below data$")
    public void fetchFolderMetadata(List<FolderDTO> folderDTOs) {
        FolderService fileService = new FolderServiceImpl();
        folderName = fileService.getFolderMetadata(folderDTOs.get(0).getPath());
        System.out.println(folderName);
    }

    @Given("^I retrieve folder meta using below data associated with Id$")
    public void fetchFolderMetadataWithId(List<FolderDTO> folderDTOs) {
        FolderService fileService = new FolderServiceImpl();
        folderName = fileService.getFolderMetadataWithId(folderDTOs.get(0).getPath());
        System.out.println(folderName);
    }

    @Then("^I verify the folder name$")
    public void verifyFileName(List<FolderDTO> folderDTOs) {
        Assert.assertTrue("Wrong file found !!!", folderName.contains(folderDTOs.get(0).getPath()));
    }
    @Then("^I verify the folder path")
    public void verifyFilepath(List<FolderDTO> folderDTOs) {
        Assert.assertTrue("Wrong file found !!!", jsonString.contains(folderDTOs.get(0).getPath()));
    }
    @And("^Verify folder is deleted$")
    public void verifyFolderIsDeleted() throws Throwable {
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }


}
