package com.CE.automation.helpers;

/**
 * Created by Skatukam on 09/11/2018.
 */
public class CEAPIEndPoints {
    public static final String BASE_URL = "https://staging.cloud-elements.com/elements/api-v2";
    //custom-fields-templates
    public static final String CREATE_CUSTOM_FIELDS_TEMPLATE = "/custom-fields-templates";
    public static final String RETRIEVE_CUSTOM_FIELDS_TEMPLATE = "/custom-fields-templates";
    public static final String RETRIEVE_CUSTOM_FIELD_TEMPLATE = "/custom-fields-templates/{templateKeyId}";
    public static final String DELETE_CUSTOM_FIELD_TEMPLATE = "/custom-fields-templates/{templateKeyId}";
    public static final String UPDATE_CUSTOM_FIELD_TEMPLATE = "/custom-fields-templates/{templateKeyId}";
    //File:
    public static final String UPLOAD_FILES = "/files";
    public static final String DELETE_FILES = "/files";
    public static final String RETRIEVE_FILES = "/files";
    public static final String DELETE_FILE = "/files/{id}";
    public static final String RETRIEVE_FILE = "/files/{id}";
    public static final String COPY_FILE = "/files/{id}/copy";
    public static final String CREATE_CUSTOM_FIELDS_FOR_FILE = "/files/{id}/custom-fields-templates/{templateKeyId}/custom-fields";
    public static final String DELETE_CUSTOM_FIEDLS_FOR_FILE = "/files/{id}/custom-fields-templates/{templateKeyId}/custom-fields";
    public static final String UPDATE_CUSTOM_FIELDS_FOR_FILE = "/files/{id}/custom-fields-templates/{templateKeyId}/custom-fields";
    public static final String RETURN_LINK_OF_FILE = "/files/{id}/links";
    public static final String REVOKE_LINK_OF_FILE = "/files/{id}/links";
    public static final String RETRIEVE_FILE_METADATA = "/files/{id}/metadata";
    public static final String UPDATE_FILE_METADATA = "/files/{id}/metadata";
    public static final String FIND_REVISIONS_OF_FILE = "/files/{id}/revisions";
    public static final String FIND_REVISION_OF_FILE = "/files/{id}/revisions/{revisionId}";
    public static final String COPY_FILES = "/files/copy";
    public static final String RETURN_LINK_FILES = "/files/links";
    public static final String REVOKE_LINK_FILES = "/files/links";
    public static final String RETRIEVE_FILES_METADATA = "/files/metadata";
    public static final String UPDATE_FILES_METADATA = "/files/metadata";
    public static final String FIND_REVISIONS_OF_FILES = "/files/revisions";
    public static final String FIND_REVISION_OF_FILES = "/files/revisions/{revisionId}";
    //Folder:
    public static final String DELETE_FOLDERS = "/folders";
    public static final String CREATE_FOLDERS = "/folders";
    public static final String DELETE_FOLDER = "/folders/{id}";
    public static final String LIST_OF_FILES_IN_FOLDER = "/folders/{id}/contents";
    public static final String COPY_FOLDER = "/folders/{id}/copy";
    public static final String RETRIEVE_FOLDER_METADATA = "/folders/{id}/metadata";
    public static final String UPDATE_FOLDER_METADATA = "/folders/{id}/metadata";
    public static final String LIST_OF_FILES_IN_FOLDERS = "/folders/contents";
    public static final String COPY_FOLDERS = "/folders/copy";
    public static final String RETRIEVE_FOLDERS_METADATA = "/folders/metadata";
    public static final String UPDATE_FOLDERS_METADATA = "/folders/metadata";
    //me
    public static final String GET_ME = "/me";
    //objects
    public static final String GET_OBJECTS = "/objects";
    public static final String GET_DOCS_FOR_OBJECT = "/objects/{objectName}/docs";
    public static final String GET_METADATA_OF_ALL_FILEDS_IN_OBJECTS = "/objects/{objectName}/metadata";
    //Search
    public static final String FILE_OR_DIRECTORY_SEARCH = "/search";
    public static final String PING = "/ping";
    public static final String RETRIEVE_STORAGE = "/storage";
}