/*
Класс-модель данных пользователя. Содержит необходимые обязательные и необязательные поля пользователя для регистрации
 */

package basic.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    //Обязательные поля
    private String name;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private Country country;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;

    //Необязательные поля
    private Gender gender;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String company;
    private String address2;

    @Getter
    public enum Gender {
        MR("Mr"),
        MRS("Mrs");

        private String displayGender;

        Gender(String displayGender) {
            this.displayGender = displayGender;
        }

    }

    @Getter
    public enum Country {
        IND("India"),
        USA("United States"),
        CAN("Canada"),
        AUS("Australia"),
        ISR("Israel"),
        NZL("New Zeeland"),
        SGP("Singapore");

        private String displayCountry;

        Country(String displayCountry) {
            this.displayCountry = displayCountry;
        }
    }
}
