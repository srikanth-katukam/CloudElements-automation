package com.CE.automation.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Skatukam on 09/12/2018.
 */
@Getter
@Setter
public class FileDTO {

    private String name;
    private String filePath;
    private String tags;
    private String description;
    private boolean overwrite;

}
