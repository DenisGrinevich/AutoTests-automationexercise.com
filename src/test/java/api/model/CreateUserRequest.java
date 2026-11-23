package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
public class CreateUserRequest {

    @JsonProperty("password")
    private String password;

    @JsonProperty("country")
    private String country;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("birth_month")
    private String birthMonth;

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("title")
    private String title;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("birth_date")
    private String birthDay;

    @JsonProperty("zipcode")
    private String zipcode;

    @JsonProperty("name")
    private String name;

    @JsonProperty("company")
    private String company;

    @JsonProperty("id")
    private int id;

    @JsonProperty("state")
    private String state;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mobile_number")
    private String mobileNumber;
}
