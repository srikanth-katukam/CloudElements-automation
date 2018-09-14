package com.CE.automation.beans;

import com.CE.automation.dto.FolderDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Skatukam on 09/13/2018.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Folder {
    private String name;
    private String path;
    private boolean tags;
    private int page;
    private int pageSize;


    }





