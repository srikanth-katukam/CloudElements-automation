package com.CE.automation.Steps;

import com.CE.automation.dto.UserDTO;
import com.CE.automation.services.UserService;
import com.CE.automation.services.impls.UserServiceImpl;
import cucumber.api.java.en.Given;
import org.junit.Assert;

import java.util.List;

/**
 * Created by Skatukam on 09/14/2018.
 */
public class UserSteps {
    private String login;
    @Given("^I get user information$")
    public void verifyUserInfo() {
        UserService userService=new UserServiceImpl();
        login = userService.getUserInfo();
    }
    @Given("^I verify user information$")
    public void verifyUserInfo(List<UserDTO> userDTOs) {
        Assert.assertTrue("Wrong file found !!!", login.contains(userDTOs.get(0).getLogin()));
    }
}
