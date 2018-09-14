package com.CE.automation.services;

import com.CE.automation.dto.FileDTO;

/**
 * Created by Skatukam on 09/12/2018.
 */
public interface FileService {

    String getFiles(String targetFilePath);

    String getFileId(String targetFilePath);

    String uploadFiles(FileDTO fileDTO);

    int deleteFile(String targetFilePath);

    int deleteFileWithId(String targetFilePath);

    String getFileMetadata(String targetFilePath);

    String getFileIdByMetadata(String targetFilePath);

    public String getFileMetadataWithId(String targetFilePath);

}
