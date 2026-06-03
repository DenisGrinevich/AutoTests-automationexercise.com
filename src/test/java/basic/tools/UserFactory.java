/*
Класс для создания пользователя
 */

package basic.tools;

import basic.model.User;

public class UserFactory {
    public static User defaultUser(){
        return User.builder()
                .email("james@test.test")
                .name("James")
                .password("james@test.test")
                .gender(User.Gender.MRS)
                .dayOfBirth("21")
                .monthOfBirth("5")
                .yearOfBirth("1995")
                .firstName("first")
                .lastName("last")
                .company("company")
                .address("address")
                .address2("none")
                .country(User.Country.USA)
                .state("NY")
                .city("New-York")
                .zipcode("123123")
                .mobileNumber("880005553535")
                .build();
    }
}
