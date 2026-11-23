package tests;

import api.helpers.CreateUserRequestFactory;
import api.model.CreateUserRequest;
import api.UserClient;
import api.model.GetUserInfo;
import api.BaseAPITest;
import api.utils.HtmlJsonUtils;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;


public class APITests extends BaseAPITest {

    UserClient userClient = new UserClient();

    @Test
    public void testRegisterUser() {

        CreateUserRequest request = CreateUserRequestFactory.randomUser();

        int code = userClient.registerUser(request)
                .extract()
                .jsonPath()
                .get("responseCode");

        Assert.assertEquals(code, 201, String.format("Код ответа - %s", code));
    }

    @Test
    public void testGetUserInformation() {

        CreateUserRequest request = CreateUserRequestFactory.existingUser();

        ValidatableResponse response = userClient.getUserInfo(request.getEmail());

        GetUserInfo user2 = HtmlJsonUtils.extractAs(response, GetUserInfo.class)
                .getGetUserInfo();
        Get

        Assert.assertTrue(request.getName().equals(user2.getName()), String.format("Имя первого - %s, имя второго - %s", request.getName(), user2.getName()));
    }

}
