package api.helpers;

import api.model.CreateUserRequest;
import basic.model.User;
import basic.tools.RandomData;


public class CreateUserRequestFactory {

    public static CreateUserRequest defaultUser() {
        return CreateUserRequest.builder()
                .email("james@test.test")
                .name("James")
                .password("james@test.test")
                .title(User.Gender.MRS.getDisplayGender())
                .birthDay("21")
                .birthMonth("5")
                .birthYear("1995")
                .firstName("first")
                .lastName("last")
                .company("company")
                .address1("address")
                .address2("none")
                .country(User.Country.USA.getDisplayCountry())
                .state("NY")
                .city("New-York")
                .zipcode("123123")
                .mobileNumber("880005553535")
                .build();
    }

    public static CreateUserRequest existingUser() {
        return CreateUserRequest.builder()
                .email("test0306@n.net")
                .name("qweqweqwe")
                .password("Qw123123123")
                .build();
    }

    public static CreateUserRequest randomUser() {
        return CreateUserRequest.builder()
                .email("james@test" + RandomData.randomNumber() + ".test")
                .name("James" + RandomData.randomNumber())
                .password("james@test.test" + RandomData.randomNumber())
                .title(User.Gender.MRS.getDisplayGender())
                .birthDay("21")
                .birthMonth("5")
                .birthYear("1995")
                .firstName("first" + RandomData.randomNumber())
                .lastName("last" + RandomData.randomNumber())
                .company("company" + RandomData.randomNumber())
                .address1("address" + RandomData.randomNumber())
                .address2("none" + RandomData.randomNumber())
                .country(User.Country.USA.getDisplayCountry())
                .state("NY")
                .city("New-York")
                .zipcode("123123")
                .mobileNumber("880005553535")
                .build();
    }

}
