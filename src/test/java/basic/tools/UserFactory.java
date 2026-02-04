package basic.tools;

import component.users.User;

public class UserFactory {
    public static User defaultUser(){
        return new User.Builder()
                .email("james@test.test")
                .name("James")
                .password("james@test.test")
                .gender(Constants.Gender.MRS)
                .dayOfBirth("21")
                .monthOfBirth("5")
                .yearOfBirth("1995")
                .firstName("first")
                .lastName("last")
                .company("company")
                .address("address")
                .address2("none")
                .country(Constants.Country.USA)
                .state("NY")
                .city("New-York")
                .zipcode("123123")
                .mobileNumber("880005553535")
                .build();
    }
}
