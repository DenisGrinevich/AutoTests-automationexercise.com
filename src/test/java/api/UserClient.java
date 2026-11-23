package api;

import api.model.CreateUserRequest;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

//Класс, где реализована регистрация, удаление, получение информации о пользователе

public class UserClient {

    private final String REGISTER_PATH = "/api/createAccount";
    private final String USER_BY_ID = "/api/getUserDetailByEmail";

    public ValidatableResponse registerUser(CreateUserRequest request){
        return given()
                .config(RestAssured.config().encoderConfig(
                        EncoderConfig.encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.MULTIPART)
                ))
                .multiPart("name", request.getName())
                .multiPart("email", request.getEmail())
                .multiPart("password", request.getPassword())
                .multiPart("title", request.getTitle())
                .multiPart("birth_date", request.getBirthDay())
                .multiPart("birth_month", request.getBirthMonth())
                .multiPart("birth_year", request.getBirthYear())
                .multiPart("firstname", request.getFirstName())
                .multiPart("lastname", request.getLastName())
                .multiPart("company", request.getCompany())
                .multiPart("address1", request.getAddress1())
                .multiPart("address2", request.getAddress2())
                .multiPart("city", request.getCity())
                .multiPart("state", request.getState())
                .multiPart("zipcode", request.getZipcode())
                .multiPart("country", request.getCountry())
                .multiPart("mobile_number", request.getMobileNumber())
                .post(REGISTER_PATH).then();
    }

    public ValidatableResponse getUserInfo(String email){
        return given()
                .param("email",email)
                .get(USER_BY_ID)
                .then();
    }


}
