package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserInfo {

    @JsonProperty("user")
    private GetUserInfo GetUserInfo;

    @JsonProperty("responseCode")
    private int responseCode;

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

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("title")
    private String title;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("birth_day")
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

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("email")
    private String email;
}
