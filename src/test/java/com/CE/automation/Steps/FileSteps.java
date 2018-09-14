package com.CE.automation.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.CE.automation.dto.FileDTO;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import com.CE.automation.services.FileService;
import com.CE.automation.services.impls.FIleServiceImpl;

import java.util.List;

/**
 * Created by Skatukam on 09/12/2018.
 */
public class FileSteps {

    private String fileName;
    int statusCode;

    @Given("^I retrieve files using below data and file id$")
    public void fecthFileWithId(List<FileDTO> fileDTOList) {
        FileService fileService = new FIleServiceImpl();
        fileName = fileService.getFileId(fileDTOList.get(0).getFilePath());
        System.out.println(fileName);
    }

    @Given("^I retrieve files using below data$")
    public void fecthFiles(List<FileDTO> fileDTOList) {
        FileService fileService = new FIleServiceImpl();
        fileName = fileService.getFiles(fileDTOList.get(0).getFilePath());
        System.out.println(fileName);
    }

    @Given("^I Upload files using below data$")
    public void uploadFIles(List<FileDTO> fileDTOList) {
        FileService fileService = new FIleServiceImpl();
        fileName = fileService.uploadFiles(fileDTOList.get(0));
    }

    @Then("^I verify the file name$")
    public void verifyFileName(List<FileDTO> fileList) {
        Assert.assertTrue("Wrong file found !!!", fileName.contains(fileList.get(0).getName()));
    }
    @Given("^I delete file with below data$")
    public void deleteFile(List<FileDTO> fileDTOList) {
        FileService fileService = new FIleServiceImpl();
        statusCode = fileService.deleteFile(fileDTOList.get(0).getFilePath());
        System.out.println(statusCode);
    }

    @Given("^I delete file with below data and file id$")
    public void deleteFileWithId(List<FileDTO> fileDTOList) {
        FileService fileService = new FIleServiceImpl();
        statusCode = fileService.deleteFileWithId(fileDTOList.get(0).getFilePath());
        System.out.println(statusCode);
    }

    @Given("^I retrieve file meta using below data$")
    public void fetchFileMetadata(List<FileDTO> fileDTOList) {
        FileService fileService = new FIleServiceImpl();
        fileName = fileService.getFileMetadata(fileDTOList.get(0).getFilePath());
        System.out.println(fileName);
    }

    @Given("^I retrieve file meta using below data and file id$")
    public void fetchFileMetadataWithId(List<FileDTO> fileDTOList) {
        FileService fileService = new FIleServiceImpl();
        fileName = fileService.getFileMetadataWithId(fileDTOList.get(0).getFilePath ());
        System.out.println(fileName);
    }

    @And("^Verify file is deleted$")
    public void verifyFileIsDeleted() throws Throwable {
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }
}
