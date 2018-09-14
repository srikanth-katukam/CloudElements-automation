package com.CE.automation.Steps;

import com.CE.automation.dto.CommonDTO;
import com.CE.automation.services.CommonService;
import com.CE.automation.services.impls.CommonServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.util.List;

/**
 * Created by Skatukam on 09/14/2018.
 */
public class CommonSteps {
    private String endpoint;
    private int statusCode;
    private String path;
    @Given("^I ping the element$")
    public void verifyPing() {
        CommonService commonService=new CommonServiceImpl();
        endpoint=commonService.getPing();
        System.out.println("The element is:  "+endpoint);
    }
    @Then("^I verify ping data$")
    public void verifyPing(List<CommonDTO> commonDTOList) {
        Assert.assertTrue("Wrong file found !!!", endpoint.contains(commonDTOList.get(0).getEndPoint()));
    }
    @Given("^I retrieve available storage$")
    public void retrieveStorage() {
        CommonService commonService=new CommonServiceImpl();
        statusCode=commonService.retrieveStorage();
    }
    @Then("^I verify storage$")
    public void verifySrorage() {
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }

    @Given("^I perform a text search of file names and directory names$")
    public void searchFileAndFolder(List<CommonDTO> commonDTOs) {
        CommonService commonService=new CommonServiceImpl();
        path = commonService.getFileAndFolder(commonDTOs.get(0).getPath(),commonDTOs.get(0).getText());
        System.out.println("path is: "+path);
    }
    @Then("^I verify file and folder path$")
    public void verifyFolderAndFile(List<CommonDTO> commonDTOs) {
        CommonService commonService=new CommonServiceImpl();
        String pathString = commonDTOs.get(0).getPath()+"/"+commonDTOs.get(0).getText();
        System.out.println("path string is:"+pathString);
        Assert.assertTrue("Wrong file found !!!", path.contains(pathString));
    }
}
