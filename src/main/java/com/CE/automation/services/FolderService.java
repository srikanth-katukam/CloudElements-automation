package com.CE.automation.services;

import com.CE.automation.dto.FolderDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * Created by Skatukam on 09/13/2018.
 */
public interface FolderService {
    public String createFolder(String json) throws JsonProcessingException;
    public int deleteFolder(String targetFolderPath);
    public int deleteFolderWithId(String json) throws JsonProcessingException;
    public String getFolderIdByMetadata(String targtFolderPath);
    public String getFolderMetadata(String targtFolderPath);
    public String getFolderMetadataWithId(String targtFolderPath);

}
