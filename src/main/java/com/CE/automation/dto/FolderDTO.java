package com.CE.automation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Skatukam on 09/13/2018.
 */
@Getter
@Setter

public class FolderDTO {
    private String path;
    private boolean tags;
    private int page;
    private int pageSize;
}
